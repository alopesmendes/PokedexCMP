package org.ailtontech.pokedex.features.pokemon.domain.entities.pokemonDetail

import org.ailtontech.pokedex.features.pokemon.domain.entities.Sprites
import org.ailtontech.pokedex.features.pokemon.domain.entities.Type

data class PokemonDetail(
	val baseExperience: Int,
	val moves: List<Move>,
	val name: String,
	val order: Int,
	val sprites: Sprites,
	val stats: List<Stat>,
	val types: List<Type>,
	val weight: Int,
)