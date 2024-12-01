package org.ailtontech.pokedex.features.pokemon.data.models.pokemonDetail

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CrystalDto(
	@SerialName("back_default")
	val backDefault: String?,
	@SerialName("back_shiny")
	val backShiny: String?,
	@SerialName("back_shiny_transparent")
	val backShinyTransparent: String?,
	@SerialName("back_transparent")
	val backTransparent: String?,
	@SerialName("front_default")
	val frontDefault: String?,
	@SerialName("front_shiny")
	val frontShiny: String?,
	@SerialName("front_shiny_transparent")
	val frontShinyTransparent: String?,
	@SerialName("front_transparent")
	val frontTransparent: String?,
)