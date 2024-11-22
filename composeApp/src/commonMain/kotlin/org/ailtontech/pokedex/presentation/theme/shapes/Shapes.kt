package org.ailtontech.pokedex.presentation.theme.shapes

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.dp

// Define shapes for each screen size
val CompactShapes
	@ReadOnlyComposable
	get() =
		Shapes(
			small = RoundedCornerShape(8.dp),
			medium = RoundedCornerShape(12.dp),
			large = RoundedCornerShape(16.dp),
		)

val MediumShapes
	@ReadOnlyComposable
	get() =
		Shapes(
			small = RoundedCornerShape(12.dp),
			medium = RoundedCornerShape(16.dp),
			large = RoundedCornerShape(20.dp),
		)

val ExpandedShapes
	@ReadOnlyComposable
	get() =
		Shapes(
			small = RoundedCornerShape(16.dp),
			medium = RoundedCornerShape(20.dp),
			large = RoundedCornerShape(24.dp),
		)

val LocalShapes =
	staticCompositionLocalOf<Shapes> {
		error("Shapes not provided")
	}