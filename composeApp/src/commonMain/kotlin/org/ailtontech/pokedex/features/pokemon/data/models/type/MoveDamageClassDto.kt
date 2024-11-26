package org.ailtontech.pokedex.features.pokemon.data.models.type

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MoveDamageClassDto(
	@SerialName("name")
	val name: String,
	@SerialName("url")
	val url: String,
)