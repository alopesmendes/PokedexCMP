package org.ailtontech.pokedex.presentation.states

import androidx.compose.runtime.Immutable

@Immutable
data class ScaffoldState(
	val selectNavigationItem: NavigationItem = NavigationItem.Home,
)