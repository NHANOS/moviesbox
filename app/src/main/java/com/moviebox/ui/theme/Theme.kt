package com.moviebox.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

/**
 * Color schemes for the 9 MovieBox themes.
 * Matches the Rust themes: Mocha, Latte, Macchiato, Frappe, Nord, TokyoNight, Dracula, Gruvbox, RosePine
 */

// Catppuccin Mocha (Dark)
private val MochaDark = darkColorScheme(
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
    onBackground = Color(0xFFCDD6F4),
    surface = Color(0xFF1E1E2E),
    onSurface = Color(0xFFCDD6F4),
    surfaceVariant = Color(0xFF313244),
    onSurfaceVariant = Color(0xFFBAC2DE),
    outline = Color(0xFF585B70),
    outlineVariant = Color(0xFF45475A),
    shadow = Color(0xFF000000),
    scrim = Color(0xFF000000),
    inverseSurface = Color(0xFFCDD6F4),
    inverseOnSurface = Color(0xFF1E1E2E),
    inversePrimary = Color(0xFF1E66F5),
    surfaceTint = Color(0xFF89B4FA)
)

// Catppuccin Latte (Light)
private val LatteLight = lightColorScheme(
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
    inverseOnSurface = Color(0xFFCDD6F4),
    inversePrimary = Color(0xFF89B4FA),
    surfaceTint = Color(0xFF1E66F5)
)

// Catppuccin Macchiato (Dark)
private val MacchiatoDark = darkColorScheme(
    primary = Color(0xFF8AADF4),
    onPrimary = Color(0xFF1E2030),
    primaryContainer = Color(0xFF363A4F),
    onPrimaryContainer = Color(0xFFCAD3F5),
    secondary = Color(0xFFF5BDE6),
    onSecondary = Color(0xFF1E2030),
    secondaryContainer = Color(0xFF494D64),
    onSecondaryContainer = Color(0xFFF5BDE6),
    tertiary = Color(0xFFA6DA95),
    onTertiary = Color(0xFF1E2030),
    tertiaryContainer = Color(0xFF363A4F),
    onTertiaryContainer = Color(0xFFA6DA95),
    background = Color(0xFF1E2030),
    onBackground = Color(0xFFCAD3F5),
    surface = Color(0xFF1E2030),
    onSurface = Color(0xFFCAD3F5),
    surfaceVariant = Color(0xFF363A4F),
    onSurfaceVariant = Color(0xFFB7BDF8),
    outline = Color(0xFF6E738D),
    outlineVariant = Color(0xFF494D64),
    shadow = Color(0xFF000000),
    scrim = Color(0xFF000000),
    inverseSurface = Color(0xFFCAD3F5),
    inverseOnSurface = Color(0xFF1E2030),
    inversePrimary = Color(0xFF1A6ED8),
    surfaceTint = Color(0xFF8AADF4)
)

// Catppuccin Frappe (Dark)
private val FrappeDark = darkColorScheme(
    primary = Color(0xFF8CAEEA),
    onPrimary = Color(0xFF232634),
    primaryContainer = Color(0xFF414559),
    onPrimaryContainer = Color(0xFFC6D0F5),
    secondary = Color(0xFFF4B8E4),
    onSecondary = Color(0xFF232634),
    secondaryContainer = Color(0xFF51576D),
    onSecondaryContainer = Color(0xFFF4B8E4),
    tertiary = Color(0xFFE6C88D),
    onTertiary = Color(0xFF232634),
    tertiaryContainer = Color(0xFF414559),
    onTertiaryContainer = Color(0xFFE6C88D),
    background = Color(0xFF232634),
    onBackground = Color(0xFFC6D0F5),
    surface = Color(0xFF232634),
    onSurface = Color(0xFFC6D0F5),
    surfaceVariant = Color(0xFF414559),
    onSurfaceVariant = Color(0xFFBABBF1),
    outline = Color(0xFF737994),
    outlineVariant = Color(0xFF51576D),
    shadow = Color(0xFF000000),
    scrim = Color(0xFF000000),
    inverseSurface = Color(0xFFC6D0F5),
    inverseOnSurface = Color(0xFF232634),
    inversePrimary = Color(0xFF1A6ED8),
    surfaceTint = Color(0xFF8CAEEA)
)

