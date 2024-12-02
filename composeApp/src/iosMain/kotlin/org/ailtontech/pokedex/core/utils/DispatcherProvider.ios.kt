package org.ailtontech.pokedex.core.utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

actual fun getDispatcher(): CoroutineDispatcher = Dispatchers.IO