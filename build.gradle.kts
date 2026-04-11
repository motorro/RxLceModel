import groovy.lang.Closure
import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.multiplatform) apply false
    alias(libs.plugins.android.kotlin.multiplatform.library) apply false
    alias(libs.plugins.compose.multiplatform) apply false
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.kotlin.dokka) apply false
    alias(libs.plugins.google.ksp) apply false
    alias(libs.plugins.hilt) apply false
    alias(libs.plugins.nexus.publish)
    alias(libs.plugins.grgit)
}

apply {
    from("$rootDir/gradle/versioning.gradle")
    from("$rootDir/gradle/maven-publish-config.gradle")
}

private val buildVersionName: Closure<Any> by ext
private val buildVersionCode: Closure<Any> by ext

version = buildVersionName()
group = "com.motorro.rxlcemodel"
description = "A reactive data loading for Android based on RxJava and `Loading`/`Content`/`Error` states."


allprojects {
    val versionName by extra(buildVersionName())
    val versionCode by extra(buildVersionCode())

    val androidBuildToolsVersion by extra("35.0.0")
    val androidMinSdkVersion by extra(24)
    val androidTargetSdkVersion by extra(36)
    val androidCompileSdkVersion by extra(36)

    val developerId by extra("motorro")
    val developerName by extra("Nikolai Kotchetkov")
    val developerEmail by extra("motorro@gmail.com")

    val projectScm by extra("https://github.com/motorro/CommonStateMachine.git")
    val projectUrl by extra("https://github.com/motorro/CommonStateMachine")

    val docDir by extra("${projectDir}/docs")

    tasks.withType<KotlinCompile>().configureEach {
        compilerOptions {
            freeCompilerArgs.addAll(listOf(
                "-opt-in=kotlin.RequiresOptIn",
                "-Xexpect-actual-classes"
            ))
        }
    }

    tasks.withType<Test>().configureEach {
        forkEvery = 100
        testLogging {
            events("skipped", "failed")
            showExceptions = true
            exceptionFormat = TestExceptionFormat.FULL
            showCauses = true
            showStackTraces = true

            // set options for log level DEBUG and INFO
            debug {
                events("started", "passed", "skipped", "failed", "standardOut", "standardError")
                exceptionFormat = TestExceptionFormat.FULL
            }
            info.events = debug.events
            info.exceptionFormat = debug.exceptionFormat
        }
    }
}

tasks.register("runLceUnitTests") {
    dependsOn(":lce:check")
    group = "verification"
    description = "Run unit tests for Lce library."
}

tasks.register("runCacheUnitTests") {
    dependsOn(":cache:check")
    group = "verification"
    description = "Run unit tests for Cache library."
}

tasks.register("runRxUnitTests") {
    dependsOn(":rx:check")
    group = "verification"
    description = "Run unit tests for Rx library."
}

tasks.register("runCoroutinesUnitTests") {
    dependsOn(":coroutines:check")
    group = "verification"
    description = "Run unit tests for Rx library."
}

tasks.register("runDiskLruUnitTests") {
    dependsOn(":disklrucache:check")
    group = "verification"
    description = "Run unit tests for DiskLruCache library."
}

tasks.register("runKserializerUnitTests") {
    dependsOn(":kserializer:check")
    group = "verification"
    description = "Run unit tests for KSerializer library."
}

tasks.register("runViewmodelUnitTests") {
    dependsOn(":viewmodel:testDebugUnitTest")
    group = "verification"
    description = "Run unit tests for ViewModel library."
}

tasks.register("runComposeViewUnitTests") {
    dependsOn(":composeview:check")
    group = "verification"
    description = "Run unit tests for Compose-view library."
}

tasks.register("runSampleUnitTests") {
    dependsOn(":sample:check")
    group = "verification"
    description = "Run unit tests for Sample application."
}

tasks.register("runUnitTests") {
    dependsOn(
        "runLceUnitTests",
        "runCacheUnitTests",
        "runRxUnitTests",
        "runCoroutinesUnitTests",
        "runDiskLruUnitTests",
        "runKserializerUnitTests",
        "runViewmodelUnitTests",
        "runComposeViewUnitTests",
        "runSampleUnitTests"
    )
    group = "verification"
    description = "Run unit tests for libraries."
}

tasks.register("displayVersion") {
    description = "Display application version name"
    doLast {
        println("Project version: ${project.version}")
    }
}

val ossrhUsername: String? by extra
val ossrhPassword: String? by extra

nexusPublishing {
    repositories {
        sonatype {
            nexusUrl.set(uri("https://ossrh-staging-api.central.sonatype.com/service/local/"))
            snapshotRepositoryUrl.set(uri("https://central.sonatype.com/repository/maven-snapshots/"))
            username.set(ossrhUsername)
            password.set(ossrhPassword)
        }
    }
}
