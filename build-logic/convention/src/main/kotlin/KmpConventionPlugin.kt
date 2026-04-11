import com.motorro.rxlcemodel.gradle.convention.frameworkBaseName
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class KmpConventionPlugin : Plugin<Project> {

    @OptIn(ExperimentalWasmDsl::class)
    override fun apply(targetProject: Project) = with(targetProject) {
        // First base KMP JVM convention.
        pluginManager.apply("rxlcemodel.kmp.jvm")

        extensions.configure<KotlinMultiplatformExtension> {
            // iOS targets
            listOf(
                iosX64(),
                iosArm64(),
                iosSimulatorArm64()
            ).forEach {
                it.binaries.framework {
                    baseName = project.frameworkBaseName()
                    isStatic = true
                }
            }

            // JS targets
            js {
                outputModuleName.set(project.frameworkBaseName())
                browser()
                binaries.library()
                generateTypeScriptDefinitions()
                compilerOptions {
                    target.set("es2015")
                }
            }

            wasmJs {
                binaries.library()
                useCommonJs()
                browser {

                }
            }
        }
    }
}
