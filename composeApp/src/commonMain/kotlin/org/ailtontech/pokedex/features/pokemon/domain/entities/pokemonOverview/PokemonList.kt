package org.ailtontech.pokedex.features.pokemon.domain.entities.pokemonOverview

data class PokemonList(
	val count: Int,
	val offset: Int?,
	val limit: Int?,
	val pokemons: List<PokemonListItem>,
)