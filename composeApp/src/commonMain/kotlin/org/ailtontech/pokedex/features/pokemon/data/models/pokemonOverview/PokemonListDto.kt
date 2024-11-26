package org.ailtontech.pokedex.features.pokemon.data.models.pokemonOverview

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.ailtontech.pokedex.core.models.ResultDto

@Serializable
data class PokemonListDto(
	@SerialName("count")
	val count: Int,
	@SerialName("next")
	val next: String?,
	@SerialName("previous")
	val previous: String?,
	@SerialName("results")
	val results: List<ResultDto>,
)