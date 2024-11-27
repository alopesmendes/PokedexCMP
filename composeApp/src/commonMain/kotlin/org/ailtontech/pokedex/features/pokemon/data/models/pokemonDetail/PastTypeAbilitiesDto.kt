package org.ailtontech.pokedex.features.pokemon.data.models.pokemonDetail

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.ailtontech.pokedex.core.models.ResultDto

@Serializable
data class PastTypeAbilitiesDto(
	@SerialName("generation")
	val generation: ResultDto,
	@SerialName("types")
	val types: List<TypeDto>,
)