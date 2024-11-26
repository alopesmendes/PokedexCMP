package org.ailtontech.pokedex.features.pokemon.data.models.type

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.ailtontech.pokedex.core.models.ResultDto

@Serializable
data class NameDto(
	@SerialName("language")
	val language: ResultDto,
	@SerialName("name")
	val name: String,
)