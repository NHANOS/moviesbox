package com.moviebox.storage

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.moviebox.model.ProviderKind

/**
 * Storage for MovieBox application configuration.
 * Replaces Rust's config.rs with Android SharedPreferences and DataStore.
 */
class ConfigStore private constructor(context: Context) {

    private val sharedPreferences = context.getSharedPreferences(
        "moviebox_config", Context.MODE_PRIVATE
    )

    val autoUpdate: Boolean
        get() = sharedPreferences.getBoolean("auto_update", true)

    val lastUpdateCheck: Long
        get() = sharedPreferences.getLong("last_update_check", 0)

    val activeMode: String
        get() = sharedPreferences.getString("active_mode", "streaming") ?: "streaming"

    val activeProvider: ProviderKind
        get() = ProviderKind.parse(
            sharedPreferences.getString("active_provider", "moviebox") ?: ""
        ) ?: ProviderKind.MovieBox

    val activeTheme: String
        get() = sharedPreferences.getString("active_theme", "") ?: ""

    val movieboxEnabled: Boolean
        get() = sharedPreferences.getBoolean("moviebox_enabled", true)

    val fourkhdhubEnabled: Boolean
        get() = sharedPreferences.getBoolean("fourkhdhub_enabled", true)

    val dramachiEnabled: Boolean
        get() = sharedPreferences.getBoolean("dramachi_enabled", true)

    val bdixCircleftpEnabled: Boolean
        get() = sharedPreferences.getBoolean("bdix_circleftp_enabled", false)

    val bdixDhakaflixEnabled: Boolean
        get() = sharedPreferences.getBoolean("bdix_dhakaflix_enabled", false)

    val bdixProbed: Boolean
        get() = sharedPreferences.getBoolean("bdix_probed", false)

    val streamingEnabled: Boolean
        get() = sharedPreferences.getBoolean("streaming_enabled", true)

    val tvEnabled: Boolean
        get() = sharedPreferences.getBoolean("tv_enabled", true)

    val addonsEnabled: Boolean
        get() = sharedPreferences.getBoolean("addons_enabled", false)

    val defaultPlayer: String?
        get() = sharedPreferences.getString("default_player", null)

    val downloadDir: String?
        get() = sharedPreferences.getString("download_dir", null)

    val mpvPath: String?
        get() = sharedPreferences.getString("mpv_path", null)

    val vlcPath: String?
        get() = sharedPreferences.getString("vlc_path", null)

    val iinaPath: String?
        get() = sharedPreferences.getString("iina_path", null)

    val clearCache(): Boolean = sharedPreferences.getBoolean("clear_cache", false)

    fun updateConfig(
        autoUpdate: Boolean? = null,
        lastUpdateCheck: Long? = null,
        activeMode: String? = null,
        activeProvider: ProviderKind? = null,
        activeTheme: String? = null,
        movieboxEnabled: Boolean? = null,
        fourkhdhubEnabled: Boolean? = null,
        dramachiEnabled: Boolean? = null,
        bdixCircleftpEnabled: Boolean? = null,
        bdixDhakaflixEnabled: Boolean? = null,
        bdixProbed: Boolean? = null,
        streamingEnabled: Boolean? = null,
        tvEnabled: Boolean? = null,
        addonsEnabled: Boolean? = null,
        defaultPlayer: String? = null,
        downloadDir: String? = null,
        mpvPath: String? = null,
        vlcPath: String? = null,
        iinaPath: String? = null,
        clearCache: Boolean? = null
    ) {
        sharedPreferences.edit().apply {
            autoUpdate?.let { putBoolean("auto_update", it) }
            lastUpdateCheck?.let { putLong("last_update_check", it) }
            activeMode?.let { putString("active_mode", it) }
            activeProvider?.let { putString("active_provider", it.name) }
            activeTheme?.let { putString("active_theme", it) }
            movieboxEnabled?.let { putBoolean("moviebox_enabled", it) }
            fourkhdhubEnabled?.let { putBoolean("fourkhdhub_enabled", it) }
            dramachiEnabled?.let { putBoolean("dramachi_enabled", it) }
            bdixCircleftpEnabled?.let { putBoolean("bdix_circleftp_enabled", it) }
            bdixDhakaflixEnabled?.let { putBoolean("bdix_dhakaflix_enabled", it) }
            bdixProbed?.let { putBoolean("bdix_probed", it) }
            streamingEnabled?.let { putBoolean("streaming_enabled", it) }
            tvEnabled?.let { putBoolean("tv_enabled", it) }
            addonsEnabled?.let { putBoolean("addons_enabled", it) }
            defaultPlayer?.let { putString("default_player", it) }
            downloadDir?.let { putString("download_dir", it) }
            mpvPath?.let { putString("mpv_path", it) }
            vlcPath?.let { putString("vlc_path", it) }
            iinaPath?.let { putString("iina_path", it) }
            clearCache?.let { putBoolean("clear_cache", it) }
        }.apply()
    }
}

/**
 * Singleton config store accessor.
 */
object ConfigStore {
    lateinit var instance: ConfigStore
        private set

    fun init(context: Context) {
        instance = ConfigStore(context)
    }
}
