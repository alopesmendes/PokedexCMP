package org.ailtontech.pokedex.features.pokemon.presentation.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffoldRole
import androidx.compose.material3.adaptive.navigation.BackNavigationBehavior
import androidx.compose.material3.adaptive.navigation.rememberListDetailPaneScaffoldNavigator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList
import org.ailtontech.pokedex.features.pokemon.presentation.components.PokemonDetailContent
import org.ailtontech.pokedex.features.pokemon.presentation.components.PokemonOverviewContent
import org.ailtontech.pokedex.features.pokemon.presentation.reducers.PokemonEvent
import org.ailtontech.pokedex.features.pokemon.presentation.viewModels.PokemonViewModel
import org.ailtontech.pokedex.presentation.components.BackHandler
import org.ailtontech.pokedex.presentation.components.ListPaneOverview
import org.koin.compose.viewmodel.koinViewModel

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
@Composable
fun PokemonScreen(
	modifier: Modifier = Modifier,
	pokemonViewModel: PokemonViewModel = koinViewModel(),
) {
	val scaffoldNavigator = rememberListDetailPaneScaffoldNavigator<String>()
	val pokemonState by pokemonViewModel.state.collectAsStateWithLifecycle()
	val backNavigationBehavior = BackNavigationBehavior.PopUntilContentChange

	BackHandler(scaffoldNavigator.canNavigateBack(backNavigationBehavior)) {
		scaffoldNavigator.navigateBack(backNavigationBehavior)
	}

	ListPaneOverview(
		modifier = modifier,
		directive = scaffoldNavigator.scaffoldDirective,
		value = scaffoldNavigator.scaffoldValue,
		listPane = {
			PokemonOverviewContent(
				isLoading = pokemonState.isLoadingPokemonOverview,
				error = pokemonState.errorPokemonOverview,
				pokemons = pokemonState.pokemonList?.pokemons?.toImmutableList() ?: persistentListOf(),
				modifier = Modifier.fillMaxSize(),
				fetchMore = {
					pokemonViewModel.sendEvent(
						PokemonEvent.GetPokemonList(
							limit = pokemonState.pokemonList?.limit,
							offset = pokemonState.pokemonList?.offset,
						),
					)
				},
				hasMore = pokemonState.pokemonList?.limit != null,
				onClickItem = {
					scaffoldNavigator.navigateTo(
						content = it.name,
						pane = ListDetailPaneScaffoldRole.Detail,
					)
				},
			)
		},
		detailPane = {
			val selectedItem = scaffoldNavigator.currentDestination?.content
			LaunchedEffect(selectedItem) {
				selectedItem?.let { item ->
					pokemonViewModel.sendEvent(PokemonEvent.GetPokemonDetail(item))
				}
			}

			PokemonDetailContent(
				modifier = Modifier.fillMaxSize(),
				isLoading = pokemonState.isLoadingPokemonDetail,
				error = pokemonState.errorPokemonDetail,
				pokemonDetail = pokemonState.currentPokemonDetail,
			)
		},
	)
}