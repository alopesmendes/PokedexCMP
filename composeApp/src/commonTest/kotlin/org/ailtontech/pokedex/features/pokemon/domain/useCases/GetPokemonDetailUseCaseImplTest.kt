package org.ailtontech.pokedex.features.pokemon.domain.useCases

import app.cash.turbine.test
import dev.mokkery.answering.returns
import dev.mokkery.everySuspend
import dev.mokkery.matcher.any
import dev.mokkery.mock
import dev.mokkery.verify.VerifyMode.Companion.exactly
import dev.mokkery.verifySuspend
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.ailtontech.pokedex.core.utils.UiState
import org.ailtontech.pokedex.features.pokemon.domain.entities.Sprites
import org.ailtontech.pokedex.features.pokemon.domain.entities.pokemonDetail.PokemonDetail
import org.ailtontech.pokedex.features.pokemon.domain.repositories.PokemonRepository
import org.ailtontech.pokedex.features.pokemon.domain.useCases.impl.GetPokemonDetailUseCaseImpl
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test

@OptIn(ExperimentalCoroutinesApi::class)
class GetPokemonDetailUseCaseImplTest {
	private val dispatcher = Dispatchers.Unconfined
	private lateinit var pokemonRepository: PokemonRepository
	private lateinit var getPokemonDetailUseCase: GetPokemonDetailUseCase

	@BeforeTest
	fun setUp() {
		Dispatchers.setMain(dispatcher)
		pokemonRepository = mock()
		getPokemonDetailUseCase = GetPokemonDetailUseCaseImpl(pokemonRepository)
	}

	@AfterTest
	fun teardown() {
		Dispatchers.resetMain()
	}

	@Test
	fun shouldGetPokemonDetail_whenRequestIsSuccessful() =
		runTest {
			// given:
			val name = "Pikachu"
			val pokemonDetail =
				PokemonDetail(
					baseExperience = 7913,
					name = name,
					order = 5770,
					sprites =
						Sprites(
							backDefault = null,
							backFemale = null,
							backShiny = null,
							backShinyFemale = null,
							frontDefault = "eget",
							frontFemale = null,
							frontShiny = null,
							frontShinyFemale = null,
							officialArtwork = null,
						),
					stats = listOf(),
					types = listOf(),
					weight = 8999,
				)
			val resultPokemonDetail = Result.success(pokemonDetail)

			// when:
			everySuspend { pokemonRepository.getPokemonDetail(any()) } returns resultPokemonDetail

			val result = getPokemonDetailUseCase(name)

			// then:
			val expected = UiState.Success(pokemonDetail)
			result.test {
				awaitItem() shouldBe UiState.Loading
				awaitItem() shouldBe expected
				awaitComplete()

				verifySuspend(exactly(1)) {
					pokemonRepository.getPokemonDetail(any())
				}
			}
		}

	@Test
	fun shouldNotGetPokemonDetail_whenRequestFails() =
		runTest {
			// given:
			val exception = Exception()
			val resultPokemonDetail = Result.failure<PokemonDetail>(exception)

			// when:
			everySuspend { pokemonRepository.getPokemonDetail(any()) } returns resultPokemonDetail

			val result = getPokemonDetailUseCase("Pikachu")

			// then:
			val expected = UiState.Error(exception)
			result.test {
				awaitItem() shouldBe UiState.Loading
				awaitItem() shouldBe expected
				awaitComplete()

				verifySuspend(exactly(1)) {
					pokemonRepository.getPokemonDetail(any())
				}
			}
		}
}