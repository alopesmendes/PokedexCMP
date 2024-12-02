package org.ailtontech.pokedex.features.location.data.mappers

import org.ailtontech.pokedex.features.location.data.models.LocationDetailDto
import org.ailtontech.pokedex.features.location.data.models.LocationGameIndexDto
import org.ailtontech.pokedex.features.location.domain.entities.LocationDetail
import org.ailtontech.pokedex.features.location.domain.entities.LocationGameIndex

internal fun LocationGameIndexDto.mapToLocationGameIndex(): LocationGameIndex =
	LocationGameIndex(
		gameIndex = gameIndex,
		generation = generation.name,
	)

internal fun LocationDetailDto.mapToLocationDetail(): LocationDetail =
	LocationDetail(
		id = id,
		name = name,
		region = region.name,
		gameIndices = gameIndices.map { it.mapToLocationGameIndex() },
		areas = areas.map { it.name },
	)