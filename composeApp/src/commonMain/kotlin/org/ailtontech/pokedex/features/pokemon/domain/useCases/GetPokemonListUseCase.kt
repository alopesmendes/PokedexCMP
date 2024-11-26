package org.ailtontech.pokedex.features.pokemon.domain.useCases

import kotlinx.coroutines.flow.Flow
import org.ailtontech.pokedex.core.utils.UiState
import org.ailtontech.pokedex.features.pokemon.domain.entities.pokemonOverview.PokemonList

fun interface GetPokemonListUseCase {
	/**
	 * Will get pokemon list by starting with [UiState.Loading].
	 *
	 * @param limit
	 * @param offset
	 * @return [Flow] of [UiState] with [PokemonList]
	 */
	operator fun invoke(
		limit: Int?,
		offset: Int?,
	): Flow<UiState<PokemonList>>
}