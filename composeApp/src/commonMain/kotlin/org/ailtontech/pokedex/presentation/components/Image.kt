package org.ailtontech.pokedex.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import coil3.compose.AsyncImage
import org.ailtontech.pokedex.presentation.theme.dimensions
import org.jetbrains.compose.resources.painterResource
import pokedex.composeapp.generated.resources.Res
import pokedex.composeapp.generated.resources.error_avatar
import pokedex.composeapp.generated.resources.placeholder
import pokedex.composeapp.generated.resources.pokeball

@Composable
fun PokedexImage(
	modifier: Modifier = Modifier,
	url: String,
	contentDescription: String? = null,
	contentScale: ContentScale = ContentScale.Fit,
) {
	AsyncImage(
		url,
		modifier =
			modifier
				.aspectRatio(MaterialTheme.dimensions.cardImageAspectRatio),
		contentDescription = contentDescription,
		placeholder = painterResource(Res.drawable.placeholder),
		error = painterResource(Res.drawable.error_avatar),
		contentScale = contentScale,
		filterQuality = FilterQuality.High,
	)
}

@Composable
fun PokedexImage(
	modifier: Modifier = Modifier,
	painter: Painter,
	contentDescription: String? = null,
	contentScale: ContentScale = ContentScale.Fit,
	colorFilter: ColorFilter? = null,
) {
	Image(
		painter = painter,
		contentDescription = contentDescription,
		modifier = modifier,
		contentScale = contentScale,
		colorFilter = colorFilter,
	)
}