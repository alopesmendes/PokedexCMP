package org.ailtontech.pokedex.features.pokemon.data.datasources

import org.ailtontech.pokedex.features.pokemon.data.models.PokemonDetailDto

fun interface PokemonDetailRemoteDatasource {
	suspend fun getPokemonDetail(name: String): PokemonDetailDto
}