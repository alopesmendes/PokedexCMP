package org.ailtontech.pokedex.features.pokemon.data.models.pokemonDetail

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CriesDto(
	@SerialName("latest")
	val latest: String,
	@SerialName("legacy")
	val legacy: String,
)