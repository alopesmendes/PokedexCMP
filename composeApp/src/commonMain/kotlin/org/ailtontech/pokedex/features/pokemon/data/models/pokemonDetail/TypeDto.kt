package org.ailtontech.pokedex.features.pokemon.data.models.pokemonDetail

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.ailtontech.pokedex.core.models.ResultDto

@Serializable
data class TypeDto(
	@SerialName("slot")
	val slot: Int,
	@SerialName("type")
	val type: ResultDto,
)