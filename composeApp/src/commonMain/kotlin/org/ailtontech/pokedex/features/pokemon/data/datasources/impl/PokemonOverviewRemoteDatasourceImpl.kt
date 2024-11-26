package org.ailtontech.pokedex.features.pokemon.data.datasources.impl

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.http.path
import org.ailtontech.pokedex.features.pokemon.data.datasources.PokemonOverviewRemoteDatasource
import org.ailtontech.pokedex.features.pokemon.data.models.PokemonListDto

class PokemonOverviewRemoteDatasourceImpl(
	private val httpClient: HttpClient,
) : PokemonOverviewRemoteDatasource {
	override suspend fun getPokemonOverview(
		limit: Int?,
		offset: Int?,
	): PokemonListDto {
		val response =
			httpClient.get {
				url {
					path("pokemon")
					parameter("limit", limit)
					parameter("offset", offset)
				}
			}
		return response.body()
	}
}