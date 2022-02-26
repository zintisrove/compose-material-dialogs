plugins {
    kotlin("jvm")
    id("org.jetbrains.compose")
}

dependencies {
    implementation(compose.desktop.currentOs)

    implementation(project(":core"))
    implementation(project(":datetime"))
    implementation(project(":color"))

    /*implementation(Dependencies.ComposeMaterialDialogs.core)
    implementation(Dependencies.ComposeMaterialDialogs.datetime)
    implementation(Dependencies.ComposeMaterialDialogs.color)*/

    implementation("cafe.adriel.voyager:voyager-navigator:1.0.0-beta16")
}

compose.desktop {
    application {
        mainClass = "com.vanpra.composematerialdialogdemos.MainKt"
    }
}