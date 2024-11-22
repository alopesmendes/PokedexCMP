package org.ailtontech.pokedex.presentation.theme.colors

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.produceState

@Composable
expect fun rememberColorScheme(
	dynamicColor: Boolean = true,
	darkTheme: Boolean = isSystemInDarkTheme(),
	darkScheme: ColorScheme,
	lightScheme: ColorScheme,
): State<ColorScheme>

@Composable
fun rememberThemeColorScheme(
	contrastLevel: ContrastLevel,
	themeColorScheme: ThemeColorScheme,
): State<ColorScheme> {
	return produceState(initialValue = themeColorScheme.normal, contrastLevel) {
		value =
			when (contrastLevel) {
				ContrastLevel.HIGH -> themeColorScheme.highContrast
				ContrastLevel.MEDIUM -> themeColorScheme.mediumContrast
				else -> themeColorScheme.normal
			}
	}
}