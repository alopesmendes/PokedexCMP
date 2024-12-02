package org.ailtontech.pokedex.core.utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import org.ailtontech.pokedex.core.logging.PokedexLogging

suspend inline fun <reified T> runSafe(
	dispatcher: CoroutineDispatcher,
	crossinline block: suspend () -> T,
): Result<T> =
	runCatching {
		withContext(dispatcher) {
			block()
		}
	}

fun extractQueryParameterValue(
	queryParameter: String,
	url: String,
): String? {
	require(url.contains(queryParameter))

	val query = url.substringAfter("?", "")
	val parameters =
		query.split("&").associate {
			val (key, value) = it.split("=")
			key to value
		}
	return parameters[queryParameter]
}

inline fun <reified T> Result<T>.mapToUiState(): UiState<T> =
	fold(
		onSuccess = { UiState.Success(it) },
		onFailure = {
			PokedexLogging.error(it.stackTraceToString())
			UiState.Error(it)
		},
	)