package org.ailtontech.pokedex.presentation.components

import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.layout.AnimatedPane
import androidx.compose.material3.adaptive.layout.AnimatedPaneScope
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffold
import androidx.compose.material3.adaptive.layout.PaneScaffoldDirective
import androidx.compose.material3.adaptive.layout.ThreePaneScaffoldValue
import androidx.compose.material3.adaptive.navigation.rememberListDetailPaneScaffoldNavigator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
@Composable
fun ListPaneOverview(
	modifier: Modifier = Modifier,
	directive: PaneScaffoldDirective,
	value: ThreePaneScaffoldValue,
	listPane: @Composable (AnimatedPaneScope.() -> Unit),
	detailPane: @Composable (AnimatedPaneScope.() -> Unit),
) {
	ListDetailPaneScaffold(
		modifier = modifier,
		listPane = {
			AnimatedPane(
				content = listPane,
			)
		},
		detailPane = {
			AnimatedPane(
				content = detailPane,
			)
		},
		value = value,
		directive = directive,
	)
}

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
@Composable
@Preview
private fun ListPaneOverviewPreview() {
	val scaffoldNavigator = rememberListDetailPaneScaffoldNavigator()
	ListPaneOverview(
		directive = scaffoldNavigator.scaffoldDirective,
		value = scaffoldNavigator.scaffoldValue,
		listPane = {},
		detailPane = {},
	)
}