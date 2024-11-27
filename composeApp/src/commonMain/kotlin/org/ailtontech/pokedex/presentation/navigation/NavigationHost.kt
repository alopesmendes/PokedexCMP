package org.ailtontech.pokedex.presentation.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.ailtontech.pokedex.features.pokemon.presentation.screens.PokemonScreen

@Composable
fun NavigationHost(
	modifier: Modifier = Modifier,
	navigationHostController: NavHostController,
	startDestination: Routes = Routes.HomeRoute,
) {
	NavHost(
		modifier = modifier,
		navController = navigationHostController,
		startDestination = startDestination,
	) {
		composable<Routes.HomeRoute> {
			PokemonScreen(
				modifier = Modifier.fillMaxSize(),
			)
		}

		composable<Routes.LocationRoute> {
		}

		composable<Routes.SettingsRoute> {
		}
	}
}