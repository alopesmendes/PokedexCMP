package org.ailtontech.pokedex.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import org.ailtontech.pokedex.presentation.theme.colors.ContrastLevel
import org.ailtontech.pokedex.presentation.theme.colors.ThemeColorScheme
import org.ailtontech.pokedex.presentation.theme.colors.backgroundDark
import org.ailtontech.pokedex.presentation.theme.colors.backgroundDarkHighContrast
import org.ailtontech.pokedex.presentation.theme.colors.backgroundDarkMediumContrast
import org.ailtontech.pokedex.presentation.theme.colors.backgroundLight
import org.ailtontech.pokedex.presentation.theme.colors.backgroundLightHighContrast
import org.ailtontech.pokedex.presentation.theme.colors.backgroundLightMediumContrast
import org.ailtontech.pokedex.presentation.theme.colors.errorContainerDark
import org.ailtontech.pokedex.presentation.theme.colors.errorContainerDarkHighContrast
import org.ailtontech.pokedex.presentation.theme.colors.errorContainerDarkMediumContrast
import org.ailtontech.pokedex.presentation.theme.colors.errorContainerLight
import org.ailtontech.pokedex.presentation.theme.colors.errorContainerLightHighContrast
import org.ailtontech.pokedex.presentation.theme.colors.errorContainerLightMediumContrast
import org.ailtontech.pokedex.presentation.theme.colors.errorDark
import org.ailtontech.pokedex.presentation.theme.colors.errorDarkHighContrast
import org.ailtontech.pokedex.presentation.theme.colors.errorDarkMediumContrast
import org.ailtontech.pokedex.presentation.theme.colors.errorLight
import org.ailtontech.pokedex.presentation.theme.colors.errorLightHighContrast
import org.ailtontech.pokedex.presentation.theme.colors.errorLightMediumContrast
import org.ailtontech.pokedex.presentation.theme.colors.inverseOnSurfaceDark
import org.ailtontech.pokedex.presentation.theme.colors.inverseOnSurfaceDarkHighContrast
import org.ailtontech.pokedex.presentation.theme.colors.inverseOnSurfaceDarkMediumContrast
import org.ailtontech.pokedex.presentation.theme.colors.inverseOnSurfaceLight
import org.ailtontech.pokedex.presentation.theme.colors.inverseOnSurfaceLightHighContrast
import org.ailtontech.pokedex.presentation.theme.colors.inverseOnSurfaceLightMediumContrast
import org.ailtontech.pokedex.presentation.theme.colors.inversePrimaryDark
import org.ailtontech.pokedex.presentation.theme.colors.inversePrimaryDarkHighContrast
import org.ailtontech.pokedex.presentation.theme.colors.inversePrimaryDarkMediumContrast
import org.ailtontech.pokedex.presentation.theme.colors.inversePrimaryLight
import org.ailtontech.pokedex.presentation.theme.colors.inversePrimaryLightHighContrast
import org.ailtontech.pokedex.presentation.theme.colors.inversePrimaryLightMediumContrast
import org.ailtontech.pokedex.presentation.theme.colors.inverseSurfaceDark
import org.ailtontech.pokedex.presentation.theme.colors.inverseSurfaceDarkHighContrast
import org.ailtontech.pokedex.presentation.theme.colors.inverseSurfaceDarkMediumContrast
import org.ailtontech.pokedex.presentation.theme.colors.inverseSurfaceLight
import org.ailtontech.pokedex.presentation.theme.colors.inverseSurfaceLightHighContrast
import org.ailtontech.pokedex.presentation.theme.colors.inverseSurfaceLightMediumContrast
import org.ailtontech.pokedex.presentation.theme.colors.onBackgroundDark
import org.ailtontech.pokedex.presentation.theme.colors.onBackgroundDarkHighContrast
import org.ailtontech.pokedex.presentation.theme.colors.onBackgroundDarkMediumContrast
import org.ailtontech.pokedex.presentation.theme.colors.onBackgroundLight
import org.ailtontech.pokedex.presentation.theme.colors.onBackgroundLightHighContrast
import org.ailtontech.pokedex.presentation.theme.colors.onBackgroundLightMediumContrast
import org.ailtontech.pokedex.presentation.theme.colors.onErrorContainerDark
import org.ailtontech.pokedex.presentation.theme.colors.onErrorContainerDarkHighContrast
import org.ailtontech.pokedex.presentation.theme.colors.onErrorContainerDarkMediumContrast
import org.ailtontech.pokedex.presentation.theme.colors.onErrorContainerLight
import org.ailtontech.pokedex.presentation.theme.colors.onErrorContainerLightHighContrast
import org.ailtontech.pokedex.presentation.theme.colors.onErrorContainerLightMediumContrast
import org.ailtontech.pokedex.presentation.theme.colors.onErrorDark
import org.ailtontech.pokedex.presentation.theme.colors.onErrorDarkHighContrast
import org.ailtontech.pokedex.presentation.theme.colors.onErrorDarkMediumContrast
import org.ailtontech.pokedex.presentation.theme.colors.onErrorLight
import org.ailtontech.pokedex.presentation.theme.colors.onErrorLightHighContrast
import org.ailtontech.pokedex.presentation.theme.colors.onErrorLightMediumContrast
import org.ailtontech.pokedex.presentation.theme.colors.onPrimaryContainerDark
import org.ailtontech.pokedex.presentation.theme.colors.onPrimaryContainerDarkHighContrast
import org.ailtontech.pokedex.presentation.theme.colors.onPrimaryContainerDarkMediumContrast
import org.ailtontech.pokedex.presentation.theme.colors.onPrimaryContainerLight
import org.ailtontech.pokedex.presentation.theme.colors.onPrimaryContainerLightHighContrast
import org.ailtontech.pokedex.presentation.theme.colors.onPrimaryContainerLightMediumContrast
import org.ailtontech.pokedex.presentation.theme.colors.onPrimaryDark
import org.ailtontech.pokedex.presentation.theme.colors.onPrimaryDarkHighContrast
import org.ailtontech.pokedex.presentation.theme.colors.onPrimaryDarkMediumContrast
import org.ailtontech.pokedex.presentation.theme.colors.onPrimaryLight
import org.ailtontech.pokedex.presentation.theme.colors.onPrimaryLightHighContrast
import org.ailtontech.pokedex.presentation.theme.colors.onPrimaryLightMediumContrast
import org.ailtontech.pokedex.presentation.theme.colors.onSecondaryContainerDark
import org.ailtontech.pokedex.presentation.theme.colors.onSecondaryContainerDarkHighContrast
import org.ailtontech.pokedex.presentation.theme.colors.onSecondaryContainerDarkMediumContrast
import org.ailtontech.pokedex.presentation.theme.colors.onSecondaryContainerLight
import org.ailtontech.pokedex.presentation.theme.colors.onSecondaryContainerLightHighContrast
import org.ailtontech.pokedex.presentation.theme.colors.onSecondaryContainerLightMediumContrast
import org.ailtontech.pokedex.presentation.theme.colors.onSecondaryDark
import org.ailtontech.pokedex.presentation.theme.colors.onSecondaryDarkHighContrast
import org.ailtontech.pokedex.presentation.theme.colors.onSecondaryDarkMediumContrast
import org.ailtontech.pokedex.presentation.theme.colors.onSecondaryLight
import org.ailtontech.pokedex.presentation.theme.colors.onSecondaryLightHighContrast
import org.ailtontech.pokedex.presentation.theme.colors.onSecondaryLightMediumContrast
import org.ailtontech.pokedex.presentation.theme.colors.onSurfaceDark
import org.ailtontech.pokedex.presentation.theme.colors.onSurfaceDarkHighContrast
import org.ailtontech.pokedex.presentation.theme.colors.onSurfaceDarkMediumContrast
import org.ailtontech.pokedex.presentation.theme.colors.onSurfaceLight
import org.ailtontech.pokedex.presentation.theme.colors.onSurfaceLightHighContrast
import org.ailtontech.pokedex.presentation.theme.colors.onSurfaceLightMediumContrast
import org.ailtontech.pokedex.presentation.theme.colors.onSurfaceVariantDark
import org.ailtontech.pokedex.presentation.theme.colors.onSurfaceVariantDarkHighContrast
import org.ailtontech.pokedex.presentation.theme.colors.onSurfaceVariantDarkMediumContrast
import org.ailtontech.pokedex.presentation.theme.colors.onSurfaceVariantLight
import org.ailtontech.pokedex.presentation.theme.colors.onSurfaceVariantLightHighContrast
import org.ailtontech.pokedex.presentation.theme.colors.onSurfaceVariantLightMediumContrast
import org.ailtontech.pokedex.presentation.theme.colors.onTertiaryContainerDark
import org.ailtontech.pokedex.presentation.theme.colors.onTertiaryContainerDarkHighContrast
import org.ailtontech.pokedex.presentation.theme.colors.onTertiaryContainerDarkMediumContrast
import org.ailtontech.pokedex.presentation.theme.colors.onTertiaryContainerLight
import org.ailtontech.pokedex.presentation.theme.colors.onTertiaryContainerLightHighContrast
import org.ailtontech.pokedex.presentation.theme.colors.onTertiaryContainerLightMediumContrast
import org.ailtontech.pokedex.presentation.theme.colors.onTertiaryDark
import org.ailtontech.pokedex.presentation.theme.colors.onTertiaryDarkHighContrast
import org.ailtontech.pokedex.presentation.theme.colors.onTertiaryDarkMediumContrast
import org.ailtontech.pokedex.presentation.theme.colors.onTertiaryLight
import org.ailtontech.pokedex.presentation.theme.colors.onTertiaryLightHighContrast
import org.ailtontech.pokedex.presentation.theme.colors.onTertiaryLightMediumContrast
import org.ailtontech.pokedex.presentation.theme.colors.outlineDark
import org.ailtontech.pokedex.presentation.theme.colors.outlineDarkHighContrast
import org.ailtontech.pokedex.presentation.theme.colors.outlineDarkMediumContrast
import org.ailtontech.pokedex.presentation.theme.colors.outlineLight
import org.ailtontech.pokedex.presentation.theme.colors.outlineLightHighContrast
import org.ailtontech.pokedex.presentation.theme.colors.outlineLightMediumContrast
import org.ailtontech.pokedex.presentation.theme.colors.outlineVariantDark
import org.ailtontech.pokedex.presentation.theme.colors.outlineVariantDarkHighContrast
import org.ailtontech.pokedex.presentation.theme.colors.outlineVariantDarkMediumContrast
import org.ailtontech.pokedex.presentation.theme.colors.outlineVariantLight
import org.ailtontech.pokedex.presentation.theme.colors.outlineVariantLightHighContrast
import org.ailtontech.pokedex.presentation.theme.colors.outlineVariantLightMediumContrast
import org.ailtontech.pokedex.presentation.theme.colors.primaryContainerDark
import org.ailtontech.pokedex.presentation.theme.colors.primaryContainerDarkHighContrast
import org.ailtontech.pokedex.presentation.theme.colors.primaryContainerDarkMediumContrast
import org.ailtontech.pokedex.presentation.theme.colors.primaryContainerLight
import org.ailtontech.pokedex.presentation.theme.colors.primaryContainerLightHighContrast
import org.ailtontech.pokedex.presentation.theme.colors.primaryContainerLightMediumContrast
import org.ailtontech.pokedex.presentation.theme.colors.primaryDark
import org.ailtontech.pokedex.presentation.theme.colors.primaryDarkHighContrast
import org.ailtontech.pokedex.presentation.theme.colors.primaryDarkMediumContrast
import org.ailtontech.pokedex.presentation.theme.colors.primaryLight
import org.ailtontech.pokedex.presentation.theme.colors.primaryLightHighContrast
import org.ailtontech.pokedex.presentation.theme.colors.primaryLightMediumContrast
import org.ailtontech.pokedex.presentation.theme.colors.rememberColorScheme
import org.ailtontech.pokedex.presentation.theme.colors.rememberThemeColorScheme
import org.ailtontech.pokedex.presentation.theme.colors.scrimDark
import org.ailtontech.pokedex.presentation.theme.colors.scrimDarkHighContrast
import org.ailtontech.pokedex.presentation.theme.colors.scrimDarkMediumContrast
import org.ailtontech.pokedex.presentation.theme.colors.scrimLight
import org.ailtontech.pokedex.presentation.theme.colors.scrimLightHighContrast
import org.ailtontech.pokedex.presentation.theme.colors.scrimLightMediumContrast
import org.ailtontech.pokedex.presentation.theme.colors.secondaryContainerDark
import org.ailtontech.pokedex.presentation.theme.colors.secondaryContainerDarkHighContrast
import org.ailtontech.pokedex.presentation.theme.colors.secondaryContainerDarkMediumContrast
import org.ailtontech.pokedex.presentation.theme.colors.secondaryContainerLight
import org.ailtontech.pokedex.presentation.theme.colors.secondaryContainerLightHighContrast
import org.ailtontech.pokedex.presentation.theme.colors.secondaryContainerLightMediumContrast
import org.ailtontech.pokedex.presentation.theme.colors.secondaryDark
import org.ailtontech.pokedex.presentation.theme.colors.secondaryDarkHighContrast
import org.ailtontech.pokedex.presentation.theme.colors.secondaryDarkMediumContrast
import org.ailtontech.pokedex.presentation.theme.colors.secondaryLight
import org.ailtontech.pokedex.presentation.theme.colors.secondaryLightHighContrast
import org.ailtontech.pokedex.presentation.theme.colors.secondaryLightMediumContrast
import org.ailtontech.pokedex.presentation.theme.colors.surfaceBrightDark
import org.ailtontech.pokedex.presentation.theme.colors.surfaceBrightDarkHighContrast
import org.ailtontech.pokedex.presentation.theme.colors.surfaceBrightDarkMediumContrast
import org.ailtontech.pokedex.presentation.theme.colors.surfaceBrightLight
import org.ailtontech.pokedex.presentation.theme.colors.surfaceBrightLightHighContrast
import org.ailtontech.pokedex.presentation.theme.colors.surfaceBrightLightMediumContrast
import org.ailtontech.pokedex.presentation.theme.colors.surfaceContainerDark
import org.ailtontech.pokedex.presentation.theme.colors.surfaceContainerDarkHighContrast
import org.ailtontech.pokedex.presentation.theme.colors.surfaceContainerDarkMediumContrast
import org.ailtontech.pokedex.presentation.theme.colors.surfaceContainerHighDark
import org.ailtontech.pokedex.presentation.theme.colors.surfaceContainerHighDarkHighContrast
import org.ailtontech.pokedex.presentation.theme.colors.surfaceContainerHighDarkMediumContrast
import org.ailtontech.pokedex.presentation.theme.colors.surfaceContainerHighLight
import org.ailtontech.pokedex.presentation.theme.colors.surfaceContainerHighLightHighContrast
import org.ailtontech.pokedex.presentation.theme.colors.surfaceContainerHighLightMediumContrast
import org.ailtontech.pokedex.presentation.theme.colors.surfaceContainerHighestDark
import org.ailtontech.pokedex.presentation.theme.colors.surfaceContainerHighestDarkHighContrast
import org.ailtontech.pokedex.presentation.theme.colors.surfaceContainerHighestDarkMediumContrast
import org.ailtontech.pokedex.presentation.theme.colors.surfaceContainerHighestLight
import org.ailtontech.pokedex.presentation.theme.colors.surfaceContainerHighestLightHighContrast
import org.ailtontech.pokedex.presentation.theme.colors.surfaceContainerHighestLightMediumContrast
import org.ailtontech.pokedex.presentation.theme.colors.surfaceContainerLight
import org.ailtontech.pokedex.presentation.theme.colors.surfaceContainerLightHighContrast
import org.ailtontech.pokedex.presentation.theme.colors.surfaceContainerLightMediumContrast
import org.ailtontech.pokedex.presentation.theme.colors.surfaceContainerLowDark
import org.ailtontech.pokedex.presentation.theme.colors.surfaceContainerLowDarkHighContrast
import org.ailtontech.pokedex.presentation.theme.colors.surfaceContainerLowDarkMediumContrast
import org.ailtontech.pokedex.presentation.theme.colors.surfaceContainerLowLight
import org.ailtontech.pokedex.presentation.theme.colors.surfaceContainerLowLightHighContrast
import org.ailtontech.pokedex.presentation.theme.colors.surfaceContainerLowLightMediumContrast
import org.ailtontech.pokedex.presentation.theme.colors.surfaceContainerLowestDark
import org.ailtontech.pokedex.presentation.theme.colors.surfaceContainerLowestDarkHighContrast
import org.ailtontech.pokedex.presentation.theme.colors.surfaceContainerLowestDarkMediumContrast
import org.ailtontech.pokedex.presentation.theme.colors.surfaceContainerLowestLight
import org.ailtontech.pokedex.presentation.theme.colors.surfaceContainerLowestLightHighContrast
import org.ailtontech.pokedex.presentation.theme.colors.surfaceContainerLowestLightMediumContrast
import org.ailtontech.pokedex.presentation.theme.colors.surfaceDark
import org.ailtontech.pokedex.presentation.theme.colors.surfaceDarkHighContrast
import org.ailtontech.pokedex.presentation.theme.colors.surfaceDarkMediumContrast
import org.ailtontech.pokedex.presentation.theme.colors.surfaceDimDark
import org.ailtontech.pokedex.presentation.theme.colors.surfaceDimDarkHighContrast
import org.ailtontech.pokedex.presentation.theme.colors.surfaceDimDarkMediumContrast
import org.ailtontech.pokedex.presentation.theme.colors.surfaceDimLight
import org.ailtontech.pokedex.presentation.theme.colors.surfaceDimLightHighContrast
import org.ailtontech.pokedex.presentation.theme.colors.surfaceDimLightMediumContrast
import org.ailtontech.pokedex.presentation.theme.colors.surfaceLight
import org.ailtontech.pokedex.presentation.theme.colors.surfaceLightHighContrast
import org.ailtontech.pokedex.presentation.theme.colors.surfaceLightMediumContrast
import org.ailtontech.pokedex.presentation.theme.colors.surfaceVariantDark
import org.ailtontech.pokedex.presentation.theme.colors.surfaceVariantDarkHighContrast
import org.ailtontech.pokedex.presentation.theme.colors.surfaceVariantDarkMediumContrast
import org.ailtontech.pokedex.presentation.theme.colors.surfaceVariantLight
import org.ailtontech.pokedex.presentation.theme.colors.surfaceVariantLightHighContrast
import org.ailtontech.pokedex.presentation.theme.colors.surfaceVariantLightMediumContrast
import org.ailtontech.pokedex.presentation.theme.colors.tertiaryContainerDark
import org.ailtontech.pokedex.presentation.theme.colors.tertiaryContainerDarkHighContrast
import org.ailtontech.pokedex.presentation.theme.colors.tertiaryContainerDarkMediumContrast
import org.ailtontech.pokedex.presentation.theme.colors.tertiaryContainerLight
import org.ailtontech.pokedex.presentation.theme.colors.tertiaryContainerLightHighContrast
import org.ailtontech.pokedex.presentation.theme.colors.tertiaryContainerLightMediumContrast
import org.ailtontech.pokedex.presentation.theme.colors.tertiaryDark
import org.ailtontech.pokedex.presentation.theme.colors.tertiaryDarkHighContrast
import org.ailtontech.pokedex.presentation.theme.colors.tertiaryDarkMediumContrast
import org.ailtontech.pokedex.presentation.theme.colors.tertiaryLight
import org.ailtontech.pokedex.presentation.theme.colors.tertiaryLightHighContrast
import org.ailtontech.pokedex.presentation.theme.colors.tertiaryLightMediumContrast
import org.koin.compose.KoinContext

