package org.ailtontech.pokedex

enum class Platform {
	Android,
	Ios,
	Desktop,
}

expect fun getPlatform(): Platform