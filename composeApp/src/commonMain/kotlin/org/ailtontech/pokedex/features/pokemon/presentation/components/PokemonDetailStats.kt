package org.ailtontech.pokedex.features.pokemon.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import kotlinx.collections.immutable.ImmutableList
import org.ailtontech.pokedex.features.pokemon.domain.entities.pokemonDetail.Stat
import org.ailtontech.pokedex.presentation.components.SectionComponent
import org.ailtontech.pokedex.presentation.components.TextBody
import org.ailtontech.pokedex.presentation.components.TextCaption
import org.ailtontech.pokedex.presentation.components.TextTitle
import org.ailtontech.pokedex.presentation.theme.dimensions
import org.jetbrains.compose.resources.stringResource
import pokedex.composeapp.generated.resources.Res
import pokedex.composeapp.generated.resources.base_stat_number
import pokedex.composeapp.generated.resources.effort_number
import pokedex.composeapp.generated.resources.stat_name_text
import pokedex.composeapp.generated.resources.stats

@Composable
fun PokemonDetailStats(
	modifier: Modifier = Modifier,
	stats: ImmutableList<Stat>,
) {
	SectionComponent(
		modifier = modifier.fillMaxWidth(),
		title = {
			TextTitle(
				text = stringResource(Res.string.stats),
			)
		},
		content = {
			Column(
				modifier = Modifier.fillMaxWidth(),
			) {
				stats.forEachIndexed { index, stat ->
					ListItem(
						modifier = Modifier.fillMaxWidth(),
						leadingContent = {
							TextBody(
								text = stringResource(Res.string.stat_name_text, stat.name),
								color = MaterialTheme.colorScheme.onTertiaryContainer,
								fontWeight = FontWeight.Bold,
							)
						},
						headlineContent = {
							Row(
								modifier =
									Modifier
										.fillMaxWidth()
										.padding(horizontal = MaterialTheme.dimensions.large),
								horizontalArrangement = Arrangement.End,
								verticalAlignment = Alignment.CenterVertically,
							) {
								TextCaption(
									text = stringResource(Res.string.base_stat_number, stat.baseState),
								)
								Spacer(Modifier.size(MaterialTheme.dimensions.small))
								TextCaption(
									text = stringResource(Res.string.effort_number, stat.effort),
								)
							}
						},
						trailingContent = {
							TextBody(
								text = "N°${index + 1}",
							)
						},
					)
				}
			}
		},
	)
}