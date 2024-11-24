package org.ailtontech.pokedex.presentation.components

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import org.ailtontech.pokedex.core.utils.Constants.ANIMATION_DELAY
import org.ailtontech.pokedex.core.utils.Constants.DURATION_MILLIS
import org.ailtontech.pokedex.presentation.theme.LocalWindowSizeClass
import org.ailtontech.pokedex.presentation.theme.dimensions
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun CompactLoadingComponent(modifier: Modifier = Modifier) {
	CircularProgressIndicator(modifier)
}

@Composable
@Preview
private fun CompactLoadingComponentPreview() {
	CompactLoadingComponent()
}

@Composable
fun MediumLoadingComponent(modifier: Modifier = Modifier) {
	LinearProgressIndicator(modifier)
}

@Composable
@Preview
private fun MediumLoadingComponentPreview() {
	MediumLoadingComponent()
}

@Composable
fun ExpandedLoadingComponent(modifier: Modifier = Modifier) {
	val dimensions = MaterialTheme.dimensions
	val density = LocalDensity.current
	val maxOffset =
		remember(dimensions.medium) {
			with(density) { dimensions.medium.toPx() }
		}

	@Composable
	fun Dot(offset: Float) =
		Spacer(
			Modifier
				.size(dimensions.medium)
				.offset(y = with(density) { offset.toDp() })
				.background(
					color = MaterialTheme.colorScheme.primary,
					shape = CircleShape,
				),
		)

	val infiniteTransition = rememberInfiniteTransition()

	@Composable
	fun animateOffsetWithDelay(delay: Int) =
		infiniteTransition.animateFloat(
			initialValue = 0f,
			targetValue = 0f,
			animationSpec =
				infiniteRepeatable(
					animation =
						keyframes {
							durationMillis = DURATION_MILLIS
							0f at delay using LinearEasing
							maxOffset at delay + ANIMATION_DELAY using LinearEasing
							0f at delay + ANIMATION_DELAY * 2
						},
					repeatMode = RepeatMode.Restart,
				),
		)
	val scale1 by animateOffsetWithDelay(0)
	val scale2 by animateOffsetWithDelay(ANIMATION_DELAY)
	val scale3 by animateOffsetWithDelay(ANIMATION_DELAY * 2)

	Row(
		horizontalArrangement = Arrangement.spacedBy(dimensions.small),
		verticalAlignment = Alignment.CenterVertically,
		modifier = modifier,
	) {
		Dot(scale1)
		Dot(scale2)
		Dot(scale3)
	}
}

@Composable
fun LoadingComponent(modifier: Modifier = Modifier) {
	val windowSizeClass = LocalWindowSizeClass.current
	when (windowSizeClass.widthSizeClass) {
		WindowWidthSizeClass.Compact -> CompactLoadingComponent(modifier)
		WindowWidthSizeClass.Medium -> MediumLoadingComponent(modifier)
		WindowWidthSizeClass.Expanded -> ExpandedLoadingComponent(modifier)
	}
}

@Composable
@Preview
private fun LoadingComponentPreview() {
	LoadingComponent()
}