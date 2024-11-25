package org.ailtontech.pokedex.core.logging

import io.github.aakira.napier.Napier

interface ILogging {
	fun debug(message: String)

	fun info(message: String)

	fun warn(message: String)

	fun error(message: String)
}

object PokedexLogging : ILogging {
	override fun debug(message: String) {
		Napier.d(message)
	}

	override fun info(message: String) {
		Napier.i(message)
	}

	override fun warn(message: String) {
		Napier.w(message)
	}

	override fun error(message: String) {
		Napier.e(message)
	}
}