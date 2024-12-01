package org.ailtontech.pokedex.features.pokemon.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kotlinx.collections.immutable.ImmutableList
import org.ailtontech.pokedex.features.pokemon.domain.entities.pokemonOverview.PokemonListItem
import org.ailtontech.pokedex.presentation.components.InfiniteList
import org.ailtontech.pokedex.presentation.components.PageContent

@Composable
fun PokemonOverviewContent(
	modifier: Modifier = Modifier,
	isLoading: Boolean,
	error: Throwable?,
	pokemons: ImmutableList<PokemonListItem>,
	hasMore: Boolean,
	onClickItem: (PokemonListItem) -> Unit,
	fetchMore: () -> Unit,
) {
	PageContent(
		modifier = modifier,
		isLoading = isLoading,
		error = error,
	) {
		InfiniteList(
			modifier = modifier,
			contentItems = pokemons,
			hasMore = hasMore,
			itemContent = {
				PokemonListItemComponent(
					pokemonListItem = it,
					onClick = {
						onClickItem(it)
					},
				)
			},
			keyItem = { _, pokemonListItem -> pokemonListItem.name },
			fetchMore = fetchMore,
		)
	}
}