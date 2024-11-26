package org.ailtontech.pokedex.features.pokemon.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.ailtontech.pokedex.core.models.ResultDto

@Serializable
data class PokemonDetailDto(
	@SerialName("abilities")
	val abilities: List<AbilityDto>,
	@SerialName("base_experience")
	val baseExperience: Int,
	@SerialName("cries")
	val cries: CriesDto,
	@SerialName("forms")
	val forms: List<ResultDto>,
	@SerialName("game_indices")
	val gameIndices: List<GameIndiceDto>,
	@SerialName("height")
	val height: Int,
	@SerialName("held_items")
	val heldItems: List<HeldItemDto>,
	@SerialName("id")
	val id: Int,
	@SerialName("is_default")
	val isDefault: Boolean,
	@SerialName("location_area_encounters")
	val locationAreaEncounters: String,
	@SerialName("moves")
	val moves: List<MoveDto>,
	@SerialName("name")
	val name: String,
	@SerialName("order")
	val order: Int,
	@SerialName("past_abilities")
	val pastAbilities: List<String?>,
	@SerialName("past_types")
	val pastTypes: List<String?>,
	@SerialName("species")
	val species: ResultDto,
	@SerialName("sprites")
	val sprites: SpritesDto,
	@SerialName("stats")
	val stats: List<StatDto>,
	@SerialName("types")
	val types: List<TypeDto>,
	@SerialName("weight")
	val weight: Int,
)