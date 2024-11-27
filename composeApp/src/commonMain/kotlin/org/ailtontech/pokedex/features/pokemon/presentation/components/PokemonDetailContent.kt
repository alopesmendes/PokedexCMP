package org.ailtontech.pokedex.features.pokemon.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.ailtontech.pokedex.features.pokemon.domain.entities.pokemonDetail.PokemonDetail
import org.ailtontech.pokedex.presentation.components.PageContent
import org.ailtontech.pokedex.presentation.components.TextTitle

@Composable
fun PokemonDetailContent(
	modifier: Modifier = Modifier,
	isLoading: Boolean,
	error: Throwable?,
	pokemonDetail: PokemonDetail?,
) {
	PageContent(
		modifier = modifier,
		isLoading = isLoading,
		error = error,
	) {
		pokemonDetail?.let {
			TextTitle(text = it.name)
		}
	}
}