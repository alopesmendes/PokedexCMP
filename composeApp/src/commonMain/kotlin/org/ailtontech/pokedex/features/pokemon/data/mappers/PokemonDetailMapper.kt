package org.ailtontech.pokedex.features.pokemon.data.mappers

import org.ailtontech.pokedex.features.pokemon.data.models.pokemonDetail.PokemonDetailDto
import org.ailtontech.pokedex.features.pokemon.data.models.pokemonDetail.SpritesDto
import org.ailtontech.pokedex.features.pokemon.data.models.pokemonDetail.StatDto
import org.ailtontech.pokedex.features.pokemon.data.models.pokemonDetail.TypeDto
import org.ailtontech.pokedex.features.pokemon.domain.entities.Sprites
import org.ailtontech.pokedex.features.pokemon.domain.entities.Type
import org.ailtontech.pokedex.features.pokemon.domain.entities.pokemonDetail.PokemonDetail
import org.ailtontech.pokedex.features.pokemon.domain.entities.pokemonDetail.Stat
import org.ailtontech.pokedex.features.pokemon.domain.entities.pokemonOverview.PokemonListItem

internal fun StatDto.mapToStat(): Stat =
	Stat(
		name = stat.name,
		effort = effort,
		baseState = baseStat,
	)

internal fun List<StatDto>.mapToStats(): List<Stat> = map { it.mapToStat() }

internal fun TypeDto.mapToType(): Type =
	Type(
		slot = slot,
		name = type.name,
	)

internal fun List<TypeDto>.mapToTypes(): List<Type> = map { it.mapToType() }

internal fun SpritesDto.mapToSprites(): Sprites =
	Sprites(
		backDefault = backDefault,
		backFemale = backFemale,
		backShiny = backShiny,
		backShinyFemale = backShinyFemale,
		frontDefault = frontDefault,
		frontFemale = frontFemale,
		frontShiny = frontShiny,
		frontShinyFemale = frontShinyFemale,
		officialArtwork = other.officialArtwork.frontDefault,
	)

internal fun PokemonDetailDto.mapToPokemonListItem(): PokemonListItem =
	PokemonListItem(
		name = name,
		types = types.mapToTypes(),
		sprites = sprites.mapToSprites(),
		locationAreaEncounters = locationAreaEncounters,
		officialArtwork = sprites.other.officialArtwork.frontDefault,
	)

internal fun PokemonDetailDto.mapToPokemonDetail(): PokemonDetail =
	PokemonDetail(
		name = name,
		order = order,
		baseExperience = baseExperience,
		weight = weight,
		stats = stats.mapToStats(),
		types = types.mapToTypes(),
		sprites = sprites.mapToSprites(),
	)