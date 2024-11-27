package org.ailtontech.pokedex.presentation.components

import androidx.compose.runtime.Composable

@Composable
actual fun BackHandler(
	enabled: Boolean,
	onBack: () -> Unit,
) {
	// Back gesture for iOS is still not implemented
}