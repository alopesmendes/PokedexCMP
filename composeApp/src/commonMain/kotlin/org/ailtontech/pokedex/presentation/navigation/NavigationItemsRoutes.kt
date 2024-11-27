package org.ailtontech.pokedex.presentation.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed interface NavigationItemsRoutes : Routes {
	@Serializable
	data object HomeScreen : NavigationItemsRoutes

	@Serializable
	data object LocationScreen : NavigationItemsRoutes

	@Serializable
	data object SettingsScreen : NavigationItemsRoutes
}