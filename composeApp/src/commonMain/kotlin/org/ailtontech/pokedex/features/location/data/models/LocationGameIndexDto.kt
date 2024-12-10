package org.ailtontech.pokedex.features.location.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.ailtontech.pokedex.core.models.ResultDto

@Serializable
data class LocationGameIndexDto(
	@SerialName("game_index")
	val gameIndex: Int,
	@SerialName("generation")
	val generation: ResultDto,
)