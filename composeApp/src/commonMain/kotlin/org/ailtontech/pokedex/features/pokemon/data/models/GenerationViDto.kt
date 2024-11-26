package org.ailtontech.pokedex.features.pokemon.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GenerationViDto(
	@SerialName("omegaruby-alphasapphire")
	val omegarubyAlphasapphire: OmegarubyAlphasapphireDto,
	@SerialName("x-y")
	val xY: XYDto,
)