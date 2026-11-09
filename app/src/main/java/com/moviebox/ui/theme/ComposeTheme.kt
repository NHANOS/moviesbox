package com.moviebox.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun MovieBoxScaffold(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colorScheme = if (darkTheme) {
        darkColorScheme(
            primary = Color(0xFF89B4FA),
            onPrimary = Color(0xFF1E1E2E),
            primaryContainer = Color(0xFF313244),
            onPrimaryContainer = Color(0xFFCDD6F4),
            secondary = Color(0xFFF5C2E7),
            onSecondary = Color(0xFF1E1E2E),
            secondaryContainer = Color(0xFF45475A),
            onSecondaryContainer = Color(0xFFF5C2E7),
            tertiary = Color(0xFFA6E3A1),
            onTertiary = Color(0xFF1E1E2E),
            tertiaryContainer = Color(0xFF313244),
            onTertiaryContainer = Color(0xFFA6E3A1),
            background = Color(0xFF1E1E2E),
            onBackground = Color(0xFF282C3F),
            surface = Color(0xFF1E1E2E),
            onSurface = Color(0xFFCDD6F4),
            surfaceVariant = Color(0xFF313244),
            onSurfaceVariant = Color(0xFFBAC2DE),
            outline = Color(0xFF585B70),
            outlineVariant = Color(0xFF45475A),
            shadow = Color(0xFF000000),
            scrim = Color(0xFF000000),
            inverseSurface = Color(0xFF282C3F),
            inverseOnSurface = Color(0xFFCDD6F4),
            inversePrimary = Color(0xFF1E66F5),
            surfaceTint = Color(0xFF89B4FA),
        )
    } else {
        lightColorScheme(
            primary = Color(0xFF1E66F5),
            onPrimary = Color(0xFFFFFFFF),
            primaryContainer = Color(0xFFDCE0E8),
            onPrimaryContainer = Color(0xFF1E1E2E),
            secondary = Color(0xFFEA76CB),
            onSecondary = Color(0xFFFFFFFF),
            secondaryContainer = Color(0xFFDCE0E8),
            onSecondaryContainer = Color(0xFF1E1E2E),
            tertiary = Color(0xFF2E9B5C),
            onTertiary = Color(0xFFFFFFFF),
            tertiaryContainer = Color(0xFFDCE0E8),
            onTertiaryContainer = Color(0xFF1E1E2E),
            background = Color(0xFFEFF1F5),
            onBackground = Color(0xFF1E1E2E),
            surface = Color(0xFFEFF1F5),
            onSurface = Color(0xFF1E1E2E),
            surfaceVariant = Color(0xFFDCE0E8),
            onSurfaceVariant = Color(0xFF45475A),
            outline = Color(0xFF8C8FA1),
            outlineVariant = Color(0xFFBCC0CC),
            shadow = Color(0xFF000000),
            scrim = Color(0xFF000000),
            inverseSurface = Color(0xFF1E1E2E),
            inverseOnSurface = Color(0xFF282C3F),
            inversePrimary = Color(0xFF89B4FA),
            surfaceTint = Color(0xFF1E66F5),
        )
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = MaterialTheme.typography,
    ) {
        content()
    }
}