// Nord (Dark)
private val NordDark = darkColorScheme(
    primary = Color(0xFF88C0D0),
    onPrimary = Color(0xFF2E3440),
    primaryContainer = Color(0xFF3B4252),
    onPrimaryContainer = Color(0xFFECEFF4),
    secondary = Color(0xFFB48EAD),
    onSecondary = Color(0xFF2E3440),
    secondaryContainer = Color(0xFF434C5E),
    onSecondaryContainer = Color(0xFFB48EAD),
    tertiary = Color(0xFFA3BE8C),
    onTertiary = Color(0xFF2E3440),
    tertiaryContainer = Color(0xFF3B4252),
    onTertiaryContainer = Color(0xFFA3BE8C),
    background = Color(0xFF2E3440),
    onBackground = Color(0xFFECEFF4),
    surface = Color(0xFF3B4252),
    onSurface = Color(0xFFECEFF4),
    surfaceVariant = Color(0xFF434C5E),
    onSurfaceVariant = Color(0xFFD8DEE9),
    outline = Color(0xFF4C566A),
    outlineVariant = Color(0xFF3B4252),
    shadow = Color(0xFF000000),
    scrim = Color(0xFF000000),
    inverseSurface = Color(0xFFECEFF4),
    inverseOnSurface = Color(0xFF2E3440),
    inversePrimary = Color(0xFF5E81AC),
    surfaceTint = Color(0xFF88C0D0)
)

// Tokyo Night (Dark)
private val TokyoNightDark = darkColorScheme(
    primary = Color(0xFF7AA2F7),
    onPrimary = Color(0xFF1A1B26),
    primaryContainer = Color(0xFF24283B),
    onPrimaryContainer = Color(0xFFA9B1D6),
    secondary = Color(0xFFBB9AF7),
    onSecondary = Color(0xFF1A1B26),
    secondaryContainer = Color(0xFF292E42),
    onSecondaryContainer = Color(0xFFBB9AF7),
    tertiary = Color(0xFF9ECE6A),
    onTertiary = Color(0xFF1A1B26),
    tertiaryContainer = Color(0xFF24283B),
    onTertiaryContainer = Color(0xFF9ECE6A),
    background = Color(0xFF1A1B26),
    onBackground = Color(0xFFA9B1D6),
    surface = Color(0xFF24283B),
    onSurface = Color(0xFFA9B1D6),
    surfaceVariant = Color(0xFF292E42),
    onSurfaceVariant = Color(0xFF787C99),
    outline = Color(0xFF414868),
    outlineVariant = Color(0xFF292E42),
    shadow = Color(0xFF000000),
    scrim = Color(0xFF000000),
    inverseSurface = Color(0xFFA9B1D6),
    inverseOnSurface = Color(0xFF1A1B26),
    inversePrimary = Color(0xFF2AC3DE),
    surfaceTint = Color(0xFF7AA2F7)
)

// Dracula (Dark)
private val DraculaDark = darkColorScheme(
    primary = Color(0xFFBD93F9),
    onPrimary = Color(0xFF282A36),
    primaryContainer = Color(0xFF44475A),
    onPrimaryContainer = Color(0xFFF8F8F2),
    secondary = Color(0xFFFF79C6),
    onSecondary = Color(0xFF282A36),
    secondaryContainer = Color(0xFF44475A),
    onSecondaryContainer = Color(0xFFFF79C6),
    tertiary = Color(0xFF50FA7B),
    onTertiary = Color(0xFF282A36),
    tertiaryContainer = Color(0xFF44475A),
    onTertiaryContainer = Color(0xFF50FA7B),
    background = Color(0xFF282A36),
    onBackground = Color(0xFFF8F8F2),
    surface = Color(0xFF44475A),
    onSurface = Color(0xFFF8F8F2),
    surfaceVariant = Color(0xFF6272A4),
    onSurfaceVariant = Color(0xFFF8F8F2),
    outline = Color(0xFF6272A4),
    outlineVariant = Color(0xFF44475A),
    shadow = Color(0xFF000000),
    scrim = Color(0xFF000000),
    inverseSurface = Color(0xFFF8F8F2),
    inverseOnSurface = Color(0xFF282A36),
    inversePrimary = Color(0xFFBD93F9),
    surfaceTint = Color(0xFFBD93F9)
)

