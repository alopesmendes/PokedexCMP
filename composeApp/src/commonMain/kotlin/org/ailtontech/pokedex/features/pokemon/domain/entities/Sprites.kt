package org.ailtontech.pokedex.features.pokemon.domain.entities

data class Sprites(
	val backDefault: String?,
	val backFemale: String?,
	val backShiny: String?,
	val backShinyFemale: String?,
	val frontDefault: String,
	val frontFemale: String?,
	val frontShiny: String?,
	val frontShinyFemale: String?,
	val officialArtwork: String?,
)