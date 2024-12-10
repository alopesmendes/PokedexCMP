package org.ailtontech.pokedex.features.location.data.datasources.impl

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.http.path
import org.ailtontech.pokedex.features.location.data.datasources.LocationsRemoteDatasource
import org.ailtontech.pokedex.features.location.data.models.LocationDetailDto
import org.ailtontech.pokedex.features.location.data.models.LocationListDto

class LocationsRemoteDatasourceImpl(
	private val httpClient: HttpClient,
) : LocationsRemoteDatasource {
	override suspend fun getLocations(
		limit: Int?,
		offset: Int?,
	): LocationListDto {
		val response =
			httpClient.get {
				url {
					path("location")
					parameter("limit", limit)
					parameter("offset", offset)
				}
			}
		return response.body()
	}

	override suspend fun getLocationDetail(name: String): LocationDetailDto {
		val response =
			httpClient.get {
				url {
					path("location/$name")
				}
			}
		return response.body()
	}
}