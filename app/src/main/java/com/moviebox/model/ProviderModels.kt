package com.moviebox.model

/**
 * Provider kind enum matching the Rust code.
 */
enum class ProviderKind {
    MovieBox,
    FourKHdHub,
    BdixCircleFtp,
    BdixDhakaflix,
    Dramachi,
    Addons;

    fun label(): String = when (this) {
        ProviderKind.MovieBox -> "MovieBox"
        ProviderKind.FourKHdHub -> "4KHDHub"
        ProviderKind.BdixCircleFtp -> "CircleFTP (BDIX)"
        ProviderKind.BdixDhakaflix -> "DhakaFlix (BDIX)"
        ProviderKind.Dramachi -> "Dramachi"
        ProviderKind.Addons -> "Addons"
    }

    fun cacheKey(): String = when (this) {
        ProviderKind.MovieBox -> "moviebox"
        ProviderKind.FourKHdHub -> "fourkhdhub"
        ProviderKind.BdixCircleFtp -> "bdix_circleftp"
        ProviderKind.BdixDhakaflix -> "bdix_dhakaflix"
        ProviderKind.Dramachi -> "dramachi"
        ProviderKind.Addons -> "addons"
    }

    fun isBdix(): Boolean = this == ProviderKind.BdixCircleFtp || this == ProviderKind.BdixDhakaflix

    companion object {
        fun parse(value: String): ProviderKind? {
            val normalized = value.trim().lowercase().replace(Regex("[_-]"), "")
            return when (normalized) {
                "moviebox", "movie_box" -> MovieBox
                "4khdhub", "fourkhdhub" -> FourKHdHub
                "bdix_circleftp", "bdixcircleftp", "circleftp(bdix)" -> BdixCircleFtp
                "bdix_dhakaflix", "bdixdhakaflix", "dhakaflix(bdix)" -> BdixDhakaflix
                "addons", "addon" -> Addons
                "dramachi" -> Dramachi
                else -> null
            }
        }
    }
}

/**
 * Represents a media identifier combining provider and value.
 */
data class ProviderMediaId(
    val provider: ProviderKind,
    val value: String
)

/**
 * The type of media (Movie or Series).
 */
enum class MediaType {
    Movie,
    Series
}

/**
 * A catalog item returned from provider search/details.
 */
data class CatalogItem(
    val id: ProviderMediaId,
    val title: String,
    val mediaType: MediaType,
    val year: String?,
    val posterUrl: String?,
    val seasonCount: Int?
)

/**
 * An episode of a TV series.
 */
data class Episode(
    val season: Int,
    val number: Int,
    val title: String?,
    val overview: String?
)

/**
 * A season of a TV series.
 */
data class Season(
    val number: Int,
    val episodes: List<Episode>
)

/**
 * Audio track options with language information.
 */
data class AudioTrackOption(
    val subjectId: String,
    val language: String,
    val label: String
)

/**
 * Detailed media information from a provider.
 */
data class MediaDetails(
    val id: ProviderMediaId,
    val title: String,
    val mediaType: MediaType,
    val year: String?,
    val description: String?,
    val tagline: String?,
    val imdbRating: String?,
    val director: String?,
    val stars: String?,
    val prints: String?,
    val audios: String?,
    val posterUrl: String?,
    val duration: String?,
    val genres: List<String>,
    val seasons: List<Season>,
    val dubs: List<AudioTrackOption>
)

/**
 * A source mirror with resolver URL and headers.
 */
data class SourceMirror(
    val label: String,
    val resolverUrl: String,
    val headers: List<(String, String)>,
    val directFile: Boolean
)

/**
 * A release (downloadable stream) with mirrors.
 */
data class Release(
    val provider: ProviderKind,
    val filename: String,
    val quality: String?,
    val codec: String?,
    val language: String?,
    val sizeBytes: Long?,
    val season: Int?,
    val episode: Int?,
    val mirrors: List<SourceMirror>,
    val resourceId: String?
)

/**
 * Playback source for a stream.
 */
data class PlaybackSource(
    val provider: ProviderKind,
    val url: String,
    val headers: List<(String, String)>,
    val subtitle: String?,
    val sourceLabel: String,
    val maxHeight: Int?
)

/**
 * Search result with additional metadata.
 */
data class SearchResult(
    val id: String,
    val title: String,
    val stype: Int,
    val releaseYear: String?,
    val coverUrl: String?,
    val season: Int?,
    val episode: Int?,
    val provider: ProviderKind
)

/**
 * Browse metrics for layout calculations.
 */
data class BrowseMetrics(
    val trending: Float?,
    val rating: Float?,
    val recentRating: Float?,
    val popularity: Float?
)

