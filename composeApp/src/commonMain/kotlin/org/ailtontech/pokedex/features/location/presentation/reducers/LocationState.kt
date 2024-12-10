package org.ailtontech.pokedex.features.location.presentation.reducers

import androidx.compose.runtime.Immutable
import org.ailtontech.pokedex.core.utils.Reducer
import org.ailtontech.pokedex.features.location.domain.entities.LocationDetail
import org.ailtontech.pokedex.features.location.domain.entities.LocationList

@Immutable
data class LocationState(
	val isLocationsLoading: Boolean = false,
	val isLocationDetailLoading: Boolean = false,
	val error: Throwable? = null,
	val locations: LocationList? = null,
	val currentLocationDetail: LocationDetail? = null,
) : Reducer.ViewState