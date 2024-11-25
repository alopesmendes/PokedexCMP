package org.ailtontech.pokedex.presentation.theme.colors

import android.os.Build
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.produceState
import androidx.compose.ui.platform.LocalContext

@Composable
actual fun rememberColorScheme(
	dynamicColor: Boolean,
	darkTheme: Boolean,
	darkScheme: ColorScheme,
	lightScheme: ColorScheme,
): State<ColorScheme> {
	val context = LocalContext.current
	return produceState(
		initialValue = lightScheme,
		darkTheme,
		dynamicColor,
		lightScheme,
		darkScheme,
	) {
		value =
			when {
				dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
					if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
				}

				darkTheme -> darkScheme
				else -> lightScheme
			}
	}
}