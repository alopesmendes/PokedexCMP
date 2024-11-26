package org.ailtontech.pokedex.features.pokemon.data.models.type

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.ailtontech.pokedex.core.models.ResultDto

@Serializable
data class DamageRelationsDto(
	@SerialName("double_damage_from")
	val doubleDamageFrom: List<ResultDto>,
	@SerialName("double_damage_to")
	val doubleDamageTo: List<ResultDto>,
	@SerialName("half_damage_from")
	val halfDamageFrom: List<ResultDto>,
	@SerialName("half_damage_to")
	val halfDamageTo: List<ResultDto>,
	@SerialName("no_damage_from")
	val noDamageFrom: List<ResultDto>,
	@SerialName("no_damage_to")
	val noDamageTo: List<ResultDto?>,
)