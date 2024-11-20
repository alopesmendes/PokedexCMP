package org.ailtontech.pokedex

import android.app.Application
import org.ailtontech.pokedex.di.moduleList
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class PokedexApplication : Application() {
	override fun onCreate() {
		super.onCreate()
		startKoin {
			androidContext(this@PokedexApplication)

			modules(moduleList)
		}
	}
}