package org.ailtontech.pokedex.di

import org.koin.core.context.startKoin

val moduleList =
	listOf(
		datasourceModule,
		repositoryModule,
		useCaseModule,
		viewModelModule,
		reducerModule,
		platformModule,
		appModule,
	)

fun initializeKoin() {
	startKoin {
		modules(moduleList)
	}
}