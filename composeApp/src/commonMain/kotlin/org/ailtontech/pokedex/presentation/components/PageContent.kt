package org.ailtontech.pokedex.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun PageContent(
	modifier: Modifier = Modifier,
	isLoading: Boolean,
	error: Throwable?,
	content: @Composable () -> Unit,
) {
	Box(
		modifier = modifier.fillMaxSize(),
	) {
		when {
			isLoading ->
				LoadingComponent(
					modifier = Modifier.fillMaxSize(),
				)
			error != null ->
				ErrorComponent(
					errorMessage = error.message ?: "",
				)
			else -> content()
		}
	}
}