package org.ailtontech.pokedex.features.pokemon.presentation.components

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import org.ailtontech.pokedex.core.utils.Constants.ROTATION_DEG
import org.ailtontech.pokedex.core.utils.Constants.ROTATION_DURATION
import org.ailtontech.pokedex.presentation.components.PokedexImage
import org.ailtontech.pokedex.presentation.theme.dimensions
import org.jetbrains.compose.resources.painterResource
import pokedex.composeapp.generated.resources.Res
import pokedex.composeapp.generated.resources.pokeball

@Composable
private fun rotationAnimation(): Float {
	val animation = rememberInfiniteTransition(label = "rotation animation")
	val rotation by animation.animateFloat(
		initialValue = 0f,
		targetValue = ROTATION_DEG,
		animationSpec =
			infiniteRepeatable(
				animation =
					tween(
						durationMillis = ROTATION_DURATION,
						easing = LinearEasing,
					),
				repeatMode = RepeatMode.Restart,
			),
		label = "rotation value",
	)
	return rotation
}

@Composable
fun PokemonDetailImage(
	modifier: Modifier = Modifier,
	url: String,
) {
	val rotation = rotationAnimation()
	Box(
		modifier = modifier,
		contentAlignment = Alignment.Center,
	) {
		PokedexImage(
			painter = painterResource(Res.drawable.pokeball),
			contentDescription = "poke-ball rotate",
			modifier =
				Modifier
					.fillMaxSize()
					.graphicsLayer {
						rotationZ = rotation
					},
			colorFilter =
				ColorFilter.tint(
					color = MaterialTheme.colorScheme.tertiary,
				),
		)

		PokedexImage(
			modifier =
				Modifier.fillMaxSize(MaterialTheme.dimensions.halfWeight),
			url = url,
			contentScale = ContentScale.Fit,
		)
	}
}