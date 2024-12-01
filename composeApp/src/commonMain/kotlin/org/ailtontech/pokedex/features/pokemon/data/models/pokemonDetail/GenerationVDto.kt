package org.ailtontech.pokedex.features.pokemon.data.models.pokemonDetail

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GenerationVDto(
    @SerialName("black-white")
	val blackWhite: BlackWhiteDto,
)