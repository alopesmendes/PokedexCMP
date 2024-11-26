package org.ailtontech.pokedex.features.pokemon.data.models.type

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GenerationViiiDto(
	@SerialName("brilliant-diamond-and-shining-pearl")
	val brilliantDiamondAndShiningPearl: BrilliantDiamondAndShiningPearlDto,
	@SerialName("legends-arceus")
	val legendsArceus: LegendsArceusDto,
	@SerialName("sword-shield")
	val swordShield: SwordShieldDto,
)