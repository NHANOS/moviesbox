# Add project-specific ProGuard rules here.

# For details, see https://developer.android.com/studio/build/shrink-code/proguard

# Add kept classes, fields, methods for Hilt/Dagger
-keep class com.moviebox.** { *; }
-keep @dagger.hilt.android.qualifier.InterfaceQualifier class * { @dagger.hilt.android.qualifier.InterfaceQualifier ; }

# Keep ExoPlayer classes
-keep class com.google.android.media3.** { *; }
-keepclassmembers class com.google.android.media3.** { *; }

# Keep Compose UI
-keep class androidx.compose.** { *; }

# Keep Room entities and DAOs
-keep class com.moviebox.db.** { *; }

# Keep CoroutineScope and Flow
-keepclassmembers class * implements org.jetbrains.kotlinx.coroutines.flow.Flow {
    *;
}

# Keep OkHttp classes
-keep class okhttp3.** { *; }
-keepclassmembers class okhttp3.** { *; }

# Keep LiveData and ViewModel
-keepclassmembers class androidx.lifecycle.** { *; }

# Application class
-keepclassmembers class com.moviebox.MovieBoxApplication {
    *;
}