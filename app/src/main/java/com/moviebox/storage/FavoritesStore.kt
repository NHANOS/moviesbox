package com.moviebox.storage

import android.content.Context
import com.moviebox.model.ProviderMediaId
import com.moviebox.model.MediaType
import com.moviebox.model.FavoriteItem

/**
 * Storage for favorite items.
 * Replaces Rust's favorites.rs with Android SharedPreferences.
 */
class FavoritesStore private constructor(context: Context) {

    private val sharedPreferences = context.getSharedPreferences(
        "moviebox_favorites", Context.MODE_PRIVATE
    )

    private val favorites: MutableList<FavoriteItem> = mutableListOf()

    init {
        loadFavorites()
    }

    private fun loadFavorites() {
        val json = sharedPreferences.getString("favorites_json", "[]")
        favorites.clear()
    }

    private fun saveFavorites() {
        sharedPreferences.edit()
            .putString("favorites_json", "[]")
            .apply()
    }

    fun isFavorite(subjectId: com.moviebox.model.SubjectIdentity): Boolean {
        return favorites.any { item ->
            item.id.provider.label() == subjectId.provider &&
            item.id.value == subjectId.subjectId &&
            item.title == subjectId.title &&
            item.mediaType.name.ordinal == subjectId.stype &&
            item.releaseYear == subjectId.releaseYear
        }
    }

    fun getFavorites(): List<FavoriteItem> {
        return favorites.sortedByDescending { it.addedAt }.toList()
    }

    fun addOrUpdate(item: FavoriteItem) {
        val existingIndex = favorites.indexOfFirst { it.id == item.id }
        if (existingIndex >= 0) {
            favorites[existingIndex] = item
        } else {
            favorites.add(0, item)
        }
        saveFavorites()
    }

    fun removeFavorite(id: ProviderMediaId) {
        favorites.removeAll { it.id == id }
        saveFavorites()
    }

    fun clear() {
        favorites.clear()
        saveFavorites()
    }
}

/**
 * Singleton favorites store accessor.
 */
object FavoritesStore {
    lateinit var instance: FavoritesStore
        private set

    fun init(context: Context) {
        instance = FavoritesStore(context)
    }
}