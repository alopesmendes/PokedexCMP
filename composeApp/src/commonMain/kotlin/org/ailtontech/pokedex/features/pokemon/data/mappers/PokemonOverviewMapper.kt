package org.ailtontech.pokedex.features.pokemon.data.mappers

import org.ailtontech.pokedex.core.models.ResultDto
import org.ailtontech.pokedex.core.utils.extractQueryParameterValue
import org.ailtontech.pokedex.features.pokemon.data.models.pokemonOverview.PokemonListDto
import org.ailtontech.pokedex.features.pokemon.domain.entities.pokemonOverview.PokemonList
import org.ailtontech.pokedex.features.pokemon.domain.entities.pokemonOverview.PokemonListItem

internal fun PokemonListDto.mapToPokemonList(mapToPokemon: (ResultDto) -> PokemonListItem): PokemonList =
	PokemonList(
		count = count,
		offset = next?.let { extractQueryParameterValue("offset", it)?.toInt() },
		limit = next?.let { extractQueryParameterValue("limit", it)?.toInt() },
		pokemons = results.map { mapToPokemon(it) },
	)