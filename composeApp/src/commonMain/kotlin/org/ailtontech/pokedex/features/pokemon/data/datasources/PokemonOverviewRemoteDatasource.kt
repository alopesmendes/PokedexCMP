package org.ailtontech.pokedex.features.pokemon.data.datasources

import org.ailtontech.pokedex.features.pokemon.data.models.pokemonOverview.PokemonListDto

fun interface PokemonOverviewRemoteDatasource {
	suspend fun getPokemonOverview(
		limit: Int?,
		offset: Int?,
	): PokemonListDto
}