// Gruvbox (Dark)
private val GruvboxDark = darkColorScheme(
    primary = Color(0xFFD3869B),
    onPrimary = Color(0xFF282828),
    primaryContainer = Color(0xFF3C3836),
    onPrimaryContainer = Color(0xFFEBDBB2),
    secondary = Color(0xFF8EC07C),
    onSecondary = Color(0xFF282828),
    secondaryContainer = Color(0xFF504945),
    onSecondaryContainer = Color(0xFF8EC07C),
    tertiary = Color(0xFFFE8019),
    onTertiary = Color(0xFF282828),
    tertiaryContainer = Color(0xFF3C3836),
    onTertiaryContainer = Color(0xFFFE8019),
    background = Color(0xFF282828),
    onBackground = Color(0xFFEBDBB2),
    surface = Color(0xFF3C3836),
    onSurface = Color(0xFFEBDBB2),
    surfaceVariant = Color(0xFF504945),
    onSurfaceVariant = Color(0xFFBDAE93),
    outline = Color(0xFF665C54),
    outlineVariant = Color(0xFF504945),
    shadow = Color(0xFF000000),
    scrim = Color(0xFF000000),
    inverseSurface = Color(0xFFEBDBB2),
    inverseOnSurface = Color(0xFF282828),
    inversePrimary = Color(0xFFD3869B),
    surfaceTint = Color(0xFFD3869B)
)

// Rose Pine (Dark)
private val RosePineDark = darkColorScheme(
    primary = Color(0xFFEB6F92),
    onPrimary = Color(0xFF191724),
    primaryContainer = Color(0xFF26233A),
    onPrimaryContainer = Color(0xFFE0DEF4),
    secondary = Color(0xFFF6C177),
    onSecondary = Color(0xFF191724),
    secondaryContainer = Color(0xFF312F44),
    onSecondaryContainer = Color(0xFFF6C177),
    tertiary = Color(0xFF9CCFD8),
    onTertiary = Color(0xFF191724),
    tertiaryContainer = Color(0xFF26233A),
    onTertiaryContainer = Color(0xFF9CCFD8),
    background = Color(0xFF191724),
    onBackground = Color(0xFFE0DEF4),
    surface = Color(0xFF1F1D2E),
    onSurface = Color(0xFFE0DEF4),
    surfaceVariant = Color(0xFF26233A),
    onSurfaceVariant = Color(0xFF908CAA),
    outline = Color(0xFF403D52),
    outlineVariant = Color(0xFF26233A),
    shadow = Color(0xFF000000),
    scrim = Color(0xFF000000),
    inverseSurface = Color(0xFFE0DEF4),
    inverseOnSurface = Color(0xFF191724),
    inversePrimary = Color(0xFFEB6F92),
    surfaceTint = Color(0xFFEB6F92)
)

/**
 * Get the color scheme for a theme name.
 */
fun getThemeColorScheme(themeName: String, isDark: Boolean): androidx.compose.material3.ColorScheme {
    return when (themeName.lowercase()) {
        "mocha" -> MochaDark
        "latte" -> if (isDark) MochaDark else LatteLight
        "macchiato" -> MacchiatoDark
        "frappe" -> FrappeDark
        "nord" -> NordDark
        "tokyonight" -> TokyoNightDark
        "dracula" -> DraculaDark
        "gruvbox" -> GruvboxDark
 "rosepine" -> RosePineDark
        else -> MochaDark
    }
}