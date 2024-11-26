package org.ailtontech.pokedex.features.pokemon.data.models.type

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GenerationVDto(
	@SerialName("black-2-white-2")
	val black2White2: Black2White2Dto,
	@SerialName("black-white")
	val blackWhite: Black2White2Dto,
)