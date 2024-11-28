package org.ailtontech.pokedex.presentation.components

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffoldRole
import androidx.compose.material3.adaptive.navigation.rememberListDetailPaneScaffoldNavigator
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test

@OptIn(ExperimentalTestApi::class)
class ListPaneOverviewTest {
	@OptIn(ExperimentalMaterial3AdaptiveApi::class)
	@Test
	fun shouldOnlyDisplayListPane_whenOnlyListPaneIsExpanded() =
		runComposeUiTest {
			// given:
			val listPaneTestTag = "listPaneTag"
			val detailPaneTestTag = "detailPaneTag"

			// when:
			setContent {
				val scaffoldNavigator = rememberListDetailPaneScaffoldNavigator<String>()

				ListPaneOverview(
					detailPane = {
						scaffoldNavigator.currentDestination?.let { destination ->
							destination.content?.let { content ->
								Text(content, modifier = Modifier.testTag(detailPaneTestTag))
							}
						}
					},
					listPane = {
						Button(
							modifier = Modifier.testTag(listPaneTestTag),
							onClick = {
								scaffoldNavigator.navigateTo(
									content = "detail",
									pane = ListDetailPaneScaffoldRole.Detail,
								)
							},
						) {
							Text("Navigate to detail")
						}
					},
					value = scaffoldNavigator.scaffoldValue,
					directive = scaffoldNavigator.scaffoldDirective,
				)
			}

			// then:
			onNodeWithTag(listPaneTestTag).assertExists()
			onNodeWithTag(detailPaneTestTag).assertDoesNotExist()
		}

	@OptIn(ExperimentalMaterial3AdaptiveApi::class)
	@Test
	fun shouldDisplayDetailPane_whenListPaneActionNavigatesToDetailPane() =
		runComposeUiTest {
			// given:
			val listPaneTestTag = "listPaneTag"
			val detailPaneTestTag = "detailPaneTag"

			// when:
			setContent {
				val scaffoldNavigator = rememberListDetailPaneScaffoldNavigator<String>()

				ListPaneOverview(
					detailPane = {
						scaffoldNavigator.currentDestination?.let { destination ->
							destination.content?.let { content ->
								Text(content, modifier = Modifier.testTag(detailPaneTestTag))
							}
						}
					},
					listPane = {
						Button(
							modifier = Modifier.testTag(listPaneTestTag),
							onClick = {
								scaffoldNavigator.navigateTo(
									content = "detail",
									pane = ListDetailPaneScaffoldRole.Detail,
								)
							},
						) {
							Text("Navigate to detail")
						}
					},
					value = scaffoldNavigator.scaffoldValue,
					directive = scaffoldNavigator.scaffoldDirective,
				)
			}

			// then:
			onNodeWithTag(listPaneTestTag).performClick()
			onNodeWithTag(detailPaneTestTag).assertExists()
		}
}