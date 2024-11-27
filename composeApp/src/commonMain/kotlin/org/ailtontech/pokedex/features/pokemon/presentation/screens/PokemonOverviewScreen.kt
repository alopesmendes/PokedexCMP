package org.ailtontech.pokedex.features.pokemon.presentation.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList
import org.ailtontech.pokedex.features.pokemon.presentation.components.PokemonListItemComponent
import org.ailtontech.pokedex.features.pokemon.presentation.viewModels.PokemonViewModel
import org.ailtontech.pokedex.presentation.components.InfiniteList

@Composable
fun PokemonOverviewScreen(
	modifier: Modifier = Modifier,
	pokemonViewModel: PokemonViewModel,
) {
	val pokemonState by pokemonViewModel.state.collectAsStateWithLifecycle()

	InfiniteList(
		modifier = modifier,
		contentItems = pokemonState.pokemonList?.pokemons?.toImmutableList() ?: persistentListOf(),
		hasMore = false,
		itemContent = {
			PokemonListItemComponent(
				pokemonListItem = it,
				onClick = {},
			)
		},
		keyItem = { _, pokemonListItem -> pokemonListItem.name },
		fetchMore = {},
	)
}