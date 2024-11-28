package org.ailtontech.pokedex.presentation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import org.ailtontech.pokedex.core.utils.Constants.ANIMATION_DELAY
import org.ailtontech.pokedex.presentation.theme.dimensions
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun SectionComponent(
	modifier: Modifier = Modifier,
	title: @Composable () -> Unit = {},
	content: @Composable () -> Unit = {},
) {
	var expanded by rememberSaveable { mutableStateOf(true) }
	val iconRotation by animateFloatAsState(
		targetValue = if (expanded) 180f else 0f,
		label = "icon",
		animationSpec = tween(ANIMATION_DELAY),
	)
	Column(
		modifier = modifier,
	) {
		Row(
			modifier = Modifier.fillMaxWidth(),
			horizontalArrangement = Arrangement.SpaceBetween,
			verticalAlignment = Alignment.CenterVertically,
		) {
			title()
			IconButton(
				onClick = { expanded = !expanded },
			) {
				Icon(
					Icons.Filled.ArrowDropDown,
					contentDescription = null,
					modifier = Modifier.rotate(iconRotation),
				)
			}
		}

		HorizontalDivider(color = MaterialTheme.colorScheme.tertiary)
		AnimatedVisibility(
			visible = expanded,
		) {
			Spacer(Modifier.size(MaterialTheme.dimensions.small))
			content()
		}
	}
}

@Composable
@Preview
private fun SectionComponentPreview() {
	SectionComponent()
}