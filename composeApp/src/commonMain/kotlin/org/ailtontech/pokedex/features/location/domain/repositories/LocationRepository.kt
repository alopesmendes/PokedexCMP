package org.ailtontech.pokedex.features.location.domain.repositories

import org.ailtontech.pokedex.features.location.domain.entities.LocationDetail
import org.ailtontech.pokedex.features.location.domain.entities.LocationList

interface LocationRepository {
	suspend fun getLocationOverview(
		offset: Int?,
		limit: Int?,
	): Result<LocationList>

	suspend fun getLocationDetail(name: String): Result<LocationDetail>
}