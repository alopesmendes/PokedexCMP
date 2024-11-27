package org.ailtontech.pokedex.features.pokemon.presentation.viewModels

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.ailtontech.pokedex.core.utils.BaseViewModel
import org.ailtontech.pokedex.features.pokemon.presentation.reducers.PokemonEffect
import org.ailtontech.pokedex.features.pokemon.presentation.reducers.PokemonEvent
import org.ailtontech.pokedex.features.pokemon.presentation.reducers.PokemonReducer
import org.ailtontech.pokedex.features.pokemon.presentation.reducers.PokemonState

class PokemonViewModel(
	reducer: PokemonReducer,
) : BaseViewModel<PokemonState, PokemonEvent, PokemonEffect>(
		initialState = PokemonState(),
		reducer = reducer,
	) {
	init {
		loadData()
	}

	private fun loadData() {
		viewModelScope.launch {
			sendEvent(PokemonEvent.GetPokemonList())
		}
	}
}