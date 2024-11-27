package org.ailtontech.pokedex.presentation.components

import androidx.compose.runtime.Composable
import androidx.activity.compose.BackHandler as AndroidBackHandler

@Composable
actual fun BackHandler(
	enabled: Boolean,
	onBack: () -> Unit,
) {
	AndroidBackHandler(enabled = enabled, onBack = onBack)
}