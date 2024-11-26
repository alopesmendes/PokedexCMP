package org.ailtontech.pokedex.features.pokemon.domain.entities.pokemonDetail

data class Move(
	val name: String,
	val versionGroupDetails: List<VersionGroupDetail>,
)