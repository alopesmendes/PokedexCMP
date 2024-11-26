package org.ailtontech.pokedex.features.pokemon.data.models.type

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BrilliantDiamondAndShiningPearlDto(
	@SerialName("name_icon")
	val nameIcon: String,
)