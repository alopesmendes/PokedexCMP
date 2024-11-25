package org.ailtontech.pokedex.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.OpenInFull
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import coil3.compose.setSingletonImageLoaderFactory
import org.ailtontech.pokedex.Greeting
import org.ailtontech.pokedex.presentation.components.PokedexFloatingActionButton
import org.ailtontech.pokedex.presentation.components.PokedexScaffold
import org.ailtontech.pokedex.presentation.states.ScaffoldState
import org.ailtontech.pokedex.presentation.theme.PokedexTheme
import org.ailtontech.pokedex.presentation.utils.getAsyncImageLoader
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import pokedex.composeapp.generated.resources.Res
import pokedex.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun App() {
	setSingletonImageLoaderFactory {
		getAsyncImageLoader(it)
	}

	PokedexTheme {
		var scaffoldState by remember { mutableStateOf(ScaffoldState()) }
		PokedexScaffold(
			scaffoldState = scaffoldState,
			onScaffoldStateChange = { scaffoldState = it },
			content = {
				var showContent by remember { mutableStateOf(false) }
				Column(
					Modifier.fillMaxSize(),
					horizontalAlignment = Alignment.CenterHorizontally,
				) {
					val greeting = remember { Greeting().greet() }

					PokedexFloatingActionButton(
						onClick = { showContent = !showContent },
						icon = Icons.Filled.OpenInFull,
						label = "Toggle Content",
					)

					AnimatedVisibility(showContent) {
						Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
							Image(painterResource(Res.drawable.compose_multiplatform), null)
							Text("Compose: $greeting")
						}
					}
				}
			},
		)
	}
}