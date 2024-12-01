package org.ailtontech.pokedex.features.pokemon.domain.useCases.impl

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flow
import org.ailtontech.pokedex.core.utils.UiState
import org.ailtontech.pokedex.core.utils.mapToUiState
import org.ailtontech.pokedex.features.pokemon.domain.entities.pokemonOverview.PokemonList
import org.ailtontech.pokedex.features.pokemon.domain.repositories.PokemonRepository
import org.ailtontech.pokedex.features.pokemon.domain.useCases.GetPokemonListUseCase

class GetPokemonListUseCaseImpl(
	private val pokemonRepository: PokemonRepository,
) : GetPokemonListUseCase {
	override fun invoke(
		limit: Int?,
		offset: Int?,
	): Flow<UiState<PokemonList>> =
		flow {
			emit(UiState.Loading)

			val result =
				pokemonRepository.getPokemonOverview(
					limit = limit,
					offset = offset,
				)

			emit(result.mapToUiState())
		}.distinctUntilChanged()
}