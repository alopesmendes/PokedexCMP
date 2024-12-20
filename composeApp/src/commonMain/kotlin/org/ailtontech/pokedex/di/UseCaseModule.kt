package org.ailtontech.pokedex.di

import org.ailtontech.pokedex.features.location.domain.useCases.GetLocationDetailUseCase
import org.ailtontech.pokedex.features.location.domain.useCases.GetLocationsOverviewUseCase
import org.ailtontech.pokedex.features.location.domain.useCases.impl.GetLocationDetailUseCaseImpl
import org.ailtontech.pokedex.features.location.domain.useCases.impl.GetLocationsOverviewUseCaseImpl
import org.ailtontech.pokedex.features.pokemon.domain.useCases.GetPokemonDetailUseCase
import org.ailtontech.pokedex.features.pokemon.domain.useCases.GetPokemonListUseCase
import org.ailtontech.pokedex.features.pokemon.domain.useCases.impl.GetPokemonDetailUseCaseImpl
import org.ailtontech.pokedex.features.pokemon.domain.useCases.impl.GetPokemonListUseCaseImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val useCaseModule =
	module {
		singleOf(::GetPokemonListUseCaseImpl) { bind<GetPokemonListUseCase>() }
		singleOf(::GetPokemonDetailUseCaseImpl) { bind<GetPokemonDetailUseCase>() }
		singleOf(::GetLocationsOverviewUseCaseImpl) { bind<GetLocationsOverviewUseCase>() }
		singleOf(::GetLocationDetailUseCaseImpl) { bind<GetLocationDetailUseCase>() }
	}