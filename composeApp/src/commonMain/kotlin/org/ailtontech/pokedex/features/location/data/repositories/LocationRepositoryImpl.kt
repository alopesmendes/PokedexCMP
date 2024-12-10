package org.ailtontech.pokedex.features.location.data.repositories

import kotlinx.coroutines.CoroutineDispatcher
import org.ailtontech.pokedex.core.utils.runSafe
import org.ailtontech.pokedex.features.location.data.datasources.LocationsRemoteDatasource
import org.ailtontech.pokedex.features.location.data.mappers.mapToLocationDetail
import org.ailtontech.pokedex.features.location.data.mappers.mapToLocationList
import org.ailtontech.pokedex.features.location.domain.entities.LocationDetail
import org.ailtontech.pokedex.features.location.domain.entities.LocationList
import org.ailtontech.pokedex.features.location.domain.repositories.LocationRepository

class LocationRepositoryImpl(
	private val dispatcher: CoroutineDispatcher,
	private val locationsRemoteDatasource: LocationsRemoteDatasource,
) : LocationRepository {
	override suspend fun getLocationOverview(
		offset: Int?,
		limit: Int?,
	): Result<LocationList> =
		runSafe(dispatcher) {
			locationsRemoteDatasource
				.getLocations(offset = offset, limit = limit)
				.mapToLocationList()
		}

	override suspend fun getLocationDetail(name: String): Result<LocationDetail> =
		runSafe(dispatcher) {
			locationsRemoteDatasource
				.getLocationDetail(name)
				.mapToLocationDetail()
		}
}