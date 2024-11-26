package org.ailtontech.pokedex.features.pokemon.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AnimatedDto(
	@SerialName("back_default")
	val backDefault: String?,
	@SerialName("back_female")
	val backFemale: String?,
	@SerialName("back_shiny")
	val backShiny: String?,
	@SerialName("back_shiny_female")
	val backShinyFemale: String?,
	@SerialName("front_default")
	val frontDefault: String,
	@SerialName("front_female")
	val frontFemale: String?,
	@SerialName("front_shiny")
	val frontShiny: String?,
	@SerialName("front_shiny_female")
	val frontShinyFemale: String?,
)