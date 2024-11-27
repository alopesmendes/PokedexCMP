package org.ailtontech.pokedex.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.ailtontech.pokedex.features.pokemon.presentation.screens.PokemonOverviewScreen
import org.ailtontech.pokedex.features.pokemon.presentation.viewModels.PokemonViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun NavigationHost(
	modifier: Modifier = Modifier,
	navigationHostController: NavHostController,
	startDestination: Routes,
) {
	NavHost(
		modifier = modifier,
		navController = navigationHostController,
		startDestination = startDestination,
	) {
		composable<HomeRoutes.PokemonListScreen> {
			val pokemonViewModel: PokemonViewModel = koinViewModel()

			PokemonOverviewScreen(
				pokemonViewModel = pokemonViewModel,
			)
		}
	}
}