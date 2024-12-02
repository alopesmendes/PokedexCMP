package org.ailtontech.pokedex.features.location.data.mappers

import org.ailtontech.pokedex.features.location.data.models.LocationListDto
import org.ailtontech.pokedex.features.location.domain.entities.LocationList

internal fun LocationListDto.mapToLocationList(): LocationList =
	LocationList(
		count = count,
		next = next,
		previous = previous,
		results = results.map { it.name },
	)