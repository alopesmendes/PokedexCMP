package org.ailtontech.pokedex.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.layout.ContentScale
import coil3.compose.AsyncImage
import org.jetbrains.compose.resources.painterResource
import pokedex.composeapp.generated.resources.Res
import pokedex.composeapp.generated.resources.error_avatar
import pokedex.composeapp.generated.resources.placeholder

@Composable
fun PokedexImage(
	modifier: Modifier = Modifier,
	url: String,
	contentDescription: String? = null,
	contentScale: ContentScale = ContentScale.Fit,
) {
	AsyncImage(
		url,
		modifier = modifier,
		contentDescription = contentDescription,
		placeholder = painterResource(Res.drawable.placeholder),
		error = painterResource(Res.drawable.error_avatar),
		contentScale = contentScale,
		filterQuality = FilterQuality.High,
	)
}