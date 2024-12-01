package org.ailtontech.pokedex.features.pokemon.domain.repositories

import org.ailtontech.pokedex.features.pokemon.domain.entities.pokemonDetail.PokemonDetail
import org.ailtontech.pokedex.features.pokemon.domain.entities.pokemonOverview.PokemonList

interface PokemonRepository {
	/**
	 * Get all pokemons from offset and limit
	 *
	 * @param limit
	 * @param offset
	 * @return [Result] of [PokemonList]
	 */
	suspend fun getPokemonOverview(
		limit: Int?,
		offset: Int?,
	): Result<PokemonList>

	/**
	 * Get pokemon detail from the name
	 *
	 * @param name
	 * @return [Result] of [PokemonDetail]
	 */
	suspend fun getPokemonDetail(name: String): Result<PokemonDetail>
}