private val lightScheme =
	lightColorScheme(
		primary = primaryLight,
		onPrimary = onPrimaryLight,
		primaryContainer = primaryContainerLight,
		onPrimaryContainer = onPrimaryContainerLight,
		secondary = secondaryLight,
		onSecondary = onSecondaryLight,
		secondaryContainer = secondaryContainerLight,
		onSecondaryContainer = onSecondaryContainerLight,
		tertiary = tertiaryLight,
		onTertiary = onTertiaryLight,
		tertiaryContainer = tertiaryContainerLight,
		onTertiaryContainer = onTertiaryContainerLight,
		error = errorLight,
		onError = onErrorLight,
		errorContainer = errorContainerLight,
		onErrorContainer = onErrorContainerLight,
		background = backgroundLight,
		onBackground = onBackgroundLight,
		surface = surfaceLight,
		onSurface = onSurfaceLight,
		surfaceVariant = surfaceVariantLight,
		onSurfaceVariant = onSurfaceVariantLight,
		outline = outlineLight,
		outlineVariant = outlineVariantLight,
		scrim = scrimLight,
		inverseSurface = inverseSurfaceLight,
		inverseOnSurface = inverseOnSurfaceLight,
		inversePrimary = inversePrimaryLight,
		surfaceDim = surfaceDimLight,
		surfaceBright = surfaceBrightLight,
		surfaceContainerLowest = surfaceContainerLowestLight,
		surfaceContainerLow = surfaceContainerLowLight,
		surfaceContainer = surfaceContainerLight,
		surfaceContainerHigh = surfaceContainerHighLight,
		surfaceContainerHighest = surfaceContainerHighestLight,
	)

