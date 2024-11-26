package org.ailtontech.pokedex.features.pokemon.data.models.type

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SpritesDto(
	@SerialName("generation-iii")
	val generationIii: GenerationIiiDto,
	@SerialName("generation-iv")
	val generationIv: GenerationIvDto,
	@SerialName("generation-ix")
	val generationIx: GenerationIxDto,
	@SerialName("generation-v")
	val generationV: GenerationVDto,
	@SerialName("generation-vi")
	val generationVi: GenerationViDto,
	@SerialName("generation-vii")
	val generationVii: GenerationViiDto,
	@SerialName("generation-viii")
	val generationViii: GenerationViiiDto,
)