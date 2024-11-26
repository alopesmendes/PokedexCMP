package org.ailtontech.pokedex.features.pokemon.data.repositories

import dev.mokkery.answering.returns
import dev.mokkery.answering.throws
import dev.mokkery.everySuspend
import dev.mokkery.matcher.any
import dev.mokkery.mock
import dev.mokkery.verify.VerifyMode.Companion.exactly
import dev.mokkery.verify.VerifyMode.Companion.not
import dev.mokkery.verifySuspend
import io.kotest.matchers.result.shouldBeFailure
import io.kotest.matchers.result.shouldBeSuccess
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.ailtontech.pokedex.core.models.ResultDto
import org.ailtontech.pokedex.features.pokemon.data.datasources.PokemonDetailRemoteDatasource
import org.ailtontech.pokedex.features.pokemon.data.datasources.PokemonOverviewRemoteDatasource
import org.ailtontech.pokedex.features.pokemon.data.mappers.mapToPokemonDetail
import org.ailtontech.pokedex.features.pokemon.data.mappers.mapToPokemonList
import org.ailtontech.pokedex.features.pokemon.data.mappers.mapToPokemonListItem
import org.ailtontech.pokedex.features.pokemon.data.models.pokemonOverview.PokemonListDto
import org.ailtontech.pokedex.features.pokemon.domain.repositories.PokemonRepository
import utils.createPokemonDetailDto
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test

@OptIn(ExperimentalCoroutinesApi::class)
class PokemonRepositoryImplTest {
	private val dispatcher = Dispatchers.Unconfined
	private lateinit var pokemonOverviewRemoteDatasource: PokemonOverviewRemoteDatasource
	private lateinit var pokemonDetailRemoteDatasource: PokemonDetailRemoteDatasource
	private lateinit var pokemonRepository: PokemonRepository

	@BeforeTest
	fun setUp() {
		Dispatchers.setMain(dispatcher)
		pokemonOverviewRemoteDatasource = mock()
		pokemonDetailRemoteDatasource = mock()
		pokemonRepository =
			PokemonRepositoryImpl(
				dispatcher = dispatcher,
				pokemonOverviewRemoteDatasource = pokemonOverviewRemoteDatasource,
				pokemonDetailRemoteDatasource = pokemonDetailRemoteDatasource,
			)
	}

	@AfterTest
	fun teardown() {
		Dispatchers.resetMain()
	}

	@Test
	fun shouldReturnPokemonList_whenRequestIsSuccessful() =
		runTest {
			// given:
			val results = (1..10).map { ResultDto(name = "pokemon$it", url = "url$it") }
			val pokemonDetailDtoList =
				List(results.size) {
					createPokemonDetailDto(
						id = it + 1,
						resultDto = results[it],
					)
				}
			val pokemonListDto =
				PokemonListDto(
					count = 10,
					next = null,
					previous = null,
					results = results,
				)

			// when:
			everySuspend { pokemonOverviewRemoteDatasource.getPokemonOverview(any(), any()) } returns pokemonListDto
			results.forEachIndexed { index, result ->
				everySuspend {
					pokemonDetailRemoteDatasource.getPokemonDetail(result.name)
				} returns pokemonDetailDtoList[index]
			}

			val result = pokemonRepository.getPokemonOverview(10, 0)

			// then:
			verifySuspend(exactly(1)) {
				pokemonOverviewRemoteDatasource.getPokemonOverview(any(), any())
			}

			verifySuspend(exactly(results.size)) {
				pokemonDetailRemoteDatasource.getPokemonDetail(any())
			}
			val expectedPokemonList =
				pokemonListDto.mapToPokemonList {
					val index = results.indexOf(it)
					pokemonDetailDtoList[index].mapToPokemonListItem()
				}

			result shouldBeSuccess expectedPokemonList
		}

	@Test
	fun shouldNotReturnPokemonList_whenRequestIsNotSuccessful() =
		runTest {
			// given:
			val exception = Exception()

			// when:
			everySuspend { pokemonOverviewRemoteDatasource.getPokemonOverview(any(), any()) } throws exception
			val result = pokemonRepository.getPokemonOverview(limit = 10, offset = 0)

			// then:
			verifySuspend(exactly(1)) {
				pokemonOverviewRemoteDatasource.getPokemonOverview(any(), any())
			}
			verifySuspend(not) {
				pokemonDetailRemoteDatasource.getPokemonDetail(any())
			}
			result shouldBeFailure exception
		}

	@Test
	fun shouldReturnPokemonDetail_whenRequestIsSuccessful() =
		runTest {
			// given:
			val name = "Pikachu"
			val pokemonDetailDto = createPokemonDetailDto()

			// when:
			everySuspend { pokemonDetailRemoteDatasource.getPokemonDetail(any()) } returns pokemonDetailDto

			val result = pokemonRepository.getPokemonDetail(name)

			// then:
			verifySuspend(exactly(1)) {
				pokemonDetailRemoteDatasource.getPokemonDetail(any())
			}
			val expectedPokemonDetail = pokemonDetailDto.mapToPokemonDetail()
			result shouldBeSuccess expectedPokemonDetail
		}

	@Test
	fun shouldNotReturnPokemonDetail_whenRequestIsNotSuccessful() =
		runTest {
			// given:
			val exception = Exception()

			// when:
			everySuspend { pokemonDetailRemoteDatasource.getPokemonDetail(any()) } throws exception

			val result = pokemonRepository.getPokemonDetail(name = "Pikachu")

			// then:
			verifySuspend(exactly(1)) {
				pokemonDetailRemoteDatasource.getPokemonDetail(any())
			}
			result shouldBeFailure exception
		}
}