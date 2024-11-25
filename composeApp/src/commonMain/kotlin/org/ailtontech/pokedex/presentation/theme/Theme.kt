package org.ailtontech.pokedex.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.window.core.layout.WindowSizeClass
import org.ailtontech.pokedex.presentation.theme.colors.ContrastLevel
import org.ailtontech.pokedex.presentation.theme.colors.darkThemeColorScheme
import org.ailtontech.pokedex.presentation.theme.colors.lightThemeColorScheme
import org.ailtontech.pokedex.presentation.theme.colors.rememberColorScheme
import org.ailtontech.pokedex.presentation.theme.colors.rememberThemeColorScheme
import org.ailtontech.pokedex.presentation.theme.dimensions.Dimensions
import org.ailtontech.pokedex.presentation.theme.dimensions.LocalDimensions
import org.ailtontech.pokedex.presentation.theme.dimensions.rememberDimensions
import org.ailtontech.pokedex.presentation.theme.shapes.LocalShapes
import org.ailtontech.pokedex.presentation.theme.shapes.rememberShapes
import org.ailtontech.pokedex.presentation.theme.type.LocalTypography
import org.ailtontech.pokedex.presentation.theme.type.rememberTypography
import org.koin.compose.KoinContext

val MaterialTheme.dimensions: Dimensions
	@ReadOnlyComposable
	@Composable
	get() = LocalDimensions.current

val LocalWindowSizeClass =
	staticCompositionLocalOf<WindowSizeClass> {
		error("WindowSizeClass not provided")
	}

@Composable
fun PokedexTheme(
	darkTheme: Boolean = isSystemInDarkTheme(),
	// Dynamic color is available on Android 12+
	dynamicColor: Boolean = true,
	contrastLevel: ContrastLevel = ContrastLevel.NORMAL,
	content: @Composable () -> Unit,
) {
	KoinContext {
		val windowSizeClass: WindowSizeClass = currentWindowAdaptiveInfo().windowSizeClass
		val typography by rememberTypography(windowSizeClass)
		val lightColorScheme by rememberThemeColorScheme(
			contrastLevel = contrastLevel,
			themeColorScheme = lightThemeColorScheme,
		)
		val darkColorScheme by rememberThemeColorScheme(
			contrastLevel = contrastLevel,
			themeColorScheme = darkThemeColorScheme,
		)
		val colorScheme by rememberColorScheme(
			dynamicColor = dynamicColor,
			darkTheme = darkTheme,
			darkScheme = darkColorScheme,
			lightScheme = lightColorScheme,
		)
		val shapes by rememberShapes(windowSizeClass)
		val dimensions by rememberDimensions(windowSizeClass)

		CompositionLocalProvider(
			LocalShapes provides shapes,
			LocalTypography provides typography,
			LocalDimensions provides dimensions,
			LocalWindowSizeClass provides windowSizeClass,
		) {
			MaterialTheme(
				typography = typography,
				content = content,
				colorScheme = colorScheme,
			)
		}
	}
}