private val darkScheme =
	darkColorScheme(
		primary = primaryDark,
		onPrimary = onPrimaryDark,
		primaryContainer = primaryContainerDark,
		onPrimaryContainer = onPrimaryContainerDark,
		secondary = secondaryDark,
		onSecondary = onSecondaryDark,
		secondaryContainer = secondaryContainerDark,
		onSecondaryContainer = onSecondaryContainerDark,
		tertiary = tertiaryDark,
		onTertiary = onTertiaryDark,
		tertiaryContainer = tertiaryContainerDark,
		onTertiaryContainer = onTertiaryContainerDark,
		error = errorDark,
		onError = onErrorDark,
		errorContainer = errorContainerDark,
		onErrorContainer = onErrorContainerDark,
		background = backgroundDark,
		onBackground = onBackgroundDark,
		surface = surfaceDark,
		onSurface = onSurfaceDark,
		surfaceVariant = surfaceVariantDark,
		onSurfaceVariant = onSurfaceVariantDark,
		outline = outlineDark,
		outlineVariant = outlineVariantDark,
		scrim = scrimDark,
		inverseSurface = inverseSurfaceDark,
		inverseOnSurface = inverseOnSurfaceDark,
		inversePrimary = inversePrimaryDark,
		surfaceDim = surfaceDimDark,
		surfaceBright = surfaceBrightDark,
		surfaceContainerLowest = surfaceContainerLowestDark,
		surfaceContainerLow = surfaceContainerLowDark,
		surfaceContainer = surfaceContainerDark,
		surfaceContainerHigh = surfaceContainerHighDark,
		surfaceContainerHighest = surfaceContainerHighestDark,
	)

