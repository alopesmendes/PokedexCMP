package org.ailtontech.pokedex.features.pokemon.data.models.pokemonDetail

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GenerationIDto(
    @SerialName("red-blue")
	val redBlue: RedBlueDto,
    @SerialName("yellow")
	val yellow: YellowDto,
)