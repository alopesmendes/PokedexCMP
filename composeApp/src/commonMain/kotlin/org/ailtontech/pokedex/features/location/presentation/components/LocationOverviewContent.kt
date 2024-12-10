package org.ailtontech.pokedex.features.location.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationCity
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kotlinx.collections.immutable.ImmutableList
import org.ailtontech.pokedex.presentation.components.InfiniteList
import org.ailtontech.pokedex.presentation.components.PageContent

@Composable
fun LocationOverviewContent(
	modifier: Modifier,
	isLoading: Boolean,
	error: Throwable?,
	locations: ImmutableList<String>,
	hasMore: Boolean,
	onClickItem: (String) -> Unit,
	fetchMore: () -> Unit,
) {
	PageContent(
		modifier = modifier,
		isLoading = isLoading,
		error = error,
	) {
		InfiniteList(
			modifier = modifier,
			contentItems = locations,
			hasMore = hasMore,
			itemContent = {
				ListItem(
					modifier =
						Modifier.clickable {
							onClickItem(it)
						},
					headlineContent = {
						Text(it)
					},
					leadingContent = {
						Icon(Icons.Filled.LocationCity, contentDescription = null)
					},
				)
			},
			keyItem = { _, pokemonListItem -> pokemonListItem },
			fetchMore = fetchMore,
		)
	}
}