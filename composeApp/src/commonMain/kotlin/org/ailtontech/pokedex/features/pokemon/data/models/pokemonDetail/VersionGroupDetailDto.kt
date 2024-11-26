package org.ailtontech.pokedex.features.pokemon.data.models.pokemonDetail

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.ailtontech.pokedex.core.models.ResultDto

@Serializable
data class VersionGroupDetailDto(
	@SerialName("level_learned_at")
	val levelLearnedAt: Int,
	@SerialName("move_learn_method")
	val moveLearnMethod: ResultDto,
	@SerialName("version_group")
	val versionGroup: ResultDto,
)