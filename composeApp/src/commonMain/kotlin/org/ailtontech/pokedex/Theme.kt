package org.ailtontech.pokedex

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import org.koin.compose.KoinContext

@Composable
fun PokedexTheme(content: @Composable () -> Unit) {
	KoinContext {
		MaterialTheme(
			content = content,
		)
	}
}