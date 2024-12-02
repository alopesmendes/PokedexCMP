package org.ailtontech.pokedex.di

import kotlinx.coroutines.CoroutineDispatcher
import org.ailtontech.pokedex.core.logging.ILogging
import org.ailtontech.pokedex.core.logging.PokedexLogging
import org.ailtontech.pokedex.core.utils.getDispatcher
import org.koin.dsl.module

val appModule =
	module {
		single<ILogging> { PokedexLogging }

		single<CoroutineDispatcher> { getDispatcher() }
	}