package org.ailtontech.pokedex.features.pokemon.presentation.reducers

import androidx.compose.runtime.Immutable
import org.ailtontech.pokedex.core.utils.Reducer

@Immutable
sealed interface PokemonEvent : Reducer.ViewEvent {
	data class GetPokemonList(
		val limit: Int? = null,
		val offset: Int? = null,
	) : PokemonEvent

	data class GetPokemonDetail(
		val name: String,
	) : PokemonEvent
}