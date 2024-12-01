package org.ailtontech.pokedex.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.material3.ChipColors
import androidx.compose.material3.ElevatedSuggestionChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.SuggestionChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlinx.collections.immutable.ImmutableList
import org.ailtontech.pokedex.core.utils.Constants.INTERPOLATE_FACTOR
import org.ailtontech.pokedex.presentation.theme.dimensions
import org.ailtontech.pokedex.presentation.utils.rememberInterpolateColor

@Composable
fun PokedexSuggestionChip(
	modifier: Modifier = Modifier,
	text: String,
	colors: ChipColors = SuggestionChipDefaults.suggestionChipColors(),
) {
	SuggestionChip(
		modifier = modifier,
		label = { Text(text) },
		onClick = {},
		colors = colors,
	)
}

@Composable
fun PokedexElevatedSuggestionChip(
	modifier: Modifier = Modifier,
	text: String,
	colors: ChipColors = SuggestionChipDefaults.elevatedSuggestionChipColors(),
) {
	ElevatedSuggestionChip(
		modifier = modifier,
		label = { Text(text) },
		onClick = {},
		colors = colors,
	)
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun PokedexSuggestionChips(
	modifier: Modifier = Modifier,
	chipItems: ImmutableList<ChipItem>,
) {
	FlowRow(
		modifier = modifier,
		horizontalArrangement = Arrangement.spacedBy(MaterialTheme.dimensions.small),
	) {
		chipItems.forEach { chipItem ->
			val containerColor by rememberInterpolateColor(
				color = chipItem.containerColor,
				factor = INTERPOLATE_FACTOR,
			)
			PokedexSuggestionChip(
				text = chipItem.label,
				colors =
					SuggestionChipDefaults.suggestionChipColors(
						containerColor = containerColor,
					),
			)
		}
	}
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun PokedexElevatedSuggestionChips(
	modifier: Modifier = Modifier,
	chipItems: ImmutableList<ChipItem>,
) {
	FlowRow(
		modifier = modifier,
		horizontalArrangement = Arrangement.spacedBy(MaterialTheme.dimensions.small),
	) {
		chipItems.forEach { chipItem ->
			val containerColor by rememberInterpolateColor(
				color = chipItem.containerColor,
				factor = INTERPOLATE_FACTOR,
			)
			PokedexElevatedSuggestionChip(
				text = chipItem.label,
				colors =
					SuggestionChipDefaults.elevatedSuggestionChipColors(
						containerColor = containerColor,
					),
			)
		}
	}
}

@Immutable
data class ChipItem(
	val label: String,
	val containerColor: Color,
)