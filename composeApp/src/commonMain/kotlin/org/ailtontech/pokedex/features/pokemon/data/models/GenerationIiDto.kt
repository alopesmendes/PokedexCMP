package org.ailtontech.pokedex.features.pokemon.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GenerationIiDto(
	@SerialName("crystal")
	val crystal: CrystalDto,
	@SerialName("gold")
	val gold: GoldDto,
	@SerialName("silver")
	val silver: SilverDto,
)