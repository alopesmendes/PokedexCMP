package org.ailtontech.pokedex.core.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResultDto(
	@SerialName("name")
	val name: String,
	@SerialName("url")
	val url: String,
)