package org.ailtontech.pokedex.presentation.theme.shapes

import androidx.compose.material3.Shapes
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.produceState

@Composable
fun rememberShapes(windowSizeClass: WindowSizeClass): State<Shapes> {
	return produceState(initialValue = CompactShapes) {
		value =
			when (windowSizeClass.widthSizeClass) {
				WindowWidthSizeClass.Compact -> CompactShapes
				WindowWidthSizeClass.Medium -> MediumShapes
				WindowWidthSizeClass.Expanded -> ExpandedShapes
				else -> CompactShapes
			}
	}
}