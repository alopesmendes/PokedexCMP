package org.ailtontech.pokedex.features.pokemon.presentation.mappers

import org.ailtontech.pokedex.core.utils.UiState
import org.ailtontech.pokedex.features.pokemon.domain.entities.pokemonDetail.PokemonDetail
import org.ailtontech.pokedex.features.pokemon.domain.entities.pokemonOverview.PokemonList
import org.ailtontech.pokedex.features.pokemon.presentation.reducers.PokemonState

internal fun UiState<PokemonList>.mapUiStatePokemonListToPokemonState(pokemonState: PokemonState): PokemonState {
	return when (this) {
		is UiState.Error ->
			pokemonState.copy(
				isLoading = false,
				error = throwable,
			)

		UiState.Loading ->
			pokemonState.copy(
				isLoading = true,
			)

		is UiState.Success ->
			pokemonState.copy(
				isLoading = false,
				pokemonList = pokemonState.pokemonList?.plus(data) ?: data,
			)
	}
}

internal fun UiState<PokemonDetail>.mapUiStatePokemonDetailToPokemonState(pokemonState: PokemonState): PokemonState {
	return when (this) {
		is UiState.Error ->
			pokemonState.copy(
				isLoading = false,
				error = throwable,
			)
		UiState.Loading ->
			pokemonState.copy(
				isLoading = true,
			)
		is UiState.Success ->
			pokemonState.copy(
				isLoading = false,
				currentPokemonDetail = data,
			)
	}
}