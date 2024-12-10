package org.ailtontech.pokedex.presentation.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.ailtontech.pokedex.features.location.presentation.screens.LocationScreen
import org.ailtontech.pokedex.features.pokemon.presentation.screens.PokemonScreen
import org.ailtontech.pokedex.presentation.states.ScaffoldState

@Composable
fun NavigationHost(
	modifier: Modifier = Modifier,
	navigationHostController: NavHostController,
	startDestination: Routes = Routes.HomeRoute,
	scaffoldState: ScaffoldState,
	onScaffoldStateChange: (ScaffoldState) -> Unit,
) {
	NavHost(
		modifier = modifier,
		navController = navigationHostController,
		startDestination = startDestination,
	) {
		composable<Routes.HomeRoute> {
			PokemonScreen(
				modifier = Modifier.fillMaxSize(),
				scaffoldState = scaffoldState,
				onScaffoldStateChange = onScaffoldStateChange,
			)
		}

		composable<Routes.LocationRoute> {
			LocationScreen(
				modifier = Modifier.fillMaxSize(),
				scaffoldState = scaffoldState,
				onScaffoldStateChange = onScaffoldStateChange,
			)
		}

		composable<Routes.SettingsRoute> {
		}
	}
}