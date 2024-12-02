package org.ailtontech.pokedex.features.location.presentation.reducers

import androidx.compose.runtime.Immutable
import org.ailtontech.pokedex.core.utils.Reducer

@Immutable
sealed interface LocationEvent : Reducer.ViewEvent {
	data class GetLocations(
		val offset: Int? = null,
		val limit: Int? = null,
	) : LocationEvent

	data class GetLocationDetail(
		val name: String,
	) : LocationEvent
}