private val mediumContrastLightColorScheme =
	lightColorScheme(
		primary = primaryLightMediumContrast,
		onPrimary = onPrimaryLightMediumContrast,
		primaryContainer = primaryContainerLightMediumContrast,
		onPrimaryContainer = onPrimaryContainerLightMediumContrast,
		secondary = secondaryLightMediumContrast,
		onSecondary = onSecondaryLightMediumContrast,
		secondaryContainer = secondaryContainerLightMediumContrast,
		onSecondaryContainer = onSecondaryContainerLightMediumContrast,
		tertiary = tertiaryLightMediumContrast,
		onTertiary = onTertiaryLightMediumContrast,
		tertiaryContainer = tertiaryContainerLightMediumContrast,
		onTertiaryContainer = onTertiaryContainerLightMediumContrast,
		error = errorLightMediumContrast,
		onError = onErrorLightMediumContrast,
		errorContainer = errorContainerLightMediumContrast,
		onErrorContainer = onErrorContainerLightMediumContrast,
		background = backgroundLightMediumContrast,
		onBackground = onBackgroundLightMediumContrast,
		surface = surfaceLightMediumContrast,
		onSurface = onSurfaceLightMediumContrast,
		surfaceVariant = surfaceVariantLightMediumContrast,
		onSurfaceVariant = onSurfaceVariantLightMediumContrast,
		outline = outlineLightMediumContrast,
		outlineVariant = outlineVariantLightMediumContrast,
		scrim = scrimLightMediumContrast,
		inverseSurface = inverseSurfaceLightMediumContrast,
		inverseOnSurface = inverseOnSurfaceLightMediumContrast,
		inversePrimary = inversePrimaryLightMediumContrast,
		surfaceDim = surfaceDimLightMediumContrast,
		surfaceBright = surfaceBrightLightMediumContrast,
		surfaceContainerLowest = surfaceContainerLowestLightMediumContrast,
		surfaceContainerLow = surfaceContainerLowLightMediumContrast,
		surfaceContainer = surfaceContainerLightMediumContrast,
		surfaceContainerHigh = surfaceContainerHighLightMediumContrast,
		surfaceContainerHighest = surfaceContainerHighestLightMediumContrast,
	)

