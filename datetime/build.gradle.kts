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
        all {
            languageSettings {
                optIn("kotlin.RequiresOptIn")
            }
        }
        val commonMain by getting {
            dependencies {
                api(kotlin("stdlib-common"))
                api(project(":core"))
                api(compose.ui)
                api(compose.foundation)
                api(compose.material)
                api(compose.materialIconsExtended)
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
                implementation(Dependencies.Accompanist.pagerJvm)
            }
        }
        val jvmTest by getting {
            kotlin.srcDir("src/desktopTest/kotlin")
        }

        val androidMain by getting {
            kotlin.srcDir("src/jvmMain/kotlin")
            dependencies {
                api(kotlin("stdlib-jdk8"))
                implementation(Dependencies.Accompanist.pager)
            }
        }
        val androidTest by getting {
            kotlin.srcDir("src/jvmTest/kotlin")
        }
    }
}

android {
    compileOptions {
        isCoreLibraryDesugaringEnabled = true
    }

    dependencies {
        add("coreLibraryDesugaring", Dependencies.desugar)
    }
}
