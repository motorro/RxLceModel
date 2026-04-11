import com.motorro.rxlcemodel.gradle.convention.configureAndroidLibrary
import com.motorro.rxlcemodel.gradle.convention.defaultNamespace
import com.motorro.rxlcemodel.gradle.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.getting
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class KmpJvmConventionPlugin : Plugin<Project> {

    override fun apply(targetProject: Project) = with(targetProject) {
        // Core KMP plugins
        pluginManager.apply(libs.findPlugin("kotlin-multiplatform").get().get().pluginId)
        pluginManager.apply(libs.findPlugin("android-kotlin-multiplatform-library").get().get().pluginId)

        extensions.configure<KotlinMultiplatformExtension> {
            jvmToolchain(21)

            compilerOptions {
                jvm {
                    compilerOptions.jvmTarget.set(JvmTarget.JVM_21)
                }
            }

            jvm()

            // Android KMP Library extension defaults
            configureAndroidLibrary(
                namespace = defaultNamespace(),
                compileSdk = libs.findVersion("android-compileSdk").get().requiredVersion.toInt(),
                minSdk = libs.findVersion("android-minSdk").get().requiredVersion.toInt(),
                enableAndroidResources = false
            )

            applyDefaultHierarchyTemplate()

            sourceSets.apply {
                commonMain {
                    dependencies {

                    }
                }

                commonTest {
                    dependencies {
                        implementation(libs.findLibrary("kotlin-test").get())
                    }
                }

                val commonJvmMain = create("commonJvmMain") {
                    dependsOn(commonMain.get())
                }

                val commonJvmTest = create("commonJvmTest") {
                    dependsOn(commonTest.get())
                }

                androidMain {
                    dependsOn(commonJvmMain)
                }

                val withHostTest = getting {
                    dependsOn(commonJvmTest)
                }

                jvmMain {
                    dependsOn(commonJvmMain)
                }

                jvmTest {
                    dependsOn(commonJvmTest)
                }
            }
        }
    }
}
