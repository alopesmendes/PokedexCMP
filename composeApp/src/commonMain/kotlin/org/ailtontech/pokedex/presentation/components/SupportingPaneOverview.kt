package org.ailtontech.pokedex.presentation.components

import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.layout.AnimatedPane
import androidx.compose.material3.adaptive.layout.AnimatedPaneScope
import androidx.compose.material3.adaptive.layout.PaneScaffoldDirective
import androidx.compose.material3.adaptive.layout.SupportingPaneScaffold
import androidx.compose.material3.adaptive.layout.ThreePaneScaffoldValue
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
@Composable
fun SupportingPaneOverview(
	modifier: Modifier = Modifier,
	directive: PaneScaffoldDirective,
	value: ThreePaneScaffoldValue,
	supportingPane: @Composable (AnimatedPaneScope.() -> Unit),
	mainPane: @Composable (AnimatedPaneScope.() -> Unit),
) {
	SupportingPaneScaffold(
		modifier = modifier,
		directive = directive,
		value = value,
		mainPane = {
			AnimatedPane(
				modifier = Modifier.safeContentPadding(),
				content = mainPane,
			)
		},
		supportingPane = {
			AnimatedPane(
				modifier = Modifier.safeContentPadding(),
				content = supportingPane,
			)
		},
	)
}