package org.ailtontech.pokedex.features.pokemon.data.models.pokemonDetail

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DreamWorldDto(
	@SerialName("front_default")
	val frontDefault: String?,
	@SerialName("front_female")
	val frontFemale: String?,
)