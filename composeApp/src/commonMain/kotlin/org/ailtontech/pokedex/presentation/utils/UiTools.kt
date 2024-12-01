package org.ailtontech.pokedex.presentation.utils

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffoldRole
import androidx.compose.material3.adaptive.layout.PaneAdaptedValue
import androidx.compose.material3.adaptive.navigation.ThreePaneScaffoldNavigator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.produceState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.lerp
import coil3.ImageLoader
import coil3.PlatformContext
import coil3.disk.DiskCache
import coil3.memory.MemoryCache
import coil3.request.CachePolicy
import coil3.request.crossfade
import coil3.util.DebugLogger
import kotlinx.collections.immutable.persistentMapOf
import org.ailtontech.pokedex.Platform
import org.ailtontech.pokedex.core.utils.Constants.DIRECTORY_PATH
import org.ailtontech.pokedex.core.utils.Constants.MAX_SIZE_BYTES
import org.ailtontech.pokedex.core.utils.Constants.MAX_SIZE_PERCENT
import org.ailtontech.pokedex.features.pokemon.domain.entities.Type
import org.ailtontech.pokedex.getPlatform
import org.ailtontech.pokedex.presentation.components.ChipItem

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

val typesColors =
	persistentMapOf(
		"normal" to Color(0xFFA8A77A),
		"fire" to Color(0xFFEE8130),
		"water" to Color(0xFF6390F0),
		"electric" to Color(0xFFF7D02C),
		"grass" to Color(0xFF7AC74C),
		"ice" to Color(0xFF96D9D6),
		"fighting" to Color(0xFFC22E28),
		"poison" to Color(0xFFA33EA1),
		"ground" to Color(0xFFE2BF65),
		"flying" to Color(0xFFA98FF3),
		"psychic" to Color(0xFFF95587),
		"bug" to Color(0xFFA6B91A),
		"rock" to Color(0xFFB6A136),
		"ghost" to Color(0xFF735797),
		"dragon" to Color(0xFF6F35FC),
		"dark" to Color(0xFF705746),
		"steel" to Color(0xFFB7B7CE),
		"fairy" to Color(0xFFD685AD),
	)

fun Type.mapToChipItem() =
	ChipItem(
		label = name,
		containerColor = typesColors[name] ?: Color.Unspecified,
	)

@Composable
fun rememberInterpolateColor(
	color: Color,
	factor: Float,
	darkTheme: Boolean = isSystemInDarkTheme(),
): State<Color> {
	fun Color.interpolateColor(
		other: Color,
		factor: Float,
	): Color {
		return lerp(this, other, factor.coerceIn(0f, 1f))
	}

	return produceState(initialValue = color, color, factor, darkTheme) {
		value =
			if (darkTheme) {
				color.interpolateColor(other = Color.Black, factor = factor)
			} else {
				color.interpolateColor(other = Color.White, factor = factor)
			}
	}
}

fun shouldOnlyDisplayNavigationBar(): Boolean = getPlatform() == Platform.Ios

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
fun <T> ThreePaneScaffoldNavigator<T>.isListExpanded(): Boolean =
	scaffoldValue[ListDetailPaneScaffoldRole.List] == PaneAdaptedValue.Expanded

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
fun <T> ThreePaneScaffoldNavigator<T>.isDetailExpanded(): Boolean =
	scaffoldValue[ListDetailPaneScaffoldRole.Detail] == PaneAdaptedValue.Expanded