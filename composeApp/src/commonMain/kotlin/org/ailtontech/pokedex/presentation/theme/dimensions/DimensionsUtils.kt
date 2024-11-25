package org.ailtontech.pokedex.presentation.theme.dimensions

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.produceState
import androidx.window.core.layout.WindowSizeClass
import androidx.window.core.layout.WindowWidthSizeClass.Companion.COMPACT
import androidx.window.core.layout.WindowWidthSizeClass.Companion.EXPANDED
import androidx.window.core.layout.WindowWidthSizeClass.Companion.MEDIUM

@Composable
fun rememberDimensions(windowSizeClass: WindowSizeClass): State<Dimensions> {
	return produceState(initialValue = CompactDimensions) {
		value =
			when (windowSizeClass.windowWidthSizeClass) {
				COMPACT -> CompactDimensions
				MEDIUM -> MediumDimensions
				EXPANDED -> ExpandedDimensions
				else -> DefaultDimensions
			}
	}
}