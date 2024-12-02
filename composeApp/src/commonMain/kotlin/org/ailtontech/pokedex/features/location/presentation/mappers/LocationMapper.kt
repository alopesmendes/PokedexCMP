package org.ailtontech.pokedex.features.location.presentation.mappers

import org.ailtontech.pokedex.core.utils.UiState
import org.ailtontech.pokedex.features.location.domain.entities.LocationDetail
import org.ailtontech.pokedex.features.location.domain.entities.LocationList
import org.ailtontech.pokedex.features.location.presentation.reducers.LocationState

internal fun UiState<LocationList>.mapUiStateLocationListToLocationState(state: LocationState): LocationState {
	return when (this) {
		is UiState.Error -> {
			state.copy(
				isLocationsLoading = false,
				error = throwable,
			)
		}
		UiState.Loading -> {
			state.copy(isLocationsLoading = true)
		}
		is UiState.Success -> {
			state.copy(
				isLocationsLoading = false,
				locations = state.locations?.plus(data) ?: data,
			)
		}
	}
}

internal fun UiState<LocationDetail>.mapUiStateLocationDetailToLocationState(state: LocationState): LocationState {
	return when (this) {
		is UiState.Error -> {
			state.copy(
				isLocationDetailLoading = false,
				error = throwable,
			)
		}
		UiState.Loading -> {
			state.copy(isLocationDetailLoading = true)
		}
		is UiState.Success -> {
			state.copy(
				isLocationDetailLoading = false,
				currentLocationDetail = data,
			)
		}
	}
}