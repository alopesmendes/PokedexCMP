package org.ailtontech.pokedex.features.location.domain.entities

data class LocationList(
	val count: Int,
	val next: String?,
	val previous: String?,
	val results: List<String>,
)