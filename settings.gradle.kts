pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        google()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

rootProject.name = "compose-material-dialogs"
include(":compose-material-dialogs-core")
include(":compose-material-dialogs-color")
include(":compose-material-dialogs-datetime")
include(":test-utils")
include(":app:common")
include(":app:android")
include(":app:desktop")
include(":app:ios")

project(":compose-material-dialogs-core").projectDir = file("core")
project(":compose-material-dialogs-color").projectDir = file("color")
project(":compose-material-dialogs-datetime").projectDir = file("datetime")

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")