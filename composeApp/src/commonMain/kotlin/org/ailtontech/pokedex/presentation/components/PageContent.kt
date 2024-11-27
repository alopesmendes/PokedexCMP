package org.ailtontech.pokedex.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun PageContent(
	modifier: Modifier = Modifier,
	isLoading: Boolean,
	error: Throwable?,
	topBar: @Composable () -> Unit = {},
	snackbarHost: @Composable () -> Unit = {},
	floatingActionButton: @Composable () -> Unit = {},
	floatingActionButtonPosition: FabPosition = FabPosition.End,
	content: @Composable () -> Unit,
) {
	Scaffold(
		modifier = modifier,
		topBar = topBar,
		snackbarHost = snackbarHost,
		floatingActionButton = floatingActionButton,
		floatingActionButtonPosition = floatingActionButtonPosition,
	) { paddingValues ->
		Box(
			modifier =
				Modifier
					.padding(paddingValues)
					.fillMaxSize(),
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
}