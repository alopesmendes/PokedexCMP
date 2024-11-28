package org.ailtontech.pokedex.features.pokemon.presentation.components

import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.ailtontech.pokedex.features.pokemon.domain.entities.pokemonOverview.PokemonListItem
import org.ailtontech.pokedex.presentation.components.PokedexCard
import org.ailtontech.pokedex.presentation.components.PokedexImage
import org.ailtontech.pokedex.presentation.components.TextTitle

@Composable
fun PokemonListItemComponent(
	modifier: Modifier = Modifier,
	pokemonListItem: PokemonListItem,
	onClick: () -> Unit,
) {
	PokedexCard(
		modifier = modifier,
		onClick = onClick,
		image = {
			PokedexImage(
				url = pokemonListItem.officialArtwork ?: pokemonListItem.sprites.frontDefault,
			)
		},
		headline = {
			TextTitle(
				text = pokemonListItem.name,
			)
		},
		colors =
			CardDefaults.elevatedCardColors(
				containerColor = MaterialTheme.colorScheme.primaryContainer,
			),
	)
}