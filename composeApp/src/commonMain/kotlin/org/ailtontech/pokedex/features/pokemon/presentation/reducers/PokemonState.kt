package org.ailtontech.pokedex.features.pokemon.presentation.reducers

import androidx.compose.runtime.Immutable
import org.ailtontech.pokedex.core.utils.Reducer
import org.ailtontech.pokedex.features.pokemon.domain.entities.pokemonDetail.PokemonDetail
import org.ailtontech.pokedex.features.pokemon.domain.entities.pokemonOverview.PokemonList

@Immutable
data class PokemonState(
	val isLoading: Boolean = false,
	val error: Throwable? = null,
	val pokemonList: PokemonList? = null,
	val currentPokemonDetail: PokemonDetail? = null,
) : Reducer.ViewState