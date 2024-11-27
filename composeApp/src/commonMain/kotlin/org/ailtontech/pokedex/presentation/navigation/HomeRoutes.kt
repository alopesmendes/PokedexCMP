package org.ailtontech.pokedex.presentation.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed interface HomeRoutes : Routes {
	@Serializable
	data object PokemonListScreen : HomeRoutes

	@Serializable
	data class PokemonDetailScreen(val name: String) : HomeRoutes
}