This is a Kotlin Multiplatform project targeting Android, iOS, Desktop.

* `/composeApp` is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - `commonMain` is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
    `iosMain` would be the right folder for such calls.

* `/iosApp` contains iOS applications. Even if you’re sharing your UI with Compose Multiplatform, 
  you need this entry point for your iOS app. This is also where you should add SwiftUI code for your project.

Command to initialize other commands of the gradle in the project : 
`./gradlew initializeProject`

Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)…

You can open the web application by running the `:composeApp:wasmJsBrowserDevelopmentRun` Gradle task and launch by 
doing `./gradlew composeApp:wasmJsBrowserDevelopmentRun`

# Contributing
## Flaticon
- [Pokemon icons created by Darius Dan - Flaticon](https://www.flaticon.com/free-icons/pokemon)
<a href="https://www.flaticon.com/free-icons/pokemon" title="pokemon icons">Pokemon icons created by Darius Dan - Flaticon</a>