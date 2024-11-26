package org.ailtontech.pokedex.features.pokemon.data.models.type

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GenerationIvDto(
	@SerialName("diamond-pearl")
	val diamondPearl: DiamondPearlDto,
	@SerialName("heartgold-soulsilver")
	val heartgoldSoulsilver: HeartgoldSoulsilverDto,
	@SerialName("platinum")
	val platinum: PlatinumDto,
)