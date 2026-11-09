package com.moviebox.ui

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltNavHost
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHostDestination
import androidx.navigation.composable
import com.moviebox.storage.ConfigStore
import com.moviebox.storage.HistoryStore
import com.moviebox.storage.FavoritesStore
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.Hilt
import kotlinx.coroutines.sync.Mutex

@Hilt
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ConfigStore.init(this)
        HistoryStore.init(this)
        FavoritesStore.init(this)
        setContent {
            MovieBoxApplication()
        }
    }
}

@Composable
fun MovieBoxApplication() {
    val context = remember { LocalContext.current }

    // Initialize singleton stores
    DisposableEffect(Unit) {
        ConfigStore.instance?.apply { init(context) }
        HistoryStore.instance?.apply { init(context) }
        FavoritesStore.instance?.apply { init(context) }
        cleanup { /* cleanup on composition drop */ }
    }

    val navController = rememberNavController()

    ScaffoldTheme(
        // Apply the selected theme
        MaterialTheme,
    ) {
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.fillMaxSize(),
        ) {
            composable("home") {
                HomeScreen(
                    onSelectMovie = { movieId ->
                        // Navigate to details or handle movie selection
                    },
                    onSelectSeries = { seriesId ->
                        // Navigate to series details
                    },
                    onSearch = { query ->
                        // Handle search
                    },
                    onSettings = { /* open settings */ },
                    onTvMode = { /* toggle TV mode */ },
                    state = remember { AppStateUi() },
                )
            }

            composable("details/{id}") { backStackEntry ->
                val id = backStackEntry.args?.getString("id") ?: ""
                val details = remember { MediaDetails(
                    id = com.moviebox.model.ProviderMediaId(
                        com.moviebox.model.ProviderKind.MovieBox,
                        id
                    ),
                    title = "Unknown Title",
                    mediaType = com.moviebox.model.MediaType.Movie,
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
                )}
                val releases = remember { emptyList<com.moviebox.model.Release>() }

                DetailsScreen(
                    details = details,
                    releases = releases,
                    onPlay = { release ->
                        // Handle playback
                    },
                    onDownload = { release ->
                        // Handle download
                    },
                    onBack = { navController.popBackStack() },
                    state = remember { AppStateUi() },
                )
            }
        }
    }
}