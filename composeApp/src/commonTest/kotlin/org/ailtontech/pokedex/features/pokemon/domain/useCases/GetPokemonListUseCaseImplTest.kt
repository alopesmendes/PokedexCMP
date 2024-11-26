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
import org.ailtontech.pokedex.features.pokemon.domain.entities.pokemonOverview.PokemonList
import org.ailtontech.pokedex.features.pokemon.domain.repositories.PokemonRepository
import org.ailtontech.pokedex.features.pokemon.domain.useCases.impl.GetPokemonListUseCaseImpl
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test

@OptIn(ExperimentalCoroutinesApi::class)
class GetPokemonListUseCaseImplTest {
	private val dispatcher = Dispatchers.Unconfined
	private lateinit var pokemonRepository: PokemonRepository
	private lateinit var getPokemonListUseCase: GetPokemonListUseCase

	@BeforeTest
	fun setUp() {
		Dispatchers.setMain(dispatcher)
		pokemonRepository = mock()
		getPokemonListUseCase = GetPokemonListUseCaseImpl(pokemonRepository)
	}

	@AfterTest
	fun teardown() {
		Dispatchers.resetMain()
	}

	@Test
	fun shouldGetPokemonList_whenRequestIsSuccessful() =
		runTest {
			// given:
			val pokemonList =
				PokemonList(
					pokemons = emptyList(),
					count = 0,
					limit = null,
					offset = null,
				)
			val resultPokemonList = Result.success(pokemonList)

			// when:
			everySuspend { pokemonRepository.getPokemonOverview(any(), any()) } returns resultPokemonList

			val result = getPokemonListUseCase(limit = null, offset = null)

			// then:
			val expected = UiState.Success(pokemonList)
			result.test {
				awaitItem() shouldBe UiState.Loading
				awaitItem() shouldBe expected
				awaitComplete()

				verifySuspend(exactly(1)) {
					pokemonRepository.getPokemonOverview(any(), any())
				}
			}
		}

	@Test
	fun shouldNotGetPokemonList_whenRequestFails() =
		runTest {
			// given:
			val exception = Exception()
			val resultPokemonList = Result.failure<PokemonList>(exception)

			// when:
			everySuspend { pokemonRepository.getPokemonOverview(any(), any()) } returns resultPokemonList

			val result = getPokemonListUseCase(limit = null, offset = null)

			// then:
			val expected = UiState.Error(exception)
			result.test {
				awaitItem() shouldBe UiState.Loading
				awaitItem() shouldBe expected
				awaitComplete()

				verifySuspend(exactly(1)) {
					pokemonRepository.getPokemonOverview(any(), any())
				}
			}
		}
}