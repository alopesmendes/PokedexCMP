package org.ailtontech.pokedex.presentation.theme.colors

import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.produceState

@Composable
actual fun rememberColorScheme(
	dynamicColor: Boolean,
	darkTheme: Boolean,
	darkScheme: ColorScheme,
	lightScheme: ColorScheme,
): State<ColorScheme> {
	return produceState(
		initialValue = lightScheme,
		darkTheme,
		lightScheme,
		darkScheme,
	) {
		value =
			when {
				darkTheme -> darkScheme
				else -> lightScheme
			}
	}
}