package org.ailtontech.pokedex.features.pokemon.presentation.reducers

import androidx.compose.runtime.Immutable
import org.ailtontech.pokedex.core.utils.Reducer

@Immutable
sealed interface PokemonEffect : Reducer.ViewEffect {
	data class ShowError(val throwable: Throwable?) : PokemonEffect

	data class NavigateToPokemonDetail(val name: String) : PokemonEffect
}