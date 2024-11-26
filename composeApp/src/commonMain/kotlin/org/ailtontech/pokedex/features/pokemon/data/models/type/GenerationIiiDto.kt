package org.ailtontech.pokedex.features.pokemon.data.models.type

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GenerationIiiDto(
	@SerialName("colosseum")
	val colosseum: ColosseumDto,
	@SerialName("emerald")
	val emerald: EmeraldDto,
	@SerialName("firered-leafgreen")
	val fireredLeafgreen: FireredLeafgreenDto,
	@SerialName("ruby-saphire")
	val rubySaphire: RubySaphireDto,
	@SerialName("xd")
	val xd: XdDto,
)