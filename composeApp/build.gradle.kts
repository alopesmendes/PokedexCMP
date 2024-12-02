import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig
import org.jlleitschuh.gradle.ktlint.reporter.ReporterType

plugins {
	alias(libs.plugins.kotlinMultiplatform)
	alias(libs.plugins.androidApplication)
	alias(libs.plugins.composeMultiplatform)
	alias(libs.plugins.composeCompiler)
	alias(libs.plugins.ktlint)
	alias(libs.plugins.detekt)
	alias(libs.plugins.dokka)
	alias(libs.plugins.mokkery)
	alias(libs.plugins.kotestMultiplatform)
	alias(libs.plugins.kotlinSerialization)
}

kotlin {
	androidTarget {
		@OptIn(ExperimentalKotlinGradlePluginApi::class)
		compilerOptions {
			jvmTarget.set(JvmTarget.JVM_11)
		}
	}

	@OptIn(ExperimentalWasmDsl::class)
	wasmJs {
		moduleName = "composeApp"
		browser {
			val rootDirPath = project.rootDir.path
			val projectDirPath = project.projectDir.path
			commonWebpackConfig {
				outputFileName = "composeApp.js"
				devServer =
					(devServer ?: KotlinWebpackConfig.DevServer()).apply {
						static =
							(static ?: mutableListOf()).apply {
								// Serve sources to debug inside browser
								add(rootDirPath)
								add(projectDirPath)
							}
					}
			}
		}
		binaries.executable()
	}

	listOf(
		iosX64(),
		iosArm64(),
		iosSimulatorArm64(),
	).forEach { iosTarget ->
		iosTarget.binaries.framework {
			baseName = "ComposeApp"
			isStatic = true
			binaryOption("bundleId", "org.ailtontech.pokedex")
		}
	}

	jvm("desktop")

	sourceSets {
		val desktopMain by getting

		androidMain.dependencies {
			implementation(compose.preview)
			implementation(libs.androidx.activity.compose)

			// KOIN
			implementation(libs.koin.android)

			// KTOR
			implementation(libs.ktor.client.okhttp)

			// COROUTINES
			implementation(libs.kotlinx.coroutines.android)
		}

		commonMain.dependencies {
			implementation(compose.runtime)
			implementation(compose.foundation)
			implementation(compose.material3)
			implementation(compose.ui)
			implementation(compose.components.resources)
			implementation(compose.components.uiToolingPreview)
			implementation(compose.material3AdaptiveNavigationSuite)
			implementation(compose.materialIconsExtended)

			// LIFECYCLE
			implementation(libs.bundles.lifecycle)

			// KOIN
			implementation(project.dependencies.platform(libs.koin.bom))
			implementation(libs.koin.core)
			implementation(libs.koin.compose)
			implementation(libs.koin.compose.viewmodel)

			// KTOR
			implementation(libs.bundles.ktor)

			// COIL
			implementation(libs.bundles.coil)

			// NAVIGATION
			implementation(libs.bundles.navigation)

			// KOTLINX
			implementation(libs.bundles.kotlinx)

			// ADAPTIVE
			implementation(libs.bundles.adaptive)

			// Logging
			implementation(libs.napier)
		}

		iosMain.dependencies {
			// KTOR
			implementation(libs.ktor.client.darwin)
		}

		jvmMain.dependencies {
			implementation(compose.desktop.currentOs)
			implementation(libs.kotlinx.coroutines.swing)

			// KTOR
			implementation(libs.ktor.client.cio)
		}

		commonTest.dependencies {
			implementation(kotlin("test-common"))
			implementation(kotlin("test-annotations-common"))
			implementation(libs.bundles.kotlinx.test)
			implementation(libs.turbine)
			implementation(libs.bundles.kotest)

			@OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
			implementation(compose.uiTest)
		}

		jvmTest.dependencies {
			implementation(libs.kotest.runner.junit5)
		}
	}
}

android {
	namespace = "org.ailtontech.pokedex"
	compileSdk = libs.versions.android.compileSdk.get().toInt()

	defaultConfig {
		applicationId = "org.ailtontech.pokedex"
		minSdk = libs.versions.android.minSdk.get().toInt()
		targetSdk = libs.versions.android.targetSdk.get().toInt()
		versionCode = 1
		versionName = "1.0"
	}
	packaging {
		resources {
			excludes += "/META-INF/{AL2.0,LGPL2.1}"
		}
	}
	buildTypes {
		getByName("release") {
			isMinifyEnabled = false
		}
	}
	compileOptions {
		sourceCompatibility = JavaVersion.VERSION_11
		targetCompatibility = JavaVersion.VERSION_11
	}
}

dependencies {
	debugImplementation(compose.uiTooling)
}

compose.desktop {
	application {
		mainClass = "org.ailtontech.pokedex.MainKt"

		nativeDistributions {
			targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
			packageName = "org.ailtontech.pokedex"
			packageVersion = "1.0.0"
		}
	}
}

tasks.register<Copy>("copyPrepareCommitMsgHook") {
	description = "Copy prepare-commit-msg git hook from the scripts to the .git/hooks folder."
	group = "git hooks"
	outputs.upToDateWhen { false }
	from("$rootDir/scripts/prepare-commit-msg")
	into("$rootDir/.git/hooks/")
	doLast {
		// Make the script executable
		val preCommitHook = file("$rootDir/.git/hooks/prepare-commit-msg")
		if (preCommitHook.exists()) {
			preCommitHook.setExecutable(true)
		}
	}
}

tasks.register<Copy>("copyPreCommitHook") {
	description = "Copy pre-commit git hook from the scripts to the .git/hooks folder."
	group = "git hooks"
	outputs.upToDateWhen { false }
	from("$rootDir/scripts/pre-commit")
	into("$rootDir/.git/hooks/")
	doLast {
		// Make the script executable
		val preCommitHook = file("$rootDir/.git/hooks/pre-commit")
		if (preCommitHook.exists()) {
			preCommitHook.setExecutable(true)
		}
	}
}

tasks.register("initializeProject") {
	description = "Initialize the project."
	dependsOn("copyPrepareCommitMsgHook")
	dependsOn("copyPreCommitHook")
}

ktlint {
	android.set(false)
	verbose.set(true)
	outputToConsole.set(true)
	outputColorName.set("RED")
	enableExperimentalRules.set(true)

	reporters {
		reporter(ReporterType.HTML)
		reporter(ReporterType.CHECKSTYLE)
		reporter(ReporterType.JSON)
	}
}

detekt {
	parallel = true
	allRules = false
	autoCorrect = true
	buildUponDefaultConfig = true
	source.setFrom(files("$rootDir/composeApp/src/"))
	config.setFrom(file("$rootDir/config/detekt.yml"))
}

tasks.named<Test>("desktopTest") {
	useJUnitPlatform()
	filter {
		isFailOnNoMatchingTests = false
	}
	testLogging {
		showExceptions = true
		showStandardStreams = true
		events =
			setOf(
				org.gradle.api.tasks.testing.logging.TestLogEvent.FAILED,
				org.gradle.api.tasks.testing.logging.TestLogEvent.PASSED,
			)
		exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
	}
}

dependencies {
	implementation(libs.androidx.ui.test.android)
	testImplementation(libs.konsist)
}