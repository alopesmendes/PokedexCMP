package org.ailtontech.pokedex.features.pokemon.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kotlinx.collections.immutable.toImmutableList
import org.ailtontech.pokedex.features.pokemon.domain.entities.pokemonDetail.PokemonDetail
import org.ailtontech.pokedex.presentation.components.PageContent
import org.ailtontech.pokedex.presentation.components.PokedexElevatedSuggestionChips
import org.ailtontech.pokedex.presentation.components.TextDisplay
import org.ailtontech.pokedex.presentation.theme.dimensions
import org.ailtontech.pokedex.presentation.utils.mapToChipItem

@Composable
fun PokemonDetailContent(
	modifier: Modifier = Modifier,
	isLoading: Boolean,
	error: Throwable?,
	pokemonDetail: PokemonDetail?,
) {
	val dimensions = MaterialTheme.dimensions
	PageContent(
		modifier = modifier,
		isLoading = isLoading,
		error = error,
	) {
		pokemonDetail?.let { detail ->
			Column(
				modifier =
					Modifier
						.fillMaxSize()
						.verticalScroll(rememberScrollState()),
				verticalArrangement = Arrangement.SpaceAround,
			) {
				TextDisplay(
					modifier = Modifier.fillMaxWidth(),
					text = detail.name,
				)

				PokedexElevatedSuggestionChips(
					modifier =
						Modifier
							.fillMaxWidth()
							.padding(
								vertical = dimensions.small,
							),
					chipItems = detail.types.map { it.mapToChipItem() }.toImmutableList(),
				)

				detail.sprites.officialArtwork?.let { officialArtwork ->
					PokemonDetailImage(
						modifier = Modifier.fillMaxWidth(),
						url = officialArtwork,
					)
				}

				PokemonDetailDescription(
					modifier =
						Modifier
							.fillMaxWidth()
							.padding(
								horizontal = dimensions.medium,
								vertical = dimensions.large,
							),
					weight = detail.weight,
					order = detail.order,
					baseExperience = detail.baseExperience,
				)

				PokemonDetailStats(
					modifier =
						Modifier
							.fillMaxWidth()
							.padding(
								horizontal = dimensions.medium,
								vertical = dimensions.large,
							),
					stats = pokemonDetail.stats.toImmutableList(),
				)
			}
		}
	}
}