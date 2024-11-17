package org.ailtontech.pokedex

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform