package org.ailtontech.pokedex.presentation.theme.dimensions

import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Dimensions(
	val extraSmall: Dp,
	val small: Dp,
	val medium: Dp,
	val large: Dp,
	val extraLarge: Dp,
	val cardPadding: Dp,
	val cardImageAspectRatio: Float,
	// Fractional weights
	val smallWeight: Float,
	val defaultWeight: Float,
	val largeWeight: Float,
	val halfWeight: Float,
	val fullWeight: Float,
)

// Default dimensions fallback
val DefaultDimensions
	@ReadOnlyComposable
	get() =
		Dimensions(
			extraSmall = 4.dp,
			small = 8.dp,
			medium = 16.dp,
			large = 24.dp,
			cardPadding = 12.dp,
			cardImageAspectRatio = 1f,
			extraLarge = 32.dp,
			smallWeight = 0.25f,
			defaultWeight = 1f,
			largeWeight = 1.5f,
			halfWeight = 0.5f,
			fullWeight = 1f,
		)

// Dimensions for different screen sizes
val CompactDimensions
	@ReadOnlyComposable
	get() =
		DefaultDimensions.copy(
			cardImageAspectRatio = 16f / 9f,
		)

val MediumDimensions
	@ReadOnlyComposable
	get() =
		DefaultDimensions.copy(
			extraSmall = 6.dp,
			small = 12.dp,
			medium = 20.dp,
			large = 28.dp,
			extraLarge = 40.dp,
		)

val ExpandedDimensions
	@ReadOnlyComposable
	get() =
		DefaultDimensions.copy(
			extraSmall = 8.dp,
			small = 16.dp,
			medium = 24.dp,
			large = 32.dp,
			extraLarge = 48.dp,
			cardImageAspectRatio = 1f,
		)

// CompositionLocal for dimensions
val LocalDimensions =
	staticCompositionLocalOf<Dimensions> {
		error("Dimensions not provided")
	}