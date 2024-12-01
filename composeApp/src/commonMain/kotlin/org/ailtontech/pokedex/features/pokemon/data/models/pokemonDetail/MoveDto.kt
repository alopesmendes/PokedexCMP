package org.ailtontech.pokedex.features.pokemon.data.models.pokemonDetail

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.ailtontech.pokedex.core.models.ResultDto

@Serializable
data class MoveDto(
    @SerialName("move")
	val move: ResultDto,
    @SerialName("version_group_details")
	val versionGroupDetails: List<VersionGroupDetailDto>,
)