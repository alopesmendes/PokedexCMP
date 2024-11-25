package org.ailtontech.pokedex.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import org.ailtontech.pokedex.presentation.theme.dimensions
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun <T> InfiniteList(
	modifier: Modifier = Modifier,
	hasMore: Boolean = false,
	contentItems: ImmutableList<T>,
	keyItem: (index: Int, item: T) -> Any,
	fetchMore: suspend () -> Unit,
	itemContent: @Composable (T) -> Unit,
) {
	val state = rememberLazyListState()
	val dimensions = MaterialTheme.dimensions

	LazyColumn(
		modifier = modifier,
		state = state,
		verticalArrangement = Arrangement.spacedBy(dimensions.small),
		contentPadding =
			PaddingValues(
				horizontal = dimensions.small,
			),
	) {
		itemsIndexed(
			items = contentItems,
			key = { index, item -> keyItem(index, item) },
			itemContent = { index, item ->
				itemContent(item)

				LaunchedEffect(index, hasMore) {
					if (index == contentItems.lastIndex && hasMore) {
						fetchMore()
					}
				}
			},
		)

		item {
			if (hasMore) {
				LoadingComponent(
					modifier =
						Modifier.padding(
							vertical = MaterialTheme.dimensions.large,
						),
				)
			}
		}
	}
}

@Composable
@Preview
private fun InfiniteListPreview() {
	InfiniteList(
		contentItems = (1..10).toImmutableList(),
		keyItem = { index, _ -> index },
		fetchMore = {},
		itemContent = { Text(text = it.toString()) },
		hasMore = false,
	)
}