package org.ailtontech.pokedex.features.location.domain.useCases.impl

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.ailtontech.pokedex.core.utils.UiState
import org.ailtontech.pokedex.core.utils.mapToUiState
import org.ailtontech.pokedex.features.location.domain.entities.LocationDetail
import org.ailtontech.pokedex.features.location.domain.repositories.LocationRepository
import org.ailtontech.pokedex.features.location.domain.useCases.GetLocationDetailUseCase

class GetLocationDetailUseCaseImpl(
	private val locationRepository: LocationRepository,
) : GetLocationDetailUseCase {
	override fun invoke(name: String): Flow<UiState<LocationDetail>> =
		flow {
			emit(UiState.Loading)

			val result = locationRepository.getLocationDetail(name)

			emit(result.mapToUiState())
		}
}