package org.ailtontech.pokedex.presentation.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun TextDisplay(
	modifier: Modifier = Modifier,
	text: String,
	color: Color = MaterialTheme.colorScheme.onBackground,
) {
	Text(
		modifier = modifier,
		text = text,
		style = MaterialTheme.typography.displaySmall,
		color = color,
		overflow = TextOverflow.Clip,
		textAlign = TextAlign.Start,
	)
}

@Composable
@Preview
private fun TextDisplayPreview() {
	TextDisplay(text = "Title text")
}

@Composable
fun TextBody(
	modifier: Modifier = Modifier,
	text: String,
	color: Color = MaterialTheme.colorScheme.onBackground,
	maxLines: Int = Int.MAX_VALUE,
	fontWeight: FontWeight? = null,
) {
	Text(
		modifier = modifier,
		text = text,
		style = MaterialTheme.typography.bodyMedium,
		color = color,
		maxLines = maxLines,
		fontWeight = fontWeight,
	)
}

@Composable
@Preview
private fun TextBodyPreview() {
	TextBody(
		text = "Text body",
	)
}

@Composable
fun TextCaption(
	modifier: Modifier = Modifier,
	text: String,
	color: Color = MaterialTheme.colorScheme.onBackground,
) {
	Text(
		modifier = modifier,
		text = text,
		style = MaterialTheme.typography.bodySmall,
		color = color,
	)
}

@Composable
@Preview
private fun TextCaptionPreview() {
	TextCaption(
		text = "Text caption",
	)
}

@Composable
fun TextTitle(
	modifier: Modifier = Modifier,
	text: String,
	color: Color = MaterialTheme.colorScheme.onBackground,
) {
	Text(
		modifier = modifier,
		text = text,
		style = MaterialTheme.typography.titleLarge,
		color = color,
	)
}

@Composable
@Preview
private fun TextTitlePreview() {
	TextTitle(
		text = "Text title",
	)
}