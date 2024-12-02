package org.ailtontech.pokedex.features.location.presentation.reducers

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import org.ailtontech.pokedex.core.utils.Reducer
import org.ailtontech.pokedex.features.location.domain.useCases.GetLocationDetailUseCase
import org.ailtontech.pokedex.features.location.domain.useCases.GetLocationsOverviewUseCase
import org.ailtontech.pokedex.features.location.presentation.mappers.mapUiStateLocationDetailToLocationState
import org.ailtontech.pokedex.features.location.presentation.mappers.mapUiStateLocationListToLocationState
import kotlin.reflect.KFunction1

class LocationReducer(
	private val dispatcher: CoroutineDispatcher,
	private val getLocationsOverviewUseCase: GetLocationsOverviewUseCase,
	private val getLocationsDetailUseCase: GetLocationDetailUseCase,
) : Reducer<LocationState, LocationEvent, LocationEffect> {
	override suspend fun reduce(
		updateState: KFunction1<(LocationState) -> LocationState, Unit>,
		event: LocationEvent,
		sendEvent: (LocationEvent) -> Unit,
		sendEffect: (LocationEffect) -> Unit,
	) {
		withContext(dispatcher) {
			when (event) {
				is LocationEvent.GetLocationDetail -> {
					getLocationsDetailUseCase(
						name = event.name,
					).collect { state ->
						updateState(state::mapUiStateLocationDetailToLocationState)
					}
				}
				is LocationEvent.GetLocations -> {
					getLocationsOverviewUseCase(
						limit = event.limit,
						offset = event.offset,
					).collect { state ->
						updateState(state::mapUiStateLocationListToLocationState)
					}
				}
			}
		}
	}
}