private val highContrastLightColorScheme =
	lightColorScheme(
		primary = primaryLightHighContrast,
		onPrimary = onPrimaryLightHighContrast,
		primaryContainer = primaryContainerLightHighContrast,
		onPrimaryContainer = onPrimaryContainerLightHighContrast,
		secondary = secondaryLightHighContrast,
		onSecondary = onSecondaryLightHighContrast,
		secondaryContainer = secondaryContainerLightHighContrast,
		onSecondaryContainer = onSecondaryContainerLightHighContrast,
		tertiary = tertiaryLightHighContrast,
		onTertiary = onTertiaryLightHighContrast,
		tertiaryContainer = tertiaryContainerLightHighContrast,
		onTertiaryContainer = onTertiaryContainerLightHighContrast,
		error = errorLightHighContrast,
		onError = onErrorLightHighContrast,
		errorContainer = errorContainerLightHighContrast,
		onErrorContainer = onErrorContainerLightHighContrast,
		background = backgroundLightHighContrast,
		onBackground = onBackgroundLightHighContrast,
		surface = surfaceLightHighContrast,
		onSurface = onSurfaceLightHighContrast,
		surfaceVariant = surfaceVariantLightHighContrast,
		onSurfaceVariant = onSurfaceVariantLightHighContrast,
		outline = outlineLightHighContrast,
		outlineVariant = outlineVariantLightHighContrast,
		scrim = scrimLightHighContrast,
		inverseSurface = inverseSurfaceLightHighContrast,
		inverseOnSurface = inverseOnSurfaceLightHighContrast,
		inversePrimary = inversePrimaryLightHighContrast,
		surfaceDim = surfaceDimLightHighContrast,
		surfaceBright = surfaceBrightLightHighContrast,
		surfaceContainerLowest = surfaceContainerLowestLightHighContrast,
		surfaceContainerLow = surfaceContainerLowLightHighContrast,
		surfaceContainer = surfaceContainerLightHighContrast,
		surfaceContainerHigh = surfaceContainerHighLightHighContrast,
		surfaceContainerHighest = surfaceContainerHighestLightHighContrast,
	)

