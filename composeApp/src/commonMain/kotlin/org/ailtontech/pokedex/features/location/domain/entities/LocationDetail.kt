package org.ailtontech.pokedex.features.location.domain.entities

data class LocationDetail(
	val id: Int,
	val name: String,
	val region: String,
	val gameIndices: List<LocationGameIndex>,
	val areas: List<String>,
)