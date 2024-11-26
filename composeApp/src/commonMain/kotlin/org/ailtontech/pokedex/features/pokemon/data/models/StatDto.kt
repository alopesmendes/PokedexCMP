package org.ailtontech.pokedex.features.pokemon.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.ailtontech.pokedex.core.models.ResultDto

@Serializable
data class StatDto(
	@SerialName("base_stat")
	val baseStat: Int,
	@SerialName("effort")
	val effort: Int,
	@SerialName("stat")
	val stat: ResultDto,
)