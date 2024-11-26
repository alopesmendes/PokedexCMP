package org.ailtontech.pokedex.features.pokemon.data.models.type

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GenerationViDto(
	@SerialName("omega-ruby-alpha-sapphire")
	val omegaRubyAlphaSapphire: OmegaRubyAlphaSapphireDto,
	@SerialName("x-y")
	val xY: XYDto,
)