# MovieBox Android App

Android port of MovieBox-TUI - a terminal interface to find, download, and stream movies, TV shows, and live TV using local media players.

## Project Structure

```
/root/MovieBox/
├── build.gradle.kts              # Root Gradle settings
├── settings.gradle.kts           # Settings file
├── gradle/libs.versions.toml     # Dependency versions catalog
├── app/
│   ├── build.gradle.kts          # App-level Gradle build
│   ├── proguard-rules.pro        # ProGuard rules
│   └── src/main/
│       ├── AndroidManifest.xml   # App manifest with permissions
│       ├── res/
│       │   └── values/
│       │       ├── colors.xml    # Color definitions
│       │       ├── strings.xml   # String resources
│       │       └── themes.xml    # Theme definitions
│       └── java/com/moviebox/
│           ├── MovieBoxApplication.kt   # Hilt Application class
│           ├── app/MainActivity.kt      # Entry point Activity
│           ├── model/
│           │   └── ProviderModels.kt    # Data models (CatalogItem, MediaDetails, Release, etc.)
│           ├── network/
│           │   └── HttpClient.kt        # OkHttp client for API requests
│           ├── player/
│           │   └── MovieBoxPlayer.kt    # ExoPlayer-based media player
│           ├── provider/
│           │   ├── BaseProvider.kt      # Base provider with common logic
│           │   ├── MovieBoxProvider.kt   # MovieBox API scraper
│           │   ├── FourKHDHubProvider.kt # 4KHDHub scraper
│           │   ├── DramachiProvider.kt   # Dramachi scraper
│           │   ├── CircleFtpProvider.kt  # CircleFTP (BDIX) scraper
│           │   ├── DhakaFlixProvider.kt  # DhakaFlix (BDIX) scraper
│           │   └── AddonsProvider.kt     # Addons scraper
│           ├── storage/
│           │   ├── ConfigStore.kt       # Configuration persistence
│           │   ├── HistoryStore.kt      # Watch history persistence
│           │   └── FavoritesStore.kt    # Favorites persistence
│           └── ui/
│               ├── theme/
│               │   ├── ComposeTheme.kt  # Compose Material3 theming
│               │   └── Theme.kt         # Color schemes for 9 themes
│               ├── CatalogScreen.kt     # Search results / catalog listing
│               ├── DetailsScreen.kt     # Media details / stream selection
│               ├── HomeScreen.kt        # Home screen with search bar
│               ├── SettingsScreen.kt    # Settings UI
│               └── MovieBoxComposeApp.kt # Compose navigation host
```

## Features Implemented

### 1. Codebase & Logic Migration
- All provider adapters ported: MovieBox, 4KHDHub, Dramachi, CircleFTP (BDIX), DhakaFlix (BDIX), Addons
- Provider interfaces with search, details, episode streams
- Provider error handling matching Rust `ProviderError` variants
- Provider capabilities flags (search, pagination, series, subtitles, homepage)
- Media data models: ProviderMediaId, CatalogItem, MediaDetails, Episode, Season, Release, SourceMirror, PlaybackSource

### 2. Built-in Media Player
- ExoPlayer integration with adaptive streaming (HLS, DASH)
- Headers/cookies forwarding (User-Agent, Referer, Cookie)
- Subtitle support (SRT, VTT, ASS, SSA)
- Playback position tracking and progress percentage
- Stream proxy/cookie forwarding support

### 3. User Interface
- Material3 Compose UI with Jetpack Compose
- 9 visual themes: Mocha, Latte, Macchiato, Frappe, Nord, TokyoNight, Dracula, Gruvbox, RosePine
- Home screen with search bar, provider pills, landing deck
- Catalog screen with grid/list views
- Details screen with seasons/episodes, releases with play/download actions
- Settings screen with theme selection, provider toggles, player path configuration
- Bottom navigation bar with Stream/TV/Help/Quit actions

### 4. Storage & Persistence
- ConfigStore: SharedPreferences-based configuration
- HistoryStore: Watch history with playback position tracking
- FavoritesStore: Favorite items with SubjectIdentity tracking
- Room database support configured (entities/DAOs can be added)

### 5. Permissions
- INTERNET, ACCESS_NETWORK_STATE, ACCESS_WIFI_STATE
- WRITE_EXTERNAL_STORAGE, READ_EXTERNAL_STORAGE
- FOREGROUND_SERVICE, FOREGROUND_SERVICE_MEDIA_PLAYBACK
- ACCESS_MEDIA_LOCATION

## Build Instructions

### Requirements
- Android Studio Hedgehog (2023.1.1) or later
- JDK 17
- Android SDK 34 (compileSdk 34)

### Build

```bash
cd /root/MovieBox

# Build debug APK
./gradlew assembleDebug

# Build release APK (requires signing config)
./gradlew assembleRelease

# Install on connected device
./gradlew installDebug
```

### Output
- Debug APK: `app/build/outputs/apk/debug/app-debug.apk`
- Release APK: `app/build/outputs/apk/release/app-release.apk`

## Migration Notes

The original Rust codebase used:
- `ratatui` for terminal UI → Replaced with Jetpack Compose Material3
- `reqwest` for HTTP → Replaced with OkHttp
- `mpv/VLC/IINA` external players → Replaced with ExoPlayer built-in
- `dirs` crate for config → Replaced with Android Context/SharedPreferences
- `tokio` async runtime → Replaced with Kotlin Coroutines
- `serde_json` for serialization → Replaced with Gson/Kotlin serialization

### Not Implemented (would require full API implementation)
- Actual MovieBox API endpoints (crypto headers, session management)
- M3U playlist/EPG parsing for live TV
- Multi-part segmented downloader with pause/resume
- Update checker/self-updater
- TV playlists manager
- Addon manifest catalog browsing
