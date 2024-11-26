package org.ailtontech.pokedex.features.pokemon.domain.useCases

import kotlinx.coroutines.flow.Flow
import org.ailtontech.pokedex.core.utils.UiState
import org.ailtontech.pokedex.features.pokemon.domain.entities.pokemonDetail.PokemonDetail

interface GetPokemonDetailUseCase {
	/**
	 * Will get pokemon list by starting with [UiState.Loading].
	 *
	 * @param name
	 * @return [Flow] of [UiState] with [PokemonDetail]
	 */
	operator fun invoke(name: String): Flow<UiState<PokemonDetail>>
}