private val mediumContrastDarkColorScheme =
	darkColorScheme(
		primary = primaryDarkMediumContrast,
		onPrimary = onPrimaryDarkMediumContrast,
		primaryContainer = primaryContainerDarkMediumContrast,
		onPrimaryContainer = onPrimaryContainerDarkMediumContrast,
		secondary = secondaryDarkMediumContrast,
		onSecondary = onSecondaryDarkMediumContrast,
		secondaryContainer = secondaryContainerDarkMediumContrast,
		onSecondaryContainer = onSecondaryContainerDarkMediumContrast,
		tertiary = tertiaryDarkMediumContrast,
		onTertiary = onTertiaryDarkMediumContrast,
		tertiaryContainer = tertiaryContainerDarkMediumContrast,
		onTertiaryContainer = onTertiaryContainerDarkMediumContrast,
		error = errorDarkMediumContrast,
		onError = onErrorDarkMediumContrast,
		errorContainer = errorContainerDarkMediumContrast,
		onErrorContainer = onErrorContainerDarkMediumContrast,
		background = backgroundDarkMediumContrast,
		onBackground = onBackgroundDarkMediumContrast,
		surface = surfaceDarkMediumContrast,
		onSurface = onSurfaceDarkMediumContrast,
		surfaceVariant = surfaceVariantDarkMediumContrast,
		onSurfaceVariant = onSurfaceVariantDarkMediumContrast,
		outline = outlineDarkMediumContrast,
		outlineVariant = outlineVariantDarkMediumContrast,
		scrim = scrimDarkMediumContrast,
		inverseSurface = inverseSurfaceDarkMediumContrast,
		inverseOnSurface = inverseOnSurfaceDarkMediumContrast,
		inversePrimary = inversePrimaryDarkMediumContrast,
		surfaceDim = surfaceDimDarkMediumContrast,
		surfaceBright = surfaceBrightDarkMediumContrast,
		surfaceContainerLowest = surfaceContainerLowestDarkMediumContrast,
		surfaceContainerLow = surfaceContainerLowDarkMediumContrast,
		surfaceContainer = surfaceContainerDarkMediumContrast,
		surfaceContainerHigh = surfaceContainerHighDarkMediumContrast,
		surfaceContainerHighest = surfaceContainerHighestDarkMediumContrast,
	)

