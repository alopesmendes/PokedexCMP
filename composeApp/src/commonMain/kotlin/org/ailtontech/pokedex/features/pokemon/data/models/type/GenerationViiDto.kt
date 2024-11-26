package org.ailtontech.pokedex.features.pokemon.data.models.type

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GenerationViiDto(
	@SerialName("lets-go-pikachu-lets-go-eevee")
	val letsGoPikachuLetsGoEevee: LetsGoPikachuLetsGoEeveeDto,
	@SerialName("sun-moon")
	val sunMoon: SunMoonDto,
	@SerialName("ultra-sun-ultra-moon")
	val ultraSunUltraMoon: UltraSunUltraMoonDto,
)