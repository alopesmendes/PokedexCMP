package org.ailtontech.pokedex.features.pokemon.data.models.type

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.ailtontech.pokedex.core.models.ResultDto

@Serializable
data class PokemonDto(
	@SerialName("pokemon")
	val pokemon: ResultDto,
	@SerialName("slot")
	val slot: Int,
)