private val highContrastDarkColorScheme =
	darkColorScheme(
		primary = primaryDarkHighContrast,
		onPrimary = onPrimaryDarkHighContrast,
		primaryContainer = primaryContainerDarkHighContrast,
		onPrimaryContainer = onPrimaryContainerDarkHighContrast,
		secondary = secondaryDarkHighContrast,
		onSecondary = onSecondaryDarkHighContrast,
		secondaryContainer = secondaryContainerDarkHighContrast,
		onSecondaryContainer = onSecondaryContainerDarkHighContrast,
		tertiary = tertiaryDarkHighContrast,
		onTertiary = onTertiaryDarkHighContrast,
		tertiaryContainer = tertiaryContainerDarkHighContrast,
		onTertiaryContainer = onTertiaryContainerDarkHighContrast,
		error = errorDarkHighContrast,
		onError = onErrorDarkHighContrast,
		errorContainer = errorContainerDarkHighContrast,
		onErrorContainer = onErrorContainerDarkHighContrast,
		background = backgroundDarkHighContrast,
		onBackground = onBackgroundDarkHighContrast,
		surface = surfaceDarkHighContrast,
		onSurface = onSurfaceDarkHighContrast,
		surfaceVariant = surfaceVariantDarkHighContrast,
		onSurfaceVariant = onSurfaceVariantDarkHighContrast,
		outline = outlineDarkHighContrast,
		outlineVariant = outlineVariantDarkHighContrast,
		scrim = scrimDarkHighContrast,
		inverseSurface = inverseSurfaceDarkHighContrast,
		inverseOnSurface = inverseOnSurfaceDarkHighContrast,
		inversePrimary = inversePrimaryDarkHighContrast,
		surfaceDim = surfaceDimDarkHighContrast,
		surfaceBright = surfaceBrightDarkHighContrast,
		surfaceContainerLowest = surfaceContainerLowestDarkHighContrast,
		surfaceContainerLow = surfaceContainerLowDarkHighContrast,
		surfaceContainer = surfaceContainerDarkHighContrast,
		surfaceContainerHigh = surfaceContainerHighDarkHighContrast,
		surfaceContainerHighest = surfaceContainerHighestDarkHighContrast,
	)

val lightThemeColorScheme =
	ThemeColorScheme(
		normal = lightScheme,
		mediumContrast = mediumContrastLightColorScheme,
		highContrast = highContrastLightColorScheme,
	)

val darkThemeColorScheme =
	ThemeColorScheme(
		normal = darkScheme,
		mediumContrast = mediumContrastDarkColorScheme,
		highContrast = highContrastDarkColorScheme,
	)

@Composable
fun PokedexTheme(
	darkTheme: Boolean = isSystemInDarkTheme(),
	// Dynamic color is available on Android 12+
	dynamicColor: Boolean = true,
	contrastLevel: ContrastLevel = ContrastLevel.NORMAL,
	content: @Composable () -> Unit,
) {
	KoinContext {
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

		MaterialTheme(
			content = content,
			colorScheme = colorScheme,
		)
	}
}