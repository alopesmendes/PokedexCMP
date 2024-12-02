package org.ailtontech.pokedex.features.location.presentation.viewModels

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.ailtontech.pokedex.core.utils.BaseViewModel
import org.ailtontech.pokedex.features.location.presentation.reducers.LocationEffect
import org.ailtontech.pokedex.features.location.presentation.reducers.LocationEvent
import org.ailtontech.pokedex.features.location.presentation.reducers.LocationReducer
import org.ailtontech.pokedex.features.location.presentation.reducers.LocationState

class LocationViewModel(
	reducer: LocationReducer,
) : BaseViewModel<LocationState, LocationEvent, LocationEffect>(
		initialState = LocationState(),
		reducer = reducer,
	) {
	init {
		loadData()
	}

	private fun loadData() {
		viewModelScope.launch {
			sendEvent(LocationEvent.GetLocations())
		}
	}
}