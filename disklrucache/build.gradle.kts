@file:OptIn(ExperimentalAbiValidation::class)

import org.jetbrains.kotlin.gradle.dsl.abi.ExperimentalAbiValidation

plugins {
    alias(libs.plugins.rxlcemodel.kmp.jvm)
    alias(libs.plugins.kotlin.dokka)
    id("maven-publish")
    id("signing")
}

val versionName: String by project.extra

group = rootProject.group
version = rootProject.version

kotlin {
    abiValidation {
        enabled = true
    }

    sourceSets {
        commonMain {
            dependencies {
                api(project(":cache"))
                api(project(":utils"))
            }
        }

        commonTest {
            dependencies {
                implementation(project(":commonMock"))
            }
        }

        val commonJvmMain by getting {
            dependencies {
                api(libs.rxjava)
                api(libs.disklrucache)
            }
        }
        val commonJvmTest by getting {
            dependencies {
                implementation(libs.mockito.kotlin)
            }
        }
    }
}

val libId = "disklrucache"
val libName = "disklrucache"
val libDesc = "Jake Wharton's DiskLruCache delegate for RxLceModel"
val projectUrl: String by project.extra
val projectScm: String by project.extra
val ossrhUsername: String? by rootProject.extra
val ossrhPassword: String? by rootProject.extra
val developerId: String by project.extra
val developerName: String by project.extra
val developerEmail: String by project.extra
val signingKey: String? by rootProject.extra
val signingPassword: String? by rootProject.extra

val javadocJar by tasks.registering(Jar::class) {
    dependsOn(tasks.dokkaGenerate)
    group = "documentation"
    archiveClassifier.set("javadoc")
    from(tasks.dokkaGenerate)
}

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