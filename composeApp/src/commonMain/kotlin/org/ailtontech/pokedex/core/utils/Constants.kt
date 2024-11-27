package org.ailtontech.pokedex.core.utils

import okio.FileSystem

object Constants {
	const val ANIMATION_DELAY = 300
	const val DURATION_MILLIS = ANIMATION_DELAY * 4

	// Image Loader Factory
	const val MAX_SIZE_BYTES = 1024L * 1024L * 1024L // 512MB
	const val MAX_SIZE_PERCENT = .3
	val DIRECTORY_PATH = FileSystem.SYSTEM_TEMPORARY_DIRECTORY / "image_cache"

	// VIEW MODEL
	const val WHILE_SUBSCRIBED_TIMEOUT_MILLIS = 5_000L

	// NETWORK
	const val REQUEST_TIMEOUT_MILLIS = 15_000L
	const val RETRY_REQUEST_DELAY = 3_000L
	const val MAX_RETRIES = 5
	const val BASE_URL = "https://pokeapi.co/api/v2/"
}