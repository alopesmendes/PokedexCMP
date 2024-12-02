package org.ailtontech.pokedex.features.location.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.ailtontech.pokedex.core.models.ResultDto

@Serializable
data class LocationDetailDto(
	@SerialName("id")
	val id: Int,
	@SerialName("name")
	val name: String,
	@SerialName("region")
	val region: ResultDto,
	@SerialName("game_indices")
	val gameIndices: List<LocationGameIndexDto>,
	@SerialName("areas")
	val areas: List<ResultDto>,
)