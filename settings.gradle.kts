pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        google()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

rootProject.name = "compose-material-dialogs"
include(":core")
include(":color")
include(":datetime")
include(":test-utils")
include(":app")
include(":desktop")
