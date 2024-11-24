package org.ailtontech.pokedex

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.ailtontech.pokedex.presentation.App

fun main() =
	application {
		Window(
			onCloseRequest = ::exitApplication,
			title = "Pokedex",
		) {
			App()
		}
	}