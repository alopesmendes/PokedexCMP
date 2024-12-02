package org.ailtontech.pokedex.presentation.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import org.ailtontech.pokedex.presentation.theme.dimensions.Dimensions
import org.ailtontech.pokedex.presentation.theme.dimensions.LocalDimensions

val MaterialTheme.dimensions: Dimensions
	@ReadOnlyComposable
	@Composable
	get() = LocalDimensions.current

/*
val LocalWindowSizeClass =
	staticCompositionLocalOf<WindowSizeClass> {
		error("WindowSizeClass not provided")
	}
*/
@Composable
fun PokedexTheme(
	// darkTheme: Boolean = isSystemInDarkTheme(),
	// Dynamic color is available on Android 12+
	// dynamicColor: Boolean = true,
	// contrastLevel: ContrastLevel = ContrastLevel.NORMAL,
	content: @Composable () -> Unit,
) {
	/*
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
				shapes = shapes,
			)
		}
	}

	 */

	MaterialTheme(
		content = content,
	)
}