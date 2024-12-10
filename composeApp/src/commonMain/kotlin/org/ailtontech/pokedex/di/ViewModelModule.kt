package org.ailtontech.pokedex.di

import org.ailtontech.pokedex.features.location.presentation.viewModels.LocationViewModel
import org.ailtontech.pokedex.features.pokemon.presentation.viewModels.PokemonViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule =
	module {
		viewModelOf(::PokemonViewModel)
		viewModelOf(::LocationViewModel)
	}