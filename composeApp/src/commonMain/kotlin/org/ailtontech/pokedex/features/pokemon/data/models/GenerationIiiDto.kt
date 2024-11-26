package org.ailtontech.pokedex.features.pokemon.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GenerationIiiDto(
	@SerialName("emerald")
	val emerald: EmeraldDto,
	@SerialName("firered-leafgreen")
	val fireredLeafgreen: FireredLeafgreenDto,
	@SerialName("ruby-sapphire")
	val rubySapphire: RubySapphireDto,
)