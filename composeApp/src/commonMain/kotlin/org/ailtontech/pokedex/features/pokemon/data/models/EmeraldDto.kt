package org.ailtontech.pokedex.features.pokemon.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EmeraldDto(
	@SerialName("front_default")
	val frontDefault: String?,
	@SerialName("front_shiny")
	val frontShiny: String?,
)