package org.ailtontech.pokedex.presentation.theme.type

import androidx.compose.material3.Typography
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val CompactTypography
	@ReadOnlyComposable
	get() =
		Typography(
			displayLarge = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.Bold),
			displayMedium = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold),
			displaySmall = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
			headlineLarge = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Medium),
			headlineMedium = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Medium),
			headlineSmall = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Medium),
			bodyLarge = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Normal),
			bodyMedium = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Normal),
			bodySmall = TextStyle(fontSize = 10.sp, fontWeight = FontWeight.Normal),
			labelLarge = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Medium),
			labelMedium = TextStyle(fontSize = 10.sp, fontWeight = FontWeight.Medium),
			labelSmall = TextStyle(fontSize = 8.sp, fontWeight = FontWeight.Medium),
		)

val MediumTypography
	@ReadOnlyComposable
	get() =
		Typography(
			displayLarge = TextStyle(fontSize = 40.sp, fontWeight = FontWeight.Bold),
			displayMedium = TextStyle(fontSize = 34.sp, fontWeight = FontWeight.Bold),
			displaySmall = TextStyle(fontSize = 28.sp, fontWeight = FontWeight.Bold),
			headlineLarge = TextStyle(fontSize = 22.sp, fontWeight = FontWeight.Medium),
			headlineMedium = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Medium),
			headlineSmall = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Medium),
			bodyLarge = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Normal),
			bodyMedium = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Normal),
			bodySmall = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Normal),
			labelLarge = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Medium),
			labelMedium = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Medium),
			labelSmall = TextStyle(fontSize = 10.sp, fontWeight = FontWeight.Medium),
		)

val ExpandedTypography
	@ReadOnlyComposable
	get() =
		Typography(
			displayLarge = TextStyle(fontSize = 60.sp, fontWeight = FontWeight.Bold),
			displayMedium = TextStyle(fontSize = 50.sp, fontWeight = FontWeight.Bold),
			displaySmall = TextStyle(fontSize = 40.sp, fontWeight = FontWeight.Bold),
			headlineLarge = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.Medium),
			headlineMedium = TextStyle(fontSize = 26.sp, fontWeight = FontWeight.Medium),
			headlineSmall = TextStyle(fontSize = 22.sp, fontWeight = FontWeight.Medium),
			bodyLarge = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Normal),
			bodyMedium = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Normal),
			bodySmall = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Normal),
			labelLarge = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Medium),
			labelMedium = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Medium),
			labelSmall = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Medium),
		)

val LocalTypography =
	staticCompositionLocalOf<Typography> {
		error("Typography not provided")
	}