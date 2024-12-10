package org.ailtontech.pokedex.features.location.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.ailtontech.pokedex.features.location.domain.entities.LocationDetail
import org.ailtontech.pokedex.presentation.components.PageContent
import org.ailtontech.pokedex.presentation.components.TextDisplay
import org.ailtontech.pokedex.presentation.theme.dimensions

@Composable
fun LocationDetailContent(
	modifier: Modifier,
	isLoading: Boolean,
	error: Throwable?,
	locationDetail: LocationDetail?,
) {
	val dimensions = MaterialTheme.dimensions
	PageContent(
		modifier = modifier,
		isLoading = isLoading,
		error = error,
	) {
		locationDetail?.let {
			Column(modifier = Modifier.fillMaxSize()) {
				Row(
					modifier = Modifier.fillMaxWidth(),
					horizontalArrangement = Arrangement.SpaceAround,
					verticalAlignment = Alignment.CenterVertically,
				) {
					TextDisplay(text = locationDetail.id.toString())
					TextDisplay(text = locationDetail.name)
				}
				TextDisplay(text = locationDetail.region)
				HorizontalDivider()
				Row(modifier = Modifier.fillMaxWidth()) {
					LazyColumn(
						modifier = Modifier.weight(dimensions.fullWeight),
					) {
						item { Text("Areas") }
						items(locationDetail.areas) {
							ListItem(
								leadingContent = {
									Icon(Icons.Filled.LocationOn, contentDescription = null)
								},
								headlineContent = {
									Text(it)
								},
							)
						}
					}

					LazyColumn(
						modifier = Modifier.weight(dimensions.fullWeight),
					) {
						item { Text("Game Index") }
						items(locationDetail.gameIndices) {
							ListItem(
								leadingContent = { Text("#${it.gameIndex}") },
								headlineContent = { Text(it.generation) },
							)
						}
					}
				}
			}
		}
	}
}