/**
 * Identity for favorite tracking.
 */
data class SubjectIdentity(
    val provider: String,
    val subjectId: String,
    val title: String,
    val stype: Int,
    val releaseYear: String?
)

/**
 * A watch history item tracking playback progress.
 */
data class WatchHistoryItem(
    val id: ProviderMediaId,
    val title: String,
    val mediaType: MediaType,
    val season: Int?,
    val episode: Int?,
    val watchedBytes: Long,
    val totalBytes: Long?,
    val timestamp: Long,
    var progress: Double,
    var isCompleted: Boolean,
    var lastWatched: Long
)

/**
 * A favorite item saved by the user.
 */
data class FavoriteItem(
    val id: ProviderMediaId,
    val title: String,
    val mediaType: MediaType,
    val coverUrl: String?,
    val releaseYear: String?,
    val addedAt: Long
)

/**
 * Provider capabilities indicating what features a provider supports.
 */
data class ProviderCapabilities(
    val supportsSearch: Boolean,
    val supportsPagination: Boolean,
    val supportsSeries: Boolean,
    val supportsSubtitles: Boolean,
    val supportsHomepage: Boolean
) {
    companion object {
        fun default(): ProviderCapabilities = ProviderCapabilities(
            supportsSearch = true,
            supportsPagination = false,
            supportsSeries = true,
            supportsSubtitles = true,
            supportsHomepage = false
        )
    }
}

/**
 * Enumeration of errors that can occur when using providers.
 */
sealed class ProviderError : Exception {
    data class Network(val message: String) : ProviderError()
    data class RateLimited(val waitSeconds: Long?) : ProviderError()
    data class NotFound : ProviderError()
    data class Parsing(val message: String) : ProviderError()
    data class Unavailable(val message: String) : ProviderError()

    fun userMessage(provider: ProviderKind): String {
        val label = when (provider) {
            ProviderKind.BdixCircleFtp -> "CircleFTP"
            ProviderKind.BdixDhakaflix -> "DhakaFlix"
            else -> provider.label()
        }

        return when (this) {
            is Network -> {
                val msg = this.message.lowercase()
                if (provider.isBdix()) {
                    "$label unreachable: requires BDIX network."
                } else if (msg.contains("timed out")) {
                    "$label timed out."
                } else {
                    "Cannot reach $label."
                }
            }
            is RateLimited -> {
                val seconds = waitSeconds?.let { "Wait ${it}s." } ?: "Try later."
                "Rate limited. $seconds"
            }
            is NotFound -> "No results found."
            is Parsing -> "${label} parse error."
            is Unavailable -> {
                val msg = this.message.trim()
                if (msg.startsWith("HTTP status ")) {
                    val status = msg.removePrefix("HTTP status ")
                    "$label error ($status)."
                } else if (msg.isEmpty()) {
                    "$label unavailable."
                } else {
                    "$label unavailable: $msg"
                }
            }
        }
    }
}

/**
 * Utility functions for string processing.
 */
object StringUtils {
    fun stripEmojis(input: String): String {
        return input.replace(Regex("[ἀ-ᾯ☀-➿⌀-⏿⬀-⯿︀-️]"), "")
    }

    fun cleanStreamText(input: String): String {
        val withoutEmojis = stripEmojis(input)
        val result = StringBuilder()
        var lastWasSpace = false
        for (c in withoutEmojis) {
            if (c.isWhitespace()) {
                if (!lastWasSpace && result.isNotEmpty()) {
                    result.append(' ')
                    lastWasSpace = true
                }
            } else {
                result.append(c)
                lastWasSpace = false
            }
        }
        return result.toString().trim()
    }

    fun extract4DigitYear(raw: String): String {
        val pattern = "1[89]\\d{2}".toRegex()
        val matcher = pattern.find(raw)
        return matcher?.value ?: ""
    }

    fun parseSizeBytes(text: String): Long? {
        val parts = text.split(Regex("\\s+"))
        for (i in 0 until parts.size - 1) {
            val clean = parts[i].trim()
            try {
                val num = clean.toDouble()
                val unit = parts[i + 1].uppercase().trim()
                when (unit) {
                    "TB", "TIB", "T" -> return (num * 1_099_511_627_776.0).toLong()
                    "GB", "GIB", "G" -> return (num * 1_073_741_824.0).toLong()
                    "MB", "MIB", "M" -> return (num * 1_048_576.0).toLong()
                    "KB", "KIB", "K" -> return (num * 1_024.0).toLong()
                }
            } catch (e: Exception) {
                continue
            }
        }
        return null
    }
}