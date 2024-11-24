package org.ailtontech.pokedex.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import pokedex.composeapp.generated.resources.Res
import pokedex.composeapp.generated.resources.close
import pokedex.composeapp.generated.resources.error_avatar
import pokedex.composeapp.generated.resources.error_title

@Composable
fun ErrorComponent(errorMessage: String) {
	var openDialog by remember { mutableStateOf(true) }

	if (openDialog) {
		AlertDialog(
			confirmButton = {
				Button(
					onClick = {
						openDialog = false
					},
				) {
					Text(stringResource(Res.string.close))
				}
			},
			title = {
				Text(stringResource(Res.string.error_title))
			},
			icon = {
				Image(
					painterResource(Res.drawable.error_avatar),
					contentDescription = null,
				)
			},
			text = {
				Text(errorMessage)
			},
			onDismissRequest = {
				openDialog = false
			},
		)
	}
}

@Composable
@Preview
private fun ErrorComponentPreview() {
	ErrorComponent(errorMessage = "Error message")
}