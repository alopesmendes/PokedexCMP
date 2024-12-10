package org.ailtontech.pokedex.features.location.data.repositories

import dev.mokkery.answering.returns
import dev.mokkery.answering.throws
import dev.mokkery.everySuspend
import dev.mokkery.matcher.any
import dev.mokkery.mock
import dev.mokkery.verify.VerifyMode.Companion.exactly
import dev.mokkery.verifySuspend
import io.kotest.matchers.result.shouldBeFailure
import io.kotest.matchers.result.shouldBeSuccess
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.ailtontech.pokedex.core.models.ResultDto
import org.ailtontech.pokedex.features.location.data.datasources.LocationsRemoteDatasource
import org.ailtontech.pokedex.features.location.data.mappers.mapToLocationDetail
import org.ailtontech.pokedex.features.location.data.mappers.mapToLocationList
import org.ailtontech.pokedex.features.location.data.models.LocationListDto
import org.ailtontech.pokedex.features.location.domain.repositories.LocationRepository
import utils.createLocationDetailDto
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test

@OptIn(ExperimentalCoroutinesApi::class)
class LocationRepositoryImplTest {
	private val dispatcher = Dispatchers.Unconfined
	private lateinit var locationsRemoteDatasource: LocationsRemoteDatasource
	private lateinit var locationRepository: LocationRepository

	@BeforeTest
	fun setUp() {
		Dispatchers.setMain(dispatcher)
		locationsRemoteDatasource = mock()
		locationRepository =
			LocationRepositoryImpl(
				dispatcher = dispatcher,
				locationsRemoteDatasource = locationsRemoteDatasource,
			)
	}

	@AfterTest
	fun teardown() {
		Dispatchers.resetMain()
	}

	@Test
	fun shouldReturnLocationList_whenRequestIsSuccessful() =
		runTest {
			// given:
			val results = (1..10).map { ResultDto(name = "location$it", url = "url$it") }
			val locationListDto =
				LocationListDto(
					count = 10,
					next = "next",
					previous = "previous",
					results = results,
				)

			// when:
			everySuspend { locationsRemoteDatasource.getLocations(any(), any()) } returns locationListDto

			val result = locationRepository.getLocationOverview(10, 0)

			// then:
			verifySuspend(exactly(1)) {
				locationsRemoteDatasource.getLocations(any(), any())
			}

			val expectedLocationList = locationListDto.mapToLocationList()

			result shouldBeSuccess expectedLocationList
		}

	@Test
	fun shouldNotReturnLocationList_whenRequestIsNotSuccessful() =
		runTest {
			// given:
			val exception = Exception()

			// when:
			everySuspend { locationsRemoteDatasource.getLocations(any(), any()) } throws exception
			val result = locationRepository.getLocationOverview(limit = 10, offset = 0)

			// then:
			verifySuspend(exactly(1)) {
				locationsRemoteDatasource.getLocations(any(), any())
			}
			result shouldBeFailure exception
		}

	@Test
	fun shouldReturnLocationDetail_whenRequestIsSuccessful() =
		runTest {
			// given:
			val name = "Pikachu"
			val locationDetailDto = createLocationDetailDto()

			// when:
			everySuspend { locationsRemoteDatasource.getLocationDetail(any()) } returns locationDetailDto

			val result = locationRepository.getLocationDetail(name)

			// then:
			verifySuspend(exactly(1)) {
				locationsRemoteDatasource.getLocationDetail(any())
			}
			val expectedPokemonDetail = locationDetailDto.mapToLocationDetail()
			result shouldBeSuccess expectedPokemonDetail
		}

	@Test
	fun shouldNotReturnLocationDetail_whenRequestIsNotSuccessful() =
		runTest {
			// given:
			val exception = Exception()

			// when:
			everySuspend { locationsRemoteDatasource.getLocationDetail(any()) } throws exception

			val result = locationRepository.getLocationDetail(name = "Pikachu")

			// then:
			verifySuspend(exactly(1)) {
				locationsRemoteDatasource.getLocationDetail(any())
			}
			result shouldBeFailure exception
		}
}