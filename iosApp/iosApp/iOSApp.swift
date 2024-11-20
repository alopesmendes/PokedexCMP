import SwiftUI
import ComposeApp

@main
struct iOSApp: App {
    init() {
        ModulesKt.initializeKoin()
    }

    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}