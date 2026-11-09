package com.moviebox.storage

import android.content.Context
import com.moviebox.model.ProviderMediaId
import com.moviebox.model.WatchHistoryItem
import com.moviebox.model.MediaType
import java.util.*
import kotlin.collections.ArrayList

/**
 * Storage for watch history.
 * Replaces Rust's history.rs with Android SharedPreferences/Room.
 */
class HistoryStore private constructor(context: Context) {

    private val sharedPreferences = context.getSharedPreferences(
        "moviebox_history", Context.MODE_PRIVATE
    )

    private val history: MutableList<WatchHistoryItem> = mutableListOf()

    init {
        loadHistory()
    }

    private fun loadHistory() {
        val json = sharedPreferences.getString("history_json", "[]")
        // In a full implementation, we'd use Gson to parse this
        history.clear()
    }

    private fun saveHistory() {
        // In a full implementation, we'd use Gson to serialize
        sharedPreferences.edit()
            .putString("history_json", "[]")
            .apply()
    }

    fun getRecent(limit: Int = 50): List<WatchHistoryItem> {
        return history.take(limit)
    }

    fun getAll(): List<WatchHistoryItem> {
        return history.toList()
    }

    fun addOrUpdate(item: WatchHistoryItem) {
        val existingIndex = history.indexOfFirst {
            it.id == item.id && it.season == item.season && it.episode == item.episode
        }
        if (existingIndex >= 0) {
            history[existingIndex] = item
        } else {
            history.add(0, item)
        }
        // Keep only last 200 items
        if (history.size > 200) {
            history.removeLast()
        }
        saveHistory()
    }

    fun updateProgress(
        providerMediaId: ProviderMediaId,
        season: Int?,
        episode: Int?,
        watchedBytes: Long,
        totalBytes: Long?,
        completed: Boolean
    ) {
        val existingIndex = history.indexOfFirst {
            it.id == providerMediaId &&
            it.season == season &&
            it.episode == episode
        }

        val item = if (existingIndex >= 0) {
            val existing = history[existingIndex]
            existing.copy(
                watchedBytes = watchedBytes,
                totalBytes = totalBytes,
                progress = if (totalBytes != null && totalBytes > 0)
                    (watchedBytes.toDouble() / totalBytes * 100).toInt()
                else 0,
                isCompleted = completed,
                lastWatched = System.currentTimeMillis()
            )
        } else {
            WatchHistoryItem(
                id = providerMediaId,
                title = "",
                mediaType = MediaType.Movie,
                season = season,
                episode = episode,
                watchedBytes = watchedBytes,
                totalBytes = totalBytes,
                timestamp = System.currentTimeMillis(),
                progress = if (totalBytes != null && totalBytes > 0)
                    (watchedBytes.toDouble() / totalBytes * 100).toInt()
                else 0,
                isCompleted = completed,
                lastWatched = System.currentTimeMillis()
            )
        }

        if (existingIndex >= 0) {
            history[existingIndex] = item
        } else {
            history.add(0, item)
        }
        saveHistory()
    }

    fun getItem(
        providerMediaId: ProviderMediaId,
        season: Int?,
        episode: Int?
    ): WatchHistoryItem? {
        return history.firstOrNull {
            it.id == providerMediaId &&
            it.season == season &&
            it.episode == episode
        }
    }

    fun removeItem(providerMediaId: ProviderMediaId, season: Int?, episode: Int?) {
        history.removeAll { it.id == providerMediaId && it.season == season && it.episode == episode }
        saveHistory()
    }

    fun clear() {
        history.clear()
        saveHistory()
    }

    fun getInProgress(): List<WatchHistoryItem> {
        return history.filter { it.progress > 0 && it.progress < 100 && !it.isCompleted }
            .sortedByDescending { it.lastWatched }
    }
}

/**
 * Singleton history store accessor.
 */
object HistoryStore {
    lateinit var instance: HistoryStore
        private set

    fun init(context: Context) {
        instance = HistoryStore(context)
    }
}