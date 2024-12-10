package org.ailtontech.pokedex.features.location.domain.entities

import kotlin.math.max
import kotlin.math.min

data class LocationList(
	val count: Int,
	val limit: Int?,
	val offset: Int?,
	val locations: List<String>,
) {
	operator fun plus(other: LocationList): LocationList {
		return LocationList(
			count = count,
			offset = offset?.let { other.offset?.let { max(offset, it) } },
			limit = limit?.let { other.limit?.let { min(limit, it) } },
			locations = locations + other.locations,
		)
	}
}