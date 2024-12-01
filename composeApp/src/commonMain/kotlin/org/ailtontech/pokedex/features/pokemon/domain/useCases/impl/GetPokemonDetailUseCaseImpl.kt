package org.ailtontech.pokedex.features.pokemon.domain.useCases.impl

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.ailtontech.pokedex.core.utils.UiState
import org.ailtontech.pokedex.core.utils.mapToUiState
import org.ailtontech.pokedex.features.pokemon.domain.entities.pokemonDetail.PokemonDetail
import org.ailtontech.pokedex.features.pokemon.domain.repositories.PokemonRepository
import org.ailtontech.pokedex.features.pokemon.domain.useCases.GetPokemonDetailUseCase

class GetPokemonDetailUseCaseImpl(
	private val pokemonRepository: PokemonRepository,
) : GetPokemonDetailUseCase {
	override fun invoke(name: String): Flow<UiState<PokemonDetail>> =
		flow {
			emit(UiState.Loading)

			val result = pokemonRepository.getPokemonDetail(name)

			emit(result.mapToUiState())
		}
}