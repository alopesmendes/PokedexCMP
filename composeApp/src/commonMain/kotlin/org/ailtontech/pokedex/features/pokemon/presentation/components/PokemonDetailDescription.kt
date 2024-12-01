package org.ailtontech.pokedex.features.pokemon.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import org.ailtontech.pokedex.presentation.components.SectionComponent
import org.ailtontech.pokedex.presentation.components.TextBody
import org.ailtontech.pokedex.presentation.components.TextCaption
import org.ailtontech.pokedex.presentation.components.TextTitle
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import pokedex.composeapp.generated.resources.Res
import pokedex.composeapp.generated.resources.about
import pokedex.composeapp.generated.resources.base_experience
import pokedex.composeapp.generated.resources.base_experience_number
import pokedex.composeapp.generated.resources.order
import pokedex.composeapp.generated.resources.order_number
import pokedex.composeapp.generated.resources.weight
import pokedex.composeapp.generated.resources.weight_kg

@Composable
private fun PokemonDetailDescriptionItem(
	modifier: Modifier = Modifier,
	name: String,
	value: String,
) {
	val colorScheme = MaterialTheme.colorScheme
	Column(
		modifier = modifier,
		horizontalAlignment = Alignment.CenterHorizontally,
	) {
		TextBody(
			text = name,
			color = colorScheme.onTertiaryContainer,
			fontWeight = FontWeight.Bold,
		)
		TextCaption(
			text = value,
		)
	}
}

@Composable
fun PokemonDetailDescription(
	modifier: Modifier = Modifier,
	weight: Int,
	order: Int,
	baseExperience: Int,
) {
	SectionComponent(
		modifier = modifier.fillMaxWidth(),
		title = {
			TextTitle(
				text = stringResource(Res.string.about),
			)
		},
		content = {
			ListItem(
				leadingContent = {
					PokemonDetailDescriptionItem(
						name = stringResource(Res.string.order),
						value = stringResource(Res.string.order_number, order),
					)
				},
				headlineContent = {
					Row(
						modifier = Modifier.fillMaxWidth(),
						verticalAlignment = Alignment.CenterVertically,
						horizontalArrangement = Arrangement.Center,
					) {
						PokemonDetailDescriptionItem(
							name = stringResource(Res.string.weight),
							value = stringResource(Res.string.weight_kg, weight),
						)
					}
				},
				trailingContent = {
					PokemonDetailDescriptionItem(
						name = stringResource(Res.string.base_experience),
						value = stringResource(Res.string.base_experience_number, baseExperience),
					)
				},
			)
		},
	)
}

@Composable
@Preview
private fun PokemonDetailDescriptionPreview() {
	PokemonDetailDescription(
		weight = 100,
		order = 1,
		baseExperience = 100,
	)
}