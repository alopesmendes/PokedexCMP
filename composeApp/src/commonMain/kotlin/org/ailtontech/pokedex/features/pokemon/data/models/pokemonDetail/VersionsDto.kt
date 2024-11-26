package org.ailtontech.pokedex.features.pokemon.data.models.pokemonDetail

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VersionsDto(
    @SerialName("generation-i")
	val generationI: GenerationIDto,
    @SerialName("generation-ii")
	val generationIi: GenerationIiDto,
    @SerialName("generation-iii")
	val generationIii: GenerationIiiDto,
    @SerialName("generation-iv")
	val generationIv: GenerationIvDto,
    @SerialName("generation-v")
	val generationV: GenerationVDto,
    @SerialName("generation-vi")
	val generationVi: GenerationViDto,
    @SerialName("generation-vii")
	val generationVii: GenerationViiDto,
    @SerialName("generation-viii")
	val generationViii: GenerationViiiDto,
)