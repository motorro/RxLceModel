pluginManagement {
    repositories {
        mavenLocal()
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}
dependencyResolutionManagement {
    repositories {
        mavenLocal()
        google()
        mavenCentral()
    }
    versionCatalogs {
        // declares an additional catalog
        create("androidx") { // Changed from "androidx {" to "create("androidx") {"
            from(files("gradle/libs.versions.toml"))
        }
    }
}

includeBuild("build-logic")

rootProject.name = "RxLceModel"
include(":sample")
include(":rx")
include(":disklrucache")
include(":kserializer")
include(":viewmodel")
include(":composeview")
include(":lce")
include(":utils")
include(":cache")
include(":coroutines")
include(":common")
include(":commonMock")
