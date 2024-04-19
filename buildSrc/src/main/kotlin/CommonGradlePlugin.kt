import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.project

class CommonGradlePlugin : Plugin<Project> {
    override fun apply(project: Project) {
        setProjectConfig(project)
        setDependencies(project)
    }

    private fun setProjectConfig(project: Project) {
        project.android().apply {
            compileSdk = ProjectProperties.COMPILE_SDK

            defaultConfig {
                minSdk = ProjectProperties.MIN_SDK
                testInstrumentationRunner = "androidx.test.runner.AndroidJunitRunner"
                consumerProguardFiles("consumer-rules.pro")
            }

            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_18
                targetCompatibility = JavaVersion.VERSION_18
            }
        }
    }

    private fun setDependencies(project: Project) {
        val libs = project.libs
        project.dependencies {
            implementation(libs.findLibrary("androidx.core.ktx").get())
            androidTestImplementation(libs.findLibrary("androidx.junit").get())
            testImplementation(libs.findLibrary("junit").get())
        }
    }
}
