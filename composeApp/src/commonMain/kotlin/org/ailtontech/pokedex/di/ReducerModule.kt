package org.ailtontech.pokedex.di

import org.ailtontech.pokedex.features.pokemon.presentation.reducers.PokemonReducer
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val reducerModule =
	module {
		singleOf(::PokemonReducer)
	}