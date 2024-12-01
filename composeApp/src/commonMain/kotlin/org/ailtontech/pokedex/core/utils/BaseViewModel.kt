package org.ailtontech.pokedex.core.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

abstract class BaseViewModel<State : Reducer.ViewState, Event : Reducer.ViewEvent, Effect : Reducer.ViewEffect>(
	private val initialState: State,
	private val reducer: Reducer<State, Event, Effect>,
) : ViewModel() {
	private val _state: MutableStateFlow<State> = MutableStateFlow(initialState)
	val state: StateFlow<State>
		get() =
			_state.asStateFlow()

	private val _event: MutableSharedFlow<Event> = MutableSharedFlow()
	val event: SharedFlow<Event>
		get() = _event.asSharedFlow()

	private val _effects = Channel<Effect>(capacity = Channel.CONFLATED)
	val effects = _effects.receiveAsFlow()

	init {
		handleEvents()
	}

	fun sendEvent(vararg events: Event) {
		viewModelScope.launch {
			events.forEach {
				_event.emit(it)
			}
		}
	}

	fun sendEffect(vararg effects: Effect) {
		viewModelScope.launch {
			effects.forEach {
				_effects.send(it)
			}
		}
	}

	private fun handleEvents() {
		viewModelScope.launch {
			_event.collect {
				reducer.reduce(
					updateState = _state::update,
					event = it,
					sendEvent = ::sendEvent,
					sendEffect = ::sendEffect,
				)
			}
		}
	}
}