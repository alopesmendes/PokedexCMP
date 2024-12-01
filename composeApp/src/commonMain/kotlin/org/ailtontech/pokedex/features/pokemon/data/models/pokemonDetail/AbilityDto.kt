package org.ailtontech.pokedex.features.pokemon.data.models.pokemonDetail

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.ailtontech.pokedex.core.models.ResultDto

@Serializable
data class AbilityDto(
	@SerialName("ability")
	val ability: ResultDto,
	@SerialName("is_hidden")
	val isHidden: Boolean,
	@SerialName("slot")
	val slot: Int,
)