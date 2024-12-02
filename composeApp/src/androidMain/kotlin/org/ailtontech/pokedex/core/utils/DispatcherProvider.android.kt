package org.ailtontech.pokedex.core.utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

actual fun getDispatcher(): CoroutineDispatcher = Dispatchers.IO