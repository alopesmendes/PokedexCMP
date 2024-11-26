package org.ailtontech.pokedex.features.pokemon.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class XYDto(
	@SerialName("front_default")
	val frontDefault: String?,
	@SerialName("front_female")
	val frontFemale: String?,
	@SerialName("front_shiny")
	val frontShiny: String?,
	@SerialName("front_shiny_female")
	val frontShinyFemale: String?,
)