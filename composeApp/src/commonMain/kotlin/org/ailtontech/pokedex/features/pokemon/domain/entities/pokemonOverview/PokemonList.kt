package org.ailtontech.pokedex.features.pokemon.domain.entities.pokemonOverview

import kotlin.math.max
import kotlin.math.min

data class PokemonList(
	val count: Int,
	val offset: Int?,
	val limit: Int?,
	val pokemons: List<PokemonListItem>,
) {
	operator fun plus(other: PokemonList): PokemonList {
		return PokemonList(
			count = count,
			offset = offset?.let { other.offset?.let { max(offset, it) } },
			limit = limit?.let { other.limit?.let { min(limit, it) } },
			pokemons = pokemons + other.pokemons,
		)
	}
}