package org.ailtontech.pokedex.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.ailtontech.pokedex.Greeting
import org.ailtontech.pokedex.presentation.theme.PokedexTheme
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import pokedex.composeapp.generated.resources.Res
import pokedex.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun App() {
	PokedexTheme {
		var showContent by remember { mutableStateOf(false) }
		Column(
			Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background),
			horizontalAlignment = Alignment.CenterHorizontally
		) {
			Button(onClick = { showContent = !showContent }) {
				Text("Click me!")
			}
			AnimatedVisibility(showContent) {
				val greeting = remember { Greeting().greet() }
				Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
					Image(painterResource(Res.drawable.compose_multiplatform), null)
					Text("Compose: $greeting")
				}
			}
		}
	}
}