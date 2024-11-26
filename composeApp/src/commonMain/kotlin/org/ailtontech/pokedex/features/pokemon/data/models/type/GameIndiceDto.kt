package org.ailtontech.pokedex.features.pokemon.data.models.type

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.ailtontech.pokedex.core.models.ResultDto

@Serializable
data class GameIndiceDto(
	@SerialName("game_index")
	val gameIndex: Int,
	@SerialName("generation")
	val generation: ResultDto,
)