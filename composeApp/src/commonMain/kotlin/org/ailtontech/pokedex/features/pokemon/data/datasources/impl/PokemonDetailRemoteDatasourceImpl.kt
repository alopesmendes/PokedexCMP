package org.ailtontech.pokedex.features.pokemon.data.datasources.impl

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.path
import org.ailtontech.pokedex.features.pokemon.data.datasources.PokemonDetailRemoteDatasource
import org.ailtontech.pokedex.features.pokemon.data.models.PokemonDetailDto

class PokemonDetailRemoteDatasourceImpl(
	private val httpClient: HttpClient,
) : PokemonDetailRemoteDatasource {
	override suspend fun getPokemonDetail(name: String): PokemonDetailDto {
		val response =
			httpClient.get {
				url {
					path("pokemon/$name")
				}
			}
		return response.body()
	}
}