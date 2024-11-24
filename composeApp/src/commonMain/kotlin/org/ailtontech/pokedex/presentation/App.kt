package org.ailtontech.pokedex.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.DpSize
import org.ailtontech.pokedex.Greeting
import org.ailtontech.pokedex.presentation.components.TextTitle
import org.ailtontech.pokedex.presentation.theme.PokedexTheme
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import pokedex.composeapp.generated.resources.Res
import pokedex.composeapp.generated.resources.compose_multiplatform

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
@Preview
fun App() {
	BoxWithConstraints(
		modifier = Modifier.fillMaxSize(),
	) {
		val dpSize =
			remember(maxWidth, maxHeight) {
				DpSize(maxWidth, maxHeight)
			}
		val windowSizeClass =
			remember(dpSize) { WindowSizeClass.calculateFromSize(dpSize) }
		PokedexTheme(
			windowSizeClass = windowSizeClass,
		) {
			var showContent by remember { mutableStateOf(false) }
			Column(
				Modifier.fillMaxSize(),
				horizontalAlignment = Alignment.CenterHorizontally,
			) {
				val greeting = remember { Greeting().greet() }

				Button(onClick = { showContent = !showContent }) {
					TextTitle(
						text = "Click me!",
					)
				}
				AnimatedVisibility(showContent) {
					Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
						Image(painterResource(Res.drawable.compose_multiplatform), null)
						Text("Compose: $greeting")
					}
				}
			}
		}
	}
}