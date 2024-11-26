package org.ailtontech.pokedex.features.pokemon.presentation.reducers

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.ailtontech.pokedex.core.utils.Reducer
import org.ailtontech.pokedex.features.pokemon.domain.useCases.GetPokemonDetailUseCase
import org.ailtontech.pokedex.features.pokemon.domain.useCases.GetPokemonListUseCase
import org.ailtontech.pokedex.features.pokemon.presentation.mappers.mapUiStatePokemonDetailToPokemonState
import org.ailtontech.pokedex.features.pokemon.presentation.mappers.mapUiStatePokemonListToPokemonState
import kotlin.reflect.KFunction1

class PokemonReducer(
	private val dispatcher: CoroutineDispatcher,
	private val getPokemonListUseCase: GetPokemonListUseCase,
	private val getPokemonDetailUseCase: GetPokemonDetailUseCase,
) : Reducer<PokemonState, PokemonEvent, PokemonEffect> {
	override suspend fun reduce(
		updateState: KFunction1<(PokemonState) -> PokemonState, Unit>,
		event: PokemonEvent,
		sendEvent: (PokemonEvent) -> Unit,
		sendEffect: (PokemonEffect) -> Unit,
	) {
		withContext(dispatcher) {
			launch(dispatcher) {
				when (event) {
					is PokemonEvent.GetPokemonDetail -> {
						getPokemonDetailUseCase(
							name = event.name,
						).collect { state ->
							updateState(state::mapUiStatePokemonDetailToPokemonState)
						}
					}
					is PokemonEvent.GetPokemonList -> {
						getPokemonListUseCase(
							limit = event.limit,
							offset = event.offset,
						).collect { state ->
							updateState(state::mapUiStatePokemonListToPokemonState)
						}
					}
				}
			}
		}
	}
}