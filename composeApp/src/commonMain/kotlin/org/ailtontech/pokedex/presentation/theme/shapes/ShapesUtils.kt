package org.ailtontech.pokedex.presentation.theme.shapes

import androidx.compose.material3.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.produceState
import androidx.window.core.layout.WindowSizeClass
import androidx.window.core.layout.WindowWidthSizeClass.Companion.COMPACT
import androidx.window.core.layout.WindowWidthSizeClass.Companion.EXPANDED
import androidx.window.core.layout.WindowWidthSizeClass.Companion.MEDIUM

@Composable
fun rememberShapes(windowSizeClass: WindowSizeClass): State<Shapes> {
	return produceState(initialValue = CompactShapes, windowSizeClass) {
		value =
			when (windowSizeClass.windowWidthSizeClass) {
				COMPACT -> CompactShapes
				MEDIUM -> MediumShapes
				EXPANDED -> ExpandedShapes
				else -> CompactShapes
			}
	}
}