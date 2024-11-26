package utils

import org.ailtontech.pokedex.core.models.ResultDto
import org.ailtontech.pokedex.core.utils.LongMethodAllowed
import org.ailtontech.pokedex.features.pokemon.data.models.pokemonDetail.AnimatedDto
import org.ailtontech.pokedex.features.pokemon.data.models.pokemonDetail.BlackWhiteDto
import org.ailtontech.pokedex.features.pokemon.data.models.pokemonDetail.CriesDto
import org.ailtontech.pokedex.features.pokemon.data.models.pokemonDetail.CrystalDto
import org.ailtontech.pokedex.features.pokemon.data.models.pokemonDetail.DiamondPearlDto
import org.ailtontech.pokedex.features.pokemon.data.models.pokemonDetail.DreamWorldDto
import org.ailtontech.pokedex.features.pokemon.data.models.pokemonDetail.EmeraldDto
import org.ailtontech.pokedex.features.pokemon.data.models.pokemonDetail.FireredLeafgreenDto
import org.ailtontech.pokedex.features.pokemon.data.models.pokemonDetail.GenerationIDto
import org.ailtontech.pokedex.features.pokemon.data.models.pokemonDetail.GenerationIiDto
import org.ailtontech.pokedex.features.pokemon.data.models.pokemonDetail.GenerationIiiDto
import org.ailtontech.pokedex.features.pokemon.data.models.pokemonDetail.GenerationIvDto
import org.ailtontech.pokedex.features.pokemon.data.models.pokemonDetail.GenerationVDto
import org.ailtontech.pokedex.features.pokemon.data.models.pokemonDetail.GenerationViDto
import org.ailtontech.pokedex.features.pokemon.data.models.pokemonDetail.GenerationViiDto
import org.ailtontech.pokedex.features.pokemon.data.models.pokemonDetail.GenerationViiiDto
import org.ailtontech.pokedex.features.pokemon.data.models.pokemonDetail.GoldDto
import org.ailtontech.pokedex.features.pokemon.data.models.pokemonDetail.HeartgoldSoulsilverDto
import org.ailtontech.pokedex.features.pokemon.data.models.pokemonDetail.HomeDto
import org.ailtontech.pokedex.features.pokemon.data.models.pokemonDetail.IconsDto
import org.ailtontech.pokedex.features.pokemon.data.models.pokemonDetail.OfficialArtworkDto
import org.ailtontech.pokedex.features.pokemon.data.models.pokemonDetail.OmegarubyAlphasapphireDto
import org.ailtontech.pokedex.features.pokemon.data.models.pokemonDetail.OtherDto
import org.ailtontech.pokedex.features.pokemon.data.models.pokemonDetail.PlatinumDto
import org.ailtontech.pokedex.features.pokemon.data.models.pokemonDetail.PokemonDetailDto
import org.ailtontech.pokedex.features.pokemon.data.models.pokemonDetail.RedBlueDto
import org.ailtontech.pokedex.features.pokemon.data.models.pokemonDetail.RubySapphireDto
import org.ailtontech.pokedex.features.pokemon.data.models.pokemonDetail.ShowdownDto
import org.ailtontech.pokedex.features.pokemon.data.models.pokemonDetail.SilverDto
import org.ailtontech.pokedex.features.pokemon.data.models.pokemonDetail.SpritesDto
import org.ailtontech.pokedex.features.pokemon.data.models.pokemonDetail.UltraSunUltraMoonDto
import org.ailtontech.pokedex.features.pokemon.data.models.pokemonDetail.VersionsDto
import org.ailtontech.pokedex.features.pokemon.data.models.pokemonDetail.XYDto
import org.ailtontech.pokedex.features.pokemon.data.models.pokemonDetail.YellowDto

@LongMethodAllowed
fun createPokemonDetailDto(
	id: Int? = null,
	resultDto: ResultDto? = null,
): PokemonDetailDto {
	return PokemonDetailDto(
		abilities = listOf(),
		baseExperience = 2294,
		cries =
			CriesDto(
				latest = "adolescens",
				legacy = "ea",
			),
		forms = listOf(),
		gameIndices = listOf(),
		height = 1793,
		heldItems = listOf(),
		id = id ?: 6013,
		isDefault = false,
		locationAreaEncounters = "tellus",
		moves = listOf(),
		name = resultDto?.name ?: "Xavier Duke",
		order = 6921,
		pastAbilities = listOf(),
		pastTypes = listOf(),
		species =
			ResultDto(
				name = "Denver Benson",
				url = "https://search.yahoo.com/search?p=donec",
			),
		sprites =
			SpritesDto(
				backDefault = null,
				backFemale = null,
				backShiny = null,
				backShinyFemale = null,
				frontDefault = "diam",
				frontFemale = null,
				frontShiny = null,
				frontShinyFemale = null,
				other =
					OtherDto(
						dreamWorld =
							DreamWorldDto(
								frontDefault = null,
								frontFemale = null,
							),
						home =
							HomeDto(
								frontDefault = null,
								frontFemale = null,
								frontShiny = null,
								frontShinyFemale = null,
							),
						officialArtwork =
							OfficialArtworkDto(
								frontDefault = null,
								frontShiny = null,
							),
						showdown =
							ShowdownDto(
								backDefault = null,
								backFemale = null,
								backShiny = null,
								backShinyFemale = null,
								frontDefault = null,
								frontFemale = null,
								frontShiny = null,
								frontShinyFemale = null,
							),
					),
				versions =
					VersionsDto(
						generationI =
							GenerationIDto(
								redBlue =
									RedBlueDto(
										backDefault = null,
										backGray = null,
										backTransparent = null,
										frontDefault = null,
										frontGray = null,
										frontTransparent = null,
									),
								yellow =
									YellowDto(
										backDefault = null,
										backGray = null,
										backTransparent = null,
										frontDefault = null,
										frontGray = null,
										frontTransparent = null,
									),
							),
						generationIi =
							GenerationIiDto(
								crystal =
									CrystalDto(
										backDefault = null,
										backShiny = null,
										backShinyTransparent = null,
										backTransparent = null,
										frontDefault = null,
										frontShiny = null,
										frontShinyTransparent = null,
										frontTransparent = null,
									),
								gold =
									GoldDto(
										backDefault = null,
										backShiny = null,
										frontDefault = null,
										frontShiny = null,
										frontTransparent = null,
									),
								silver =
									SilverDto(
										backDefault = null,
										backShiny = null,
										frontDefault = null,
										frontShiny = null,
										frontTransparent = null,
									),
							),
						generationIii =
							GenerationIiiDto(
								emerald =
									EmeraldDto(
										frontDefault = null,
										frontShiny = null,
									),
								fireredLeafgreen =
									FireredLeafgreenDto(
										backDefault = null,
										backShiny = null,
										frontDefault = null,
										frontShiny = null,
									),
								rubySapphire =
									RubySapphireDto(
										backDefault = null,
										backShiny = null,
										frontDefault = null,
										frontShiny = null,
									),
							),
						generationIv =
							GenerationIvDto(
								diamondPearl =
									DiamondPearlDto(
										backDefault = null,
										backFemale = null,
										backShiny = null,
										backShinyFemale = null,
										frontDefault = null,
										frontFemale = null,
										frontShiny = null,
										frontShinyFemale = null,
									),
								heartgoldSoulsilver =
									HeartgoldSoulsilverDto(
										backDefault = null,
										backFemale = null,
										backShiny = null,
										backShinyFemale = null,
										frontDefault = null,
										frontFemale = null,
										frontShiny = null,
										frontShinyFemale = null,
									),
								platinum =
									PlatinumDto(
										backDefault = null,
										backFemale = null,
										backShiny = null,
										backShinyFemale = null,
										frontDefault = null,
										frontFemale = null,
										frontShiny = null,
										frontShinyFemale = null,
									),
							),
						generationV =
							GenerationVDto(
								blackWhite =
									BlackWhiteDto(
										animated =
											AnimatedDto(
												backDefault = null,
												backFemale = null,
												backShiny = null,
												backShinyFemale = null,
												frontDefault = "ante",
												frontFemale = null,
												frontShiny = null,
												frontShinyFemale = null,
											),
										backDefault = null,
										backFemale = null,
										backShiny = null,
										backShinyFemale = null,
										frontDefault = null,
										frontFemale = null,
										frontShiny = null,
										frontShinyFemale = null,
									),
							),
						generationVi =
							GenerationViDto(
								omegarubyAlphasapphire =
									OmegarubyAlphasapphireDto(
										frontDefault = null,
										frontFemale = null,
										frontShiny = null,
										frontShinyFemale = null,
									),
								xY =
									XYDto(
										frontDefault = null,
										frontFemale = null,
										frontShiny = null,
										frontShinyFemale = null,
									),
							),
						generationVii =
							GenerationViiDto(
								icons =
									IconsDto(
										frontDefault = null,
										frontFemale = null,
									),
								ultraSunUltraMoon =
									UltraSunUltraMoonDto(
										frontDefault = null,
										frontFemale = null,
										frontShiny = "facilisi",
										frontShinyFemale = null,
									),
							),
						generationViii =
							GenerationViiiDto(
								icons =
									IconsDto(
										frontDefault = null,
										frontFemale = null,
									),
							),
					),
			),
		stats = listOf(),
		types = listOf(),
		weight = 8086,
	)
}