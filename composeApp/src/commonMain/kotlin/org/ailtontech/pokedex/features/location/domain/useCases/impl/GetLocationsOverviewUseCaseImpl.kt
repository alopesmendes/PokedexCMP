package org.ailtontech.pokedex.features.location.domain.useCases.impl

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.ailtontech.pokedex.core.utils.UiState
import org.ailtontech.pokedex.core.utils.mapToUiState
import org.ailtontech.pokedex.features.location.domain.entities.LocationList
import org.ailtontech.pokedex.features.location.domain.repositories.LocationRepository
import org.ailtontech.pokedex.features.location.domain.useCases.GetLocationsOverviewUseCase

class GetLocationsOverviewUseCaseImpl(
	private val locationRepository: LocationRepository,
) : GetLocationsOverviewUseCase {
	override fun invoke(
		offset: Int?,
		limit: Int?,
	): Flow<UiState<LocationList>> =
		flow {
			emit(UiState.Loading)

			val result = locationRepository.getLocationOverview(offset = offset, limit = limit)

			emit(result.mapToUiState())
		}
}