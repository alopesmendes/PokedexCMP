package org.ailtontech.pokedex.features.pokemon.domain.entities.pokemonOverview

import org.ailtontech.pokedex.features.pokemon.domain.entities.Sprites
import org.ailtontech.pokedex.features.pokemon.domain.entities.Type

data class PokemonListItem(
	val name: String,
	val sprites: Sprites,
	val types: List<Type>,
	val locationAreaEncounters: String,
)