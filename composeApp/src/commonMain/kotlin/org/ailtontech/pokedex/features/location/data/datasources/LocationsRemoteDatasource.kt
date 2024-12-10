package org.ailtontech.pokedex.features.location.data.datasources

import org.ailtontech.pokedex.features.location.data.models.LocationDetailDto
import org.ailtontech.pokedex.features.location.data.models.LocationListDto

interface LocationsRemoteDatasource {
	suspend fun getLocations(
		limit: Int?,
		offset: Int?,
	): LocationListDto

	suspend fun getLocationDetail(name: String): LocationDetailDto
}