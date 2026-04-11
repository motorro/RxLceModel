/*
 * Copyright 2021 Nikolai Kotchetkov.
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

plugins {
    alias(libs.plugins.rxlcemodel.cmp)
    alias(libs.plugins.kotlin.dokka)
    id("maven-publish")
    id("signing")
}

val versionName: String by project.extra

group = rootProject.group
version = rootProject.version

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                api(project(":lce"))
            }
        }
        androidMain {
            dependencies {
                api(project(":viewmodel"))
                implementation(project.dependencies.platform(libs.androidx.compose.bom))
                implementation(libs.androidx.lifecycle.viewmodel.compose)
            }
        }
        androidHostTest {
            dependencies {
                implementation(libs.mockito.kotlin)
                implementation(libs.androidx.test.core)
                implementation(libs.androidx.compose.ui.test.junit4)
                implementation(libs.androidx.compose.ui.test.manifest)
                implementation(libs.robolectric)
            }
        }
    }
}

val javadocJar by tasks.registering(Jar::class) {
    dependsOn(tasks.dokkaGenerate)
    group = "documentation"
    archiveClassifier.set("javadoc")
    from(tasks.dokkaGenerate)
}

val libId = "composeview"
val libName = "composeview"
val libDesc = "Base composables to use with LCE use-cases"
val projectUrl: String by project.extra
val projectScm: String by project.extra
val ossrhUsername: String? by rootProject.extra
val ossrhPassword: String? by rootProject.extra
val developerId: String by project.extra
val developerName: String by project.extra
val developerEmail: String by project.extra
val signingKey: String? by rootProject.extra
val signingPassword: String? by rootProject.extra

publishing {
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

