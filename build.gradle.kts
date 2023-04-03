plugins {
    kotlin("js") version "1.8.0"
    kotlin("plugin.serialization") version "1.8.0"
}

repositories {
    mavenCentral()
}

kotlin {
    js {
        browser {
            commonWebpackConfig {
                cssSupport {
                    enabled.set(true)
                }
            }
        }
        binaries.executable()
    }
}

dependencies {
    //React, React DOM + Wrappers (chapter 3)
    implementation(enforcedPlatform("org.jetbrains.kotlin-wrappers:kotlin-wrappers-bom:1.0.0-pre.528"))
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react:18.2.0-pre.528")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react-dom:18.2.0-pre.528")

    //Kotlin React Emotion (CSS) (chapter 3)
    implementation("org.jetbrains.kotlin-wrappers:kotlin-emotion")

    //Video Player (chapter 7)
    implementation(npm("react-player", "2.10.1"))

    //Share Buttons (chapter 7)
    implementation(npm("react-share", "4.4.1"))

    //Coroutines & serialization (chapter 8)
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.0")
}

// Heroku Deployment (chapter 9)
tasks.register("stage") {
    dependsOn("build")
}

rootProject.extensions.configure<org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension> {
    versions.webpackCli.version = "4.10.0"
}