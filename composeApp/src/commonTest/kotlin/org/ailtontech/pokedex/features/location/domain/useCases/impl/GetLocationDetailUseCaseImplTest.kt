package org.ailtontech.pokedex.features.location.domain.useCases.impl

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
import org.ailtontech.pokedex.features.location.data.mappers.mapToLocationDetail
import org.ailtontech.pokedex.features.location.domain.entities.LocationDetail
import org.ailtontech.pokedex.features.location.domain.repositories.LocationRepository
import org.ailtontech.pokedex.features.location.domain.useCases.GetLocationDetailUseCase
import utils.createLocationDetailDto
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test

@OptIn(ExperimentalCoroutinesApi::class)
class GetLocationDetailUseCaseImplTest {
	private val dispatcher = Dispatchers.Unconfined
	private lateinit var locationRepository: LocationRepository
	private lateinit var getLocationDetailUseCase: GetLocationDetailUseCase

	@BeforeTest
	fun setUp() {
		Dispatchers.setMain(dispatcher)
		locationRepository = mock()
		getLocationDetailUseCase = GetLocationDetailUseCaseImpl(locationRepository)
	}

	@AfterTest
	fun teardown() {
		Dispatchers.resetMain()
	}

	@Test
	fun shouldGetLocationDetail_whenRequestIsSuccessful() =
		runTest {
			// given:
			val name = "Earth"
			val locationDetail =
				createLocationDetailDto(
					name = name,
				).mapToLocationDetail()
			val locationDetailResult = Result.success(locationDetail)

			// when:
			everySuspend { locationRepository.getLocationDetail(any()) } returns locationDetailResult

			val result = getLocationDetailUseCase(name)

			// then:
			val expected = UiState.Success(locationDetail)
			result.test {
				awaitItem() shouldBe UiState.Loading
				awaitItem() shouldBe expected
				awaitComplete()

				verifySuspend(exactly(1)) {
					locationRepository.getLocationDetail(any())
				}
			}
		}

	@Test
	fun shouldNotGetLocationDetail_whenRequestFails() =
		runTest {
			// given:
			val exception = Exception()
			val locationDetailResult = Result.failure<LocationDetail>(exception)

			// when:
			everySuspend { locationRepository.getLocationDetail(any()) } returns locationDetailResult

			val result = getLocationDetailUseCase("Earth")

			// then:
			val expected = UiState.Error(exception)
			result.test {
				awaitItem() shouldBe UiState.Loading
				awaitItem() shouldBe expected
				awaitComplete()

				verifySuspend(exactly(1)) {
					locationRepository.getLocationDetail(any())
				}
			}
		}
}