package org.ailtontech.pokedex.di

import org.ailtontech.pokedex.core.logging.ILogging
import org.ailtontech.pokedex.core.logging.PokedexLogging
import org.koin.dsl.module

val appModule =
	module {
		single<ILogging> { PokedexLogging }
	}