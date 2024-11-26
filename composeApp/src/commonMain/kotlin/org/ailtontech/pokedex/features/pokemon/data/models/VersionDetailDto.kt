package org.ailtontech.pokedex.features.pokemon.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.ailtontech.pokedex.core.models.ResultDto

@Serializable
data class VersionDetailDto(
	@SerialName("rarity")
	val rarity: Int,
	@SerialName("version")
	val version: ResultDto,
)