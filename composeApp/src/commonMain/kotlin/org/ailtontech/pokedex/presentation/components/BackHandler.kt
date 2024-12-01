package org.ailtontech.pokedex.presentation.components

import androidx.compose.runtime.Composable

@Composable
expect fun BackHandler(
	enabled: Boolean = true,
	onBack: () -> Unit = {},
)