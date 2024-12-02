package org.ailtontech.pokedex

enum class Platform {
	Android,
	Ios,
	Desktop,
	Wasm,
}

expect fun getPlatform(): Platform