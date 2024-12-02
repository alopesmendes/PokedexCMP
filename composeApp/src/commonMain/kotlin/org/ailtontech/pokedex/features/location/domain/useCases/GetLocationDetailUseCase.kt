package org.ailtontech.pokedex.features.location.domain.useCases

import kotlinx.coroutines.flow.Flow
import org.ailtontech.pokedex.core.utils.UiState
import org.ailtontech.pokedex.features.location.domain.entities.LocationDetail

interface GetLocationDetailUseCase {
	operator fun invoke(name: String): Flow<UiState<LocationDetail>>
}