/*
 * Copyright 2023 Nikolai Kotchetkov.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

@file:Suppress("UNUSED_VARIABLE", "DSL_SCOPE_VIOLATION")

import org.jetbrains.dokka.gradle.DokkaTask

plugins {
    id("org.jetbrains.kotlin.multiplatform")
    id("org.jetbrains.dokka")
}

val versionName: String by project.extra

group = rootProject.group
version = rootProject.version

kotlin {

    jvm {
        compilations.all {
            kotlinOptions {
                kotlinOptions.jvmTarget = "1.8"
                freeCompilerArgs = freeCompilerArgs + listOf(
                    "-opt-in=kotlin.RequiresOptIn",
                    "-module-name", "rxlcemodel-${project.name}"
                )
            }
        }
        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
        }
    }

    js(IR) {
        compilations.all {
            kotlinOptions.freeCompilerArgs += listOf(
                "-opt-in=kotlin.RequiresOptIn",
                "-Xopt-in=kotlin.js.ExperimentalJsExport"
            )
        }
        binaries.library()
        useCommonJs()
        browser {
            testTask {
                useMocha {
                    timeout = "10s"
                }
            }
        }
    }

    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation("org.jetbrains.kotlin:kotlin-test:${rootProject.extra["kotlin_version"]}")
            }
        }
        val jvmMain by getting
        val jvmTest by getting
        val jsMain by getting
        val jsTest by getting
    }
}

val dokkaHtml by tasks.getting(DokkaTask::class)

val javadocJar by tasks.creating(Jar::class) {
    dependsOn(dokkaHtml)
    group = "documentation"
    archiveClassifier.set("javadoc")
    from(tasks.dokkaHtml)
}
