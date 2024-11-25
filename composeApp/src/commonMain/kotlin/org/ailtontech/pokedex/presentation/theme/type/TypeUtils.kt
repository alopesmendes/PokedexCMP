package org.ailtontech.pokedex.presentation.theme.type

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.produceState
import androidx.window.core.layout.WindowSizeClass
import androidx.window.core.layout.WindowWidthSizeClass.Companion.COMPACT
import androidx.window.core.layout.WindowWidthSizeClass.Companion.EXPANDED
import androidx.window.core.layout.WindowWidthSizeClass.Companion.MEDIUM

@Composable
fun rememberTypography(windowSizeClass: WindowSizeClass): State<Typography> {
	return produceState(initialValue = CompactTypography, windowSizeClass) {
		value =
			when (windowSizeClass.windowWidthSizeClass) {
				COMPACT -> CompactTypography
				MEDIUM -> MediumTypography
				EXPANDED -> ExpandedTypography
				else -> CompactTypography
			}
	}
}