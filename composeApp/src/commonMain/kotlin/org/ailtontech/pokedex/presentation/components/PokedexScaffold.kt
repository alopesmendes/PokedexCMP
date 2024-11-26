package org.ailtontech.pokedex.presentation.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuite
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffoldDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffoldLayout
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteType
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.window.core.layout.WindowHeightSizeClass.Companion.COMPACT
import androidx.window.core.layout.WindowWidthSizeClass.Companion.EXPANDED
import kotlinx.collections.immutable.ImmutableList
import org.ailtontech.pokedex.presentation.states.NavigationItem
import org.ailtontech.pokedex.presentation.states.ScaffoldState
import org.ailtontech.pokedex.presentation.states.navigationItems
import org.ailtontech.pokedex.presentation.theme.dimensions
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
private fun PokedexNavigationRail(
	modifier: Modifier = Modifier,
	selectedNavigationItem: NavigationItem,
	navigationItems: ImmutableList<NavigationItem>,
	onNavigationItemClick: (NavigationItem) -> Unit,
) {
	val dimensions = MaterialTheme.dimensions
	NavigationRail(modifier = modifier) {
		Spacer(Modifier.weight(dimensions.fullWeight))
		navigationItems.forEach { item ->
			NavigationRailItem(
				selected = item == selectedNavigationItem,
				icon = {
					Icon(
						item.selectedIcon,
						contentDescription = stringResource(item.contentDescription),
					)
				},
				label = { Text(stringResource(item.label)) },
				onClick = { onNavigationItemClick(item) },
			)
		}
		Spacer(Modifier.weight(dimensions.fullWeight))
	}
}

@Composable
private fun PokedexNavigationSuite(
	modifier: Modifier = Modifier,
	layoutType: NavigationSuiteType,
	navigationItems: ImmutableList<NavigationItem>,
	selectedNavigationItem: NavigationItem,
	onNavigationItemClick: (NavigationItem) -> Unit,
) {
	NavigationSuite(
		modifier = modifier,
		layoutType = layoutType,
	) {
		navigationItems.forEach { item ->
			item(
				selected = item == selectedNavigationItem,
				onClick = { onNavigationItemClick(item) },
				icon = {
					Icon(
						item.selectedIcon,
						contentDescription = stringResource(item.contentDescription),
					)
				},
				label = { Text(stringResource(item.label)) },
			)
		}
	}
}

@Composable
fun PokedexScaffold(
	scaffoldState: ScaffoldState,
	onScaffoldStateChange: (ScaffoldState) -> Unit,
	content: @Composable () -> Unit,
) {
	val adaptiveInfo = currentWindowAdaptiveInfo()
	val customNavSuiteType =
		with(adaptiveInfo) {
			val windowSizeClass = adaptiveInfo.windowSizeClass
			when {
				windowSizeClass.windowWidthSizeClass == EXPANDED && windowSizeClass.windowHeightSizeClass != COMPACT -> {
					NavigationSuiteType.NavigationDrawer
				}
				windowSizeClass.windowWidthSizeClass == EXPANDED && windowSizeClass.windowHeightSizeClass == COMPACT -> {
					NavigationSuiteType.NavigationRail
				}
				else -> NavigationSuiteScaffoldDefaults.calculateFromAdaptiveInfo(adaptiveInfo)
			}
		}
	NavigationSuiteScaffoldLayout(
		layoutType = customNavSuiteType,
		navigationSuite = {
			if (customNavSuiteType == NavigationSuiteType.NavigationRail) {
				PokedexNavigationRail(
					navigationItems = navigationItems,
					selectedNavigationItem = scaffoldState.selectNavigationItem,
					onNavigationItemClick = { item ->
						onScaffoldStateChange(
							scaffoldState.copy(
								selectNavigationItem = item,
							),
						)
					},
				)
			} else {
				PokedexNavigationSuite(
					navigationItems = navigationItems,
					selectedNavigationItem = scaffoldState.selectNavigationItem,
					layoutType = customNavSuiteType,
					onNavigationItemClick = { item ->
						onScaffoldStateChange(
							scaffoldState.copy(
								selectNavigationItem = item,
							),
						)
					},
				)
			}
		},
		content = content,
	)
}

@Composable
@Preview
private fun PokedexScaffoldPreview() {
	var scaffoldState by remember { mutableStateOf(ScaffoldState()) }
	PokedexScaffold(
		scaffoldState = scaffoldState,
		onScaffoldStateChange = { scaffoldState = it },
		content = {
			Text("Current navigation item: ${scaffoldState.selectNavigationItem.label}")
		},
	)
}