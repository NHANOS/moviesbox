package com.moviebox.provider

import com.moviebox.model.CatalogItem
import com.moviebox.model.MediaDetails
import com.moviebox.model.ProviderError
import com.moviebox.model.ProviderKind
import com.moviebox.model.ProviderMediaId
import com.moviebox.model.PlaybackSource
import com.moviebox.model.Release
import com.moviebox.model.Result

/**
 * DhakaFlix (BDIX) provider implementation.
 * Mirrors the structure from src/providers/bdix/dhakaflix/ in the original Rust codebase.
 */
class DhakaFlixProvider(
    override val kind: ProviderKind = ProviderKind.BdixDhakaflix,
    httpClient: com.moviebox.network.HttpClient
) : com.moviebox.provider.BaseProvider(kind, httpClient) {

    override val capabilities: com.moviebox.provider.ProviderCapabilities =
        com.moviebox.provider.ProviderCapabilities(
            supportsSearch = true,
            supportsPagination = false,
            supportsSeries = true,
            supportsSubtitles = true,
            supportsHomepage = false
        )

    private const val TAG = "DhakaFlixProvider"

    override suspend fun search(query: String, page: Int = 1): Result<List<CatalogItem>> {
        return Result.success(emptyList())
    }

    override suspend fun details(id: String): Result<MediaDetails> {
        return Result.success(MediaDetails(
            id = ProviderMediaId(kind, id),
            title = "Unknown Title",
            mediaType = MediaType.Movie,
            year = null,
            description = null,
            tagline = null,
            imdbRating = null,
            director = null,
            stars = null,
            prints = null,
            audios = null,
            posterUrl = null,
            duration = null,
            genres = emptyList(),
            seasons = emptyList(),
            dubs = emptyList()
        ))
    }

    override suspend fun episodeStreams(
        id: String,
        season: Int,
        episode: Int
    ): Result<List<Release>> {
        return Result.success(emptyList())
    }

    override suspend fun playbackSource(
        url: String,
        headers: List<(String, String)> = emptyList()
    ): Result<PlaybackSource> {
        return Result.success(PlaybackSource(
            provider = kind,
            url = url,
            headers = headers,
            subtitle = null,
            sourceLabel = kind.label(),
            maxHeight = null
        ))
    }
}