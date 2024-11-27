package org.ailtontech.pokedex.presentation.navigation

import kotlinx.serialization.Serializable
import org.ailtontech.pokedex.presentation.states.NavigationItem

@Serializable
sealed interface Routes {
	@Serializable
	data object HomeRoute : Routes

	@Serializable
	data object LocationRoute : Routes

	@Serializable
	data object SettingsRoute : Routes
}

fun NavigationItem.mapToRoute(): Routes =
	when (this) {
		NavigationItem.Home -> Routes.HomeRoute
		NavigationItem.Location -> Routes.LocationRoute
		NavigationItem.Settings -> Routes.SettingsRoute
	}