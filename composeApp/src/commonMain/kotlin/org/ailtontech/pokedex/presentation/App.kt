package org.ailtontech.pokedex.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import coil3.compose.setSingletonImageLoaderFactory
import org.ailtontech.pokedex.presentation.components.PokedexScaffold
import org.ailtontech.pokedex.presentation.navigation.NavigationHost
import org.ailtontech.pokedex.presentation.states.ScaffoldState
import org.ailtontech.pokedex.presentation.theme.PokedexTheme
import org.ailtontech.pokedex.presentation.utils.getAsyncImageLoader
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
	setSingletonImageLoaderFactory {
		getAsyncImageLoader(it)
	}

	PokedexTheme {
		var scaffoldState by remember { mutableStateOf(ScaffoldState()) }
		val navController = rememberNavController()
		PokedexScaffold(
			scaffoldState = scaffoldState,
			onScaffoldStateChange = { scaffoldState = it },
			onNavigate = navController::navigate,
			content = {
				Scaffold {
					NavigationHost(
						modifier = Modifier.padding(it),
						navigationHostController = navController,
					)
				}
			},
		)
	}
}