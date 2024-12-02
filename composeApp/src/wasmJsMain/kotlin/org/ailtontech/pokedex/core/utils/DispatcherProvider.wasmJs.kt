package org.ailtontech.pokedex.core.utils

import io.ktor.client.utils.clientDispatcher
import io.ktor.utils.io.InternalAPI
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@OptIn(InternalAPI::class)
actual fun getDispatcher(): CoroutineDispatcher =
	Dispatchers.clientDispatcher(
		dispatcherName = "IO",
		threadCount = 200,
	)