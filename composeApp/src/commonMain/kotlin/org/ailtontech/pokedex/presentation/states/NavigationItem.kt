package org.ailtontech.pokedex.presentation.states

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationCity
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.collections.immutable.persistentListOf
import org.ailtontech.pokedex.presentation.states.NavigationItem.Home
import org.ailtontech.pokedex.presentation.states.NavigationItem.Location
import org.ailtontech.pokedex.presentation.states.NavigationItem.Settings
import org.jetbrains.compose.resources.StringResource
import pokedex.composeapp.generated.resources.Res
import pokedex.composeapp.generated.resources.confirm
import pokedex.composeapp.generated.resources.home
import pokedex.composeapp.generated.resources.location
import pokedex.composeapp.generated.resources.settings

@Immutable
sealed class NavigationItem(
	val label: StringResource,
	val selectedIcon: ImageVector,
	val contentDescription: StringResource,
) {
	data object Home : NavigationItem(
		label = Res.string.home,
		selectedIcon = Icons.Filled.Home,
		contentDescription = Res.string.confirm,
	)

	data object Location : NavigationItem(
		label = Res.string.location,
		selectedIcon = Icons.Filled.LocationCity,
		contentDescription = Res.string.confirm,
	)

	data object Settings : NavigationItem(
		label = Res.string.settings,
		selectedIcon = Icons.Filled.Settings,
		contentDescription = Res.string.confirm,
	)
}

val navigationItems =
	persistentListOf(
		Home,
		Location,
		Settings,
	)