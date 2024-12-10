package org.ailtontech.pokedex.features.location.domain.useCases

import kotlinx.coroutines.flow.Flow
import org.ailtontech.pokedex.core.utils.UiState
import org.ailtontech.pokedex.features.location.domain.entities.LocationList

interface GetLocationsOverviewUseCase {
	operator fun invoke(
		offset: Int?,
		limit: Int?,
	): Flow<UiState<LocationList>>
}