import com.motorro.rxlcemodel.gradle.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.getValue
import org.jetbrains.compose.ComposeExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class CmpConventionPlugin : Plugin<Project> {

    override fun apply(targetProject: Project) = with(targetProject) {
        // First base KMP convention.
        pluginManager.apply("rxlcemodel.kmp")

        // Then Compose side.
        pluginManager.apply(libs.findPlugin("compose-multiplatform").get().get().pluginId)
        pluginManager.apply(libs.findPlugin("kotlin-compose").get().get().pluginId)

        extensions.configure<KotlinMultiplatformExtension> {
            sourceSets.apply {
                commonMain.dependencies {
                    implementation(libs.findLibrary("compose-multiplatform-runtime").get())
                    implementation(libs.findLibrary("compose-multiplatform-ui").get())
                    implementation(libs.findLibrary("compose-multiplatform-foundation").get())
                    implementation(libs.findLibrary("compose-multiplatform-material3").get())

                    // KMP resources (Res.drawable.*)
                    implementation(libs.findLibrary("compose-multiplatform-components-resources").get())

                    // Enable KMP @Preview for @Compose functions.
                    implementation(libs.findLibrary("compose-multiplatform-uiToolingPreview").get())
                }
                jvmMain.dependencies {
                    val compose: ComposeExtension by project.extensions
                    implementation(  compose.dependencies.desktop.currentOs)
                }

                // Preview / tooling for only Android.
                androidMain.dependencies {
                    implementation(libs.findLibrary("androidx-compose-ui-tooling").get())
                }
            }
        }
    }
}