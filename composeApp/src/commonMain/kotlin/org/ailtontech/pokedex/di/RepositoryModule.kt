package org.ailtontech.pokedex.di

import org.ailtontech.pokedex.features.location.data.repositories.LocationRepositoryImpl
import org.ailtontech.pokedex.features.location.domain.repositories.LocationRepository
import org.ailtontech.pokedex.features.pokemon.data.repositories.PokemonRepositoryImpl
import org.ailtontech.pokedex.features.pokemon.domain.repositories.PokemonRepository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val repositoryModule =
	module {
		singleOf(::PokemonRepositoryImpl) { bind<PokemonRepository>() }
		singleOf(::LocationRepositoryImpl) { bind<LocationRepository>() }
	}