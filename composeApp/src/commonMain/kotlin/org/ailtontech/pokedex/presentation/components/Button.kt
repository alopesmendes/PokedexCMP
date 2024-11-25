package org.ailtontech.pokedex.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.window.core.layout.WindowWidthSizeClass.Companion.COMPACT
import androidx.window.core.layout.WindowWidthSizeClass.Companion.EXPANDED
import androidx.window.core.layout.WindowWidthSizeClass.Companion.MEDIUM
import org.ailtontech.pokedex.presentation.theme.LocalWindowSizeClass
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun PokedexIconButton(
	modifier: Modifier = Modifier,
	icon: ImageVector,
	contentDescription: String? = null,
	colors: IconButtonColors = IconButtonDefaults.iconButtonColors(),
	onClick: () -> Unit,
) {
	IconButton(
		modifier = modifier,
		onClick = onClick,
		colors = colors,
	) {
		Icon(icon, contentDescription = contentDescription)
	}
}

@Composable
fun PokedexFloatingActionButton(
	modifier: Modifier = Modifier,
	onClick: () -> Unit,
	icon: ImageVector,
	contentDescription: String? = null,
	label: String,
) {
	val windowSizeClass = LocalWindowSizeClass.current
	when (windowSizeClass.windowWidthSizeClass) {
		COMPACT -> {
			SmallFloatingActionButton(
				modifier = modifier,
				onClick = onClick,
			) {
				Icon(icon, contentDescription = contentDescription)
			}
		}
		MEDIUM -> {
			FloatingActionButton(
				modifier = modifier,
				onClick = onClick,
			) {
				Icon(
					icon,
					contentDescription = contentDescription,
				)
			}
		}
		EXPANDED -> {
			ExtendedFloatingActionButton(
				modifier = modifier,
				onClick = onClick,
				icon = { Icon(icon, contentDescription = contentDescription) },
				text = { Text(label) },
			)
		}
		else ->
			SmallFloatingActionButton(
				modifier = modifier,
				onClick = onClick,
			) {
				Icon(icon, contentDescription = contentDescription)
			}
	}
}

@Preview
@Composable
fun PreviewPokedexIconButton() {
	PokedexIconButton(
		icon = Icons.Filled.Add,
		onClick = {},
	)
}

@Composable
@Preview
fun PreviewPokedexFloatingActionButton() {
	PokedexFloatingActionButton(
		onClick = {},
		icon = Icons.Filled.Add,
		label = "Add",
	)
}