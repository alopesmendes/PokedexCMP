package org.ailtontech.pokedex.features.location.data.mappers

import org.ailtontech.pokedex.core.utils.extractQueryParameterValue
import org.ailtontech.pokedex.features.location.data.models.LocationListDto
import org.ailtontech.pokedex.features.location.domain.entities.LocationList

internal fun LocationListDto.mapToLocationList(): LocationList =
	LocationList(
		count = count,
		offset = next?.let { extractQueryParameterValue("offset", it)?.toInt() },
		limit = next?.let { extractQueryParameterValue("limit", it)?.toInt() },
		locations = results.map { it.name },
	)