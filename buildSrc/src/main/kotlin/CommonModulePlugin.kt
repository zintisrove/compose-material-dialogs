import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.dsl.DependencyHandler

class CommonModulePlugin: Plugin<Project> {
    override fun apply(project: Project) {
        with(project) {
            applyPlugins()
        }
    }

    private fun Project.applyPlugins() {
        plugins.run {
            apply("com.android.library")
            apply("kotlin-multiplatform")
            apply("com.vanniktech.maven.publish")
            apply("shot")
            apply("org.jetbrains.dokka")
            apply("org.jetbrains.compose")
        }
    }

    private fun DependencyHandler.androidDeps(project: Project) {
        implementation(Dependencies.AndroidX.coreKtx)

        androidTestImplementation(Dependencies.AndroidX.Compose.activity)
        androidTestImplementation(Dependencies.AndroidX.Compose.testing)
        androidTestImplementation(Dependencies.AndroidX.Testing.core)
        androidTestImplementation(Dependencies.AndroidX.Testing.rules)
        androidTestImplementation(Dependencies.AndroidX.Testing.runner)
        add("androidTestImplementation", project.project(":test-utils"))

    }

    private fun DependencyHandler.implementation(dependency: String) {
        add("implementation", dependency)
    }

    private fun DependencyHandler.androidTestImplementation(dependency: String) {
        add("androidTestImplementation", dependency)
    }
}