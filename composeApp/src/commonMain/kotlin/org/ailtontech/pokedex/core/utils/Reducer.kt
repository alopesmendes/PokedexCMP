package org.ailtontech.pokedex.core.utils

import kotlin.reflect.KFunction1

interface Reducer<State : Reducer.ViewState, Event : Reducer.ViewEvent, Effect : Reducer.ViewEffect> {
	interface ViewState

	interface ViewEvent

	interface ViewEffect

	suspend fun reduce(
		updateState: KFunction1<(State) -> State, Unit>,
		event: Event,
		sendEvent: (Event) -> Unit,
		sendEffect: (Effect) -> Unit,
	)
}