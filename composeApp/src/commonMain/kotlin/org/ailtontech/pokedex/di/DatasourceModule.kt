package org.ailtontech.pokedex.di

import io.ktor.client.HttpClient
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.HttpRequestRetry
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.isSuccess
import io.ktor.http.path
import io.ktor.serialization.kotlinx.json.json
import kotlinx.io.IOException
import kotlinx.serialization.json.Json
import org.ailtontech.pokedex.core.utils.Constants.BASE_HOST
import org.ailtontech.pokedex.core.utils.Constants.BASE_PATH
import org.ailtontech.pokedex.core.utils.Constants.MAX_RETRIES
import org.ailtontech.pokedex.core.utils.Constants.REQUEST_TIMEOUT_MILLIS
import org.ailtontech.pokedex.core.utils.Constants.RETRY_REQUEST_DELAY
import org.koin.dsl.module

val datasourceModule =
	module {
		single {
			HttpClient {
				install(ContentNegotiation) {
					json(
						Json {
							ignoreUnknownKeys = true
							useAlternativeNames = false
							prettyPrint = true
							isLenient = true
						},
					)
				}
				install(Logging) {
					logger = Logger.DEFAULT
					level = LogLevel.BODY
				}

				install(HttpTimeout) {
					requestTimeoutMillis = REQUEST_TIMEOUT_MILLIS
				}

				install(HttpRequestRetry) {
					maxRetries = MAX_RETRIES
					retryIf { _, response ->
						!response.status.isSuccess()
					}
					retryOnExceptionIf { _, cause ->
						cause is ClientRequestException || cause is ServerResponseException || cause is IOException
					}
					delayMillis { retry ->
						retry * RETRY_REQUEST_DELAY
					}
				}

				defaultRequest {
					url {
						protocol = io.ktor.http.URLProtocol.HTTPS
						host = BASE_HOST
						path(BASE_PATH)
					}
				}
			}
		}
	}