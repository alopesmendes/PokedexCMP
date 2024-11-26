package org.ailtontech.pokedex.core.utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext

suspend inline fun <reified T> runSafe(
	dispatcher: CoroutineDispatcher = Dispatchers.IO,
	crossinline block: suspend () -> T,
): Result<T> =
	runCatching {
		withContext(dispatcher) {
			block()
		}
	}