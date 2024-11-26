package org.ailtontech.pokedex.features.pokemon.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GenerationViiDto(
	@SerialName("icons")
	val icons: IconsDto,
	@SerialName("ultra-sun-ultra-moon")
	val ultraSunUltraMoon: UltraSunUltraMoonDto,
)