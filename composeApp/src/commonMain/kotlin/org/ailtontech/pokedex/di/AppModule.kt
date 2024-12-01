package org.ailtontech.pokedex.di

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.ailtontech.pokedex.core.logging.ILogging
import org.ailtontech.pokedex.core.logging.PokedexLogging
import org.koin.dsl.module

val appModule =
	module {
		single<ILogging> { PokedexLogging }

		single<CoroutineDispatcher> { Dispatchers.IO }
	}