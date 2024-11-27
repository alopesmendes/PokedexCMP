package org.ailtontech.pokedex.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.window.core.layout.WindowWidthSizeClass.Companion.EXPANDED
import org.ailtontech.pokedex.presentation.theme.LocalWindowSizeClass
import org.ailtontech.pokedex.presentation.theme.dimensions
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
private fun ColumnCard(
	modifier: Modifier = Modifier,
	colors: CardColors = CardDefaults.elevatedCardColors(),
	elevation: CardElevation = CardDefaults.elevatedCardElevation(),
	image: (@Composable (Modifier) -> Unit)? = null,
	headline: (@Composable () -> Unit)? = null,
	subhead: (@Composable () -> Unit)? = null,
	supportingText: (@Composable () -> Unit)? = null,
	actions: (@Composable () -> Unit)? = null,
	onClick: () -> Unit,
) {
	val dimensions = MaterialTheme.dimensions
	ElevatedCard(
		modifier = modifier,
		onClick = onClick,
		content = {
			Row(
				modifier =
					Modifier
						.fillMaxWidth()
						.height(IntrinsicSize.Min),
			) {
				image?.let {
					Box(
						modifier =
							Modifier
								.weight(dimensions.halfWeight)
								.fillMaxHeight()
								.padding(
									start = dimensions.small,
									end = dimensions.medium,
									top = dimensions.medium,
									bottom = dimensions.medium,
								)
								.clip(CardDefaults.shape),
					) {
						it(Modifier.wrapContentSize(Alignment.Center))
					}
				}

				Column(
					modifier =
						Modifier
							.weight(dimensions.fullWeight)
							.fillMaxSize(),
					verticalArrangement = Arrangement.Center,
				) {
					headline?.invoke()
					subhead?.invoke()
					supportingText?.invoke()
					actions?.invoke()
				}
			}
		},
		colors = colors,
		elevation = elevation,
	)
}

@Composable
private fun RowCard(
	modifier: Modifier = Modifier,
	colors: CardColors = CardDefaults.elevatedCardColors(),
	elevation: CardElevation = CardDefaults.elevatedCardElevation(),
	image: (@Composable (Modifier) -> Unit)? = null,
	headline: (@Composable () -> Unit)? = null,
	subhead: (@Composable () -> Unit)? = null,
	supportingText: (@Composable () -> Unit)? = null,
	actions: (@Composable () -> Unit)? = null,
	onClick: () -> Unit,
) {
	val dimensions = MaterialTheme.dimensions
	ElevatedCard(
		modifier = modifier,
		onClick = onClick,
		content = {
			image?.let {
				Box(
					modifier =
						Modifier
							.clip(CardDefaults.shape),
					contentAlignment = Alignment.Center,
				) {
					it(Modifier.wrapContentSize(Alignment.Center))
				}
			}

			Column(
				modifier =
					Modifier
						.wrapContentWidth()
						.padding(dimensions.cardPadding),
			) {
				headline?.invoke()
				subhead?.invoke()
				supportingText?.invoke()
				actions?.invoke()
			}
		},
		colors = colors,
		elevation = elevation,
	)
}

@Composable
fun PokedexCard(
	modifier: Modifier = Modifier,
	colors: CardColors = CardDefaults.elevatedCardColors(),
	elevation: CardElevation = CardDefaults.elevatedCardElevation(),
	image: (@Composable (Modifier) -> Unit)? = null,
	headline: (@Composable () -> Unit)? = null,
	subhead: (@Composable () -> Unit)? = null,
	supportingText: (@Composable () -> Unit)? = null,
	actions: (@Composable () -> Unit)? = null,
	onClick: () -> Unit,
) {
	val windowSizeClass = LocalWindowSizeClass.current
	when (windowSizeClass.windowWidthSizeClass) {
		EXPANDED -> {
			ColumnCard(
				modifier = modifier,
				colors = colors,
				elevation = elevation,
				image = image,
				headline = headline,
				subhead = subhead,
				supportingText = supportingText,
				actions = actions,
				onClick = onClick,
			)
		}

		else -> {
			RowCard(
				modifier = modifier,
				colors = colors,
				elevation = elevation,
				image = image,
				headline = headline,
				subhead = subhead,
				supportingText = supportingText,
				actions = actions,
				onClick = onClick,
			)
		}
	}
}

@Composable
@Preview
private fun PokedexCardPreview() {
	PokedexCard(
		onClick = {},
		image = { },
		headline = {
			Text("here is a headline")
		},
		subhead = {
			Text("here is a subhead")
		},
		supportingText = {
			Text("here is a supporting text")
		},
		actions = { },
	)
}

@Composable
@Preview
private fun CompactCardPreview() {
	ColumnCard(
		onClick = {},
		image = { },
		headline = {
			Text("here is a headline")
		},
		subhead = {
			Text("here is a subhead")
		},
		supportingText = {
			Text("here is a supporting text")
		},
		actions = { },
	)
}

@Composable
@Preview
private fun ExpandedCardPreview() {
	RowCard(
		onClick = {},
		image = { },
		headline = {
			Text("here is a headline")
		},
		subhead = {
			Text("here is a subhead")
		},
		supportingText = {
			Text("here is a supporting text")
		},
		actions = { },
	)
}