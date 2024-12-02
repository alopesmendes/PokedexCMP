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
import org.ailtontech.pokedex.features.location.domain.entities.LocationList
import org.ailtontech.pokedex.features.location.domain.repositories.LocationRepository
import org.ailtontech.pokedex.features.location.domain.useCases.GetLocationsOverviewUseCase
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test

@OptIn(ExperimentalCoroutinesApi::class)
class GetLocationsOverviewUseCaseImplTest {
	private val dispatcher = Dispatchers.Unconfined
	private lateinit var locationRepository: LocationRepository
	private lateinit var getLocationsOverviewUseCase: GetLocationsOverviewUseCase

	@BeforeTest
	fun setUp() {
		Dispatchers.setMain(dispatcher)
		locationRepository = mock()
		getLocationsOverviewUseCase = GetLocationsOverviewUseCaseImpl(locationRepository)
	}

	@AfterTest
	fun teardown() {
		Dispatchers.resetMain()
	}

	@Test
	fun shouldGetLocationList_whenRequestIsSuccessful() =
		runTest {
			// given:
			val locationList =
				LocationList(
					count = 10,
					results = (1..10).map { "name$it" },
					next = null,
					previous = null,
				)
			val locationListResult = Result.success(locationList)

			// when:
			everySuspend { locationRepository.getLocationOverview(any(), any()) } returns locationListResult

			val result = getLocationsOverviewUseCase(limit = null, offset = null)

			// then:
			val expected = UiState.Success(locationList)
			result.test {
				awaitItem() shouldBe UiState.Loading
				awaitItem() shouldBe expected
				awaitComplete()

				verifySuspend(exactly(1)) {
					locationRepository.getLocationOverview(any(), any())
				}
			}
		}

	@Test
	fun shouldNotGetLocationList_whenRequestFails() =
		runTest {
			// given:
			val exception = Exception()
			val locationListResult = Result.failure<LocationList>(exception)

			// when:
			everySuspend { locationRepository.getLocationOverview(any(), any()) } returns locationListResult

			val result = getLocationsOverviewUseCase(limit = null, offset = null)

			// then:
			val expected = UiState.Error(exception)
			result.test {
				awaitItem() shouldBe UiState.Loading
				awaitItem() shouldBe expected
				awaitComplete()

				verifySuspend(exactly(1)) {
					locationRepository.getLocationOverview(any(), any())
				}
			}
		}
}