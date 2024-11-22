package org.ailtontech.pokedex.presentation.theme.type

import androidx.compose.material3.Typography
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.produceState

@Composable
fun rememberTypography(windowSizeClass: WindowSizeClass): State<Typography> {
	return produceState(initialValue = CompactTypography, windowSizeClass) {
		value =
			when (windowSizeClass.widthSizeClass) {
				WindowWidthSizeClass.Compact -> CompactTypography
				WindowWidthSizeClass.Medium -> MediumTypography
				WindowWidthSizeClass.Expanded -> ExpandedTypography
				else -> CompactTypography
			}
	}
}