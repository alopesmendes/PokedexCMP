package org.ailtontech.pokedex.features.pokemon.data.models.type

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.ailtontech.pokedex.core.models.ResultDto

@Serializable
data class TypeDetailDto(
	@SerialName("damage_relations")
	val damageRelations: DamageRelationsDto,
	@SerialName("game_indices")
	val gameIndices: List<GameIndiceDto>,
	@SerialName("generation")
	val generation: ResultDto,
	@SerialName("id")
	val id: Int,
	@SerialName("move_damage_class")
	val moveDamageClass: ResultDto,
	@SerialName("moves")
	val moves: List<ResultDto>,
	@SerialName("name")
	val name: String,
	@SerialName("names")
	val names: List<NameDto>,
	@SerialName("past_damage_relations")
	val pastDamageRelations: List<ResultDto?>,
	@SerialName("pokemon")
	val pokemon: List<PokemonDto>,
	@SerialName("sprites")
	val sprites: SpritesDto,
)