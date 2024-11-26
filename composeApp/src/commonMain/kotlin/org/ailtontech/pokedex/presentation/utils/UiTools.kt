package org.ailtontech.pokedex.presentation.utils

import coil3.ImageLoader
import coil3.PlatformContext
import coil3.disk.DiskCache
import coil3.memory.MemoryCache
import coil3.request.CachePolicy
import coil3.request.crossfade
import coil3.util.DebugLogger
import org.ailtontech.pokedex.core.utils.Constants.DIRECTORY_PATH
import org.ailtontech.pokedex.core.utils.Constants.MAX_SIZE_BYTES
import org.ailtontech.pokedex.core.utils.Constants.MAX_SIZE_PERCENT

fun getAsyncImageLoader(context: PlatformContext) =
	ImageLoader.Builder(context)
		.memoryCachePolicy(CachePolicy.ENABLED)
		.memoryCache {
			MemoryCache
				.Builder()
				.maxSizePercent(context, MAX_SIZE_PERCENT)
				.strongReferencesEnabled(true)
				.build()
		}
		.diskCachePolicy(CachePolicy.ENABLED)
		.networkCachePolicy(CachePolicy.ENABLED)
		.diskCache {
			newDiskCache()
		}
		.crossfade(true)
		.logger(DebugLogger())
		.components {
		}
		.build()

fun newDiskCache(): DiskCache {
	return DiskCache
		.Builder()
		.directory(DIRECTORY_PATH)
		.maxSizeBytes(MAX_SIZE_BYTES)
		.build()
}