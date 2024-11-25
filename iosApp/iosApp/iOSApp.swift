import SwiftUI
import ComposeApp

@main
struct iOSApp: App {
    init() {
        ModulesKt.initializeKoin()
        NapierProxyKt.debugBuild()
    }

    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}