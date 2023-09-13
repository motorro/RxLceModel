/*
 * Copyright 2022 Nikolai Kotchetkov.
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
import java.net.URI

plugins {
    id("org.jetbrains.kotlin.multiplatform")
    id("org.jetbrains.dokka")
    id("maven-publish")
    id("signing")
}

val versionName: String by project.extra

group = rootProject.group
version = rootProject.version

@Suppress("UNCHECKED_CAST")
val versions: Map<String, String> = rootProject.extra["commonLibVersions"] as Map<String, String>

kotlin {

    jvm {
        compilations.all {
            kotlinOptions {
                kotlinOptions.jvmTarget = "17"
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
        val commonMain by getting {
            dependencies {
                implementation(project(":utils"))
            }
        }
        val commonTest by getting {
            dependencies {
                implementation("org.jetbrains.kotlin:kotlin-test:${rootProject.extra["kotlin_version"]}")
            }
        }
        val jvmMain by getting
        val jvmTest by getting {
            dependencies {
                implementation("junit:junit:${versions["junit"]}")
                implementation("com.nhaarman.mockitokotlin2:mockito-kotlin:${versions["mockito_kotlin"]}")
            }
        }
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

val libId = "lce"
val libName = "lce"
val libDesc = "Load/Content/Error state for data-sources"
val projectUrl: String by rootProject.extra
val projectScm: String by rootProject.extra
val ossrhUsername: String? by rootProject.extra
val ossrhPassword: String? by rootProject.extra
val developerId: String by rootProject.extra
val developerName: String by rootProject.extra
val developerEmail: String by rootProject.extra
val signingKey: String? by rootProject.extra
val signingPassword: String? by rootProject.extra

publishing {
    repositories {
        maven {
            name = "sonatype"
            url = URI("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
            credentials {
                username = ossrhUsername
                password = ossrhPassword
            }
        }
    }
    publications.withType<MavenPublication> {
        artifact(javadocJar)
        pom {
            name.set(libName)
            description.set(libDesc)
            url.set(projectUrl)
            licenses {
                license {
                    name.set("Apache-2.0")
                    url.set("https://apache.org/licenses/LICENSE-2.0")
                }
            }
            developers {
                developer {
                    id.set(developerId)
                    name.set(developerName)
                    email.set(developerEmail)
                }
            }
            scm {
                connection.set(projectScm)
                developerConnection.set(projectScm)
                url.set(projectUrl)
            }
        }
    }
}

signing {
    useInMemoryPgpKeys(signingKey, signingPassword)
    sign(publishing.publications)
}

val signingTasks = tasks.withType<Sign>()
tasks.withType<AbstractPublishToMaven>().configureEach {
    dependsOn(signingTasks)
}