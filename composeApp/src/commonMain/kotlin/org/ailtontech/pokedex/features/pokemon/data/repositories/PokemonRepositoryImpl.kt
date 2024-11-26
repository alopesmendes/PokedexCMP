package org.ailtontech.pokedex.features.pokemon.data.repositories

import kotlinx.coroutines.CoroutineDispatcher
import org.ailtontech.pokedex.core.utils.runSafe
import org.ailtontech.pokedex.features.pokemon.data.datasources.PokemonDetailRemoteDatasource
import org.ailtontech.pokedex.features.pokemon.data.datasources.PokemonOverviewRemoteDatasource
import org.ailtontech.pokedex.features.pokemon.data.mappers.mapToPokemonDetail
import org.ailtontech.pokedex.features.pokemon.data.mappers.mapToPokemonList
import org.ailtontech.pokedex.features.pokemon.data.mappers.mapToPokemonListItem
import org.ailtontech.pokedex.features.pokemon.domain.entities.pokemonDetail.PokemonDetail
import org.ailtontech.pokedex.features.pokemon.domain.entities.pokemonOverview.PokemonList
import org.ailtontech.pokedex.features.pokemon.domain.repositories.PokemonRepository

class PokemonRepositoryImpl(
	private val dispatcher: CoroutineDispatcher,
	private val pokemonOverviewRemoteDatasource: PokemonOverviewRemoteDatasource,
	private val pokemonDetailRemoteDatasource: PokemonDetailRemoteDatasource,
) : PokemonRepository {
	override suspend fun getPokemonOverview(
		limit: Int?,
		offset: Int?,
	): Result<PokemonList> =
		runSafe(dispatcher) {
			val pokemonListDto = pokemonOverviewRemoteDatasource.getPokemonOverview(limit = limit, offset = offset)
			val pokemonDetailsDto =
				pokemonListDto.results.associateWith {
					pokemonDetailRemoteDatasource.getPokemonDetail(it.name)
				}
			pokemonListDto.mapToPokemonList {
				pokemonDetailsDto[it]?.mapToPokemonListItem() ?: error("Pokemon detail not found")
			}
		}

	override suspend fun getPokemonDetail(name: String): Result<PokemonDetail> =
		runSafe(dispatcher) {
			val pokemonDetailDto = pokemonDetailRemoteDatasource.getPokemonDetail(name)
			pokemonDetailDto.mapToPokemonDetail()
		}
}