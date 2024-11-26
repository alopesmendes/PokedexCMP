package org.ailtontech.pokedex.features.pokemon.data.models.pokemonDetail

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.ailtontech.pokedex.core.models.ResultDto

@Serializable
data class HeldItemDto(
    @SerialName("item")
	val item: ResultDto,
    @SerialName("version_details")
	val versionDetails: List<VersionDetailDto>,
)