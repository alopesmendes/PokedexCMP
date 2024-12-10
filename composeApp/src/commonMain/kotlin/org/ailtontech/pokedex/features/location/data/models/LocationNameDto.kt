package org.ailtontech.pokedex.features.location.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.ailtontech.pokedex.core.models.ResultDto

@Serializable
data class LocationNameDto(
	@SerialName("name")
	val name: String,
	@SerialName("language")
	val language: ResultDto,
)