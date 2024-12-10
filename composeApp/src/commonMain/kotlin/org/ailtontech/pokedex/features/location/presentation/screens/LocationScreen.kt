package org.ailtontech.pokedex.features.location.presentation.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.layout.PaneAdaptedValue
import androidx.compose.material3.adaptive.layout.SupportingPaneScaffoldRole
import androidx.compose.material3.adaptive.navigation.rememberSupportingPaneScaffoldNavigator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList
import org.ailtontech.pokedex.features.location.presentation.components.LocationDetailContent
import org.ailtontech.pokedex.features.location.presentation.components.LocationOverviewContent
import org.ailtontech.pokedex.features.location.presentation.reducers.LocationEvent
import org.ailtontech.pokedex.features.location.presentation.viewModels.LocationViewModel
import org.ailtontech.pokedex.presentation.components.BackHandler
import org.ailtontech.pokedex.presentation.components.SupportingPaneOverview
import org.ailtontech.pokedex.presentation.states.ScaffoldState
import org.koin.compose.viewmodel.koinViewModel

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
@Composable
fun LocationScreen(
	modifier: Modifier = Modifier,
	locationViewModel: LocationViewModel = koinViewModel(),
	scaffoldState: ScaffoldState,
	onScaffoldStateChange: (ScaffoldState) -> Unit,
) {
	val locationState by locationViewModel.state.collectAsStateWithLifecycle()

	val scaffoldNavigator = rememberSupportingPaneScaffoldNavigator<String>()

	BackHandler(scaffoldNavigator.canNavigateBack()) {
		scaffoldNavigator.navigateBack()
	}

	LaunchedEffect(scaffoldNavigator.scaffoldValue) {
		val primary = scaffoldNavigator.scaffoldValue.primary
		val secondary = scaffoldNavigator.scaffoldValue.secondary

		onScaffoldStateChange(
			scaffoldState.copy(
				showTopBar = primary == PaneAdaptedValue.Expanded && secondary == PaneAdaptedValue.Hidden,
				onBack = { scaffoldNavigator.navigateBack() },
				topBarTitle = scaffoldNavigator.currentDestination?.content?.uppercase(),
			),
		)
	}

	SupportingPaneOverview(
		modifier = modifier,
		directive = scaffoldNavigator.scaffoldDirective,
		value = scaffoldNavigator.scaffoldValue,
		supportingPane = {
			LocationOverviewContent(
				modifier = Modifier.fillMaxSize(),
				error = locationState.error,
				isLoading = locationState.isLocationsLoading,
				onClickItem = {
					scaffoldNavigator.navigateTo(SupportingPaneScaffoldRole.Main, content = it)
				},
				locations = locationState.locations?.locations?.toImmutableList() ?: persistentListOf(),
				hasMore = locationState.locations?.limit != null,
				fetchMore = {
					LocationEvent.GetLocations(
						limit = locationState.locations?.limit,
						offset = locationState.locations?.offset,
					)
				},
			)
		},
		mainPane = {
			val selectedItem = scaffoldNavigator.currentDestination?.content
			LaunchedEffect(selectedItem) {
				selectedItem?.let { item ->
					locationViewModel.sendEvent(LocationEvent.GetLocationDetail(item))
				}
			}
			LocationDetailContent(
				modifier = Modifier.fillMaxSize(),
				isLoading = locationState.isLocationDetailLoading,
				error = locationState.error,
				locationDetail = locationState.currentLocationDetail,
			)
		},
	)
}