plugins {
    `kotlin-dsl`
}

group = "com.motorro.rxlcemodel.gradle.convention"

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.compose.gradlePlugin)
}

tasks {
    validatePlugins {
        enableStricterValidation = true
        failOnWarning = true
    }
}

gradlePlugin {
    plugins {
        register("kotlinMultiplatformJvm") {
            id = "rxlcemodel.kmp.jvm"
            implementationClass = "KmpJvmConventionPlugin"
        }
        register("kotlinMultiplatform") {
            id = "rxlcemodel.kmp"
            implementationClass = "KmpConventionPlugin"
        }
        register("composeMultiplatform") {
            id = "rxlcemodel.cmp"
            implementationClass = "CmpConventionPlugin"
        }
    }
}