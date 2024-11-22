package org.ailtontech.pokedex.presentation.theme.dimensions

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.produceState

@Composable
fun rememberDimensions(windowSizeClass: WindowSizeClass): State<Dimensions> {
	return produceState(initialValue = CompactDimensions) {
		value =
			when (windowSizeClass.widthSizeClass) {
				WindowWidthSizeClass.Compact -> CompactDimensions
				WindowWidthSizeClass.Medium -> MediumDimensions
				WindowWidthSizeClass.Expanded -> ExpandedDimensions
				else -> DefaultDimensions
			}
	}
}