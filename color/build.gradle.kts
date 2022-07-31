plugins {
    id("common-library")
}


kotlin {
    android {
        publishAllLibraryVariants()
        compilations {
            all {
                kotlinOptions.jvmTarget = "1.8"
            }
        }
    }
    jvm {
        compilations {
            all {
                kotlinOptions.jvmTarget = "11"
            }
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(kotlin("stdlib-common"))
                api(project(":core"))
                api(compose.ui)
                api(compose.foundation)
                api(compose.material)
                api(compose.animation)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val jvmMain by getting {
            kotlin.srcDir("src/desktopMain/kotlin")
            dependencies {
                api(kotlin("stdlib-jdk8"))
            }
        }
        val jvmTest by getting {
            kotlin.srcDir("src/desktopTest/kotlin")
        }

        val androidMain by getting {
            kotlin.srcDir("src/jvmMain/kotlin")
            dependencies {
                api(kotlin("stdlib-jdk8"))
                api(Dependencies.AndroidX.Compose.ui)
                api(Dependencies.AndroidX.Compose.foundation)
                api(Dependencies.AndroidX.Compose.material)
                api(Dependencies.AndroidX.Compose.animation)
            }
        }
        val androidTest by getting {
            kotlin.srcDir("src/jvmTest/kotlin")
        }
    }
}

shot {
    tolerance = 1.0 // Tolerance needed for CI
}
