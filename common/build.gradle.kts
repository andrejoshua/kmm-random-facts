import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework

plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("kotlinx-serialization")
    id("com.android.library")
}

group = "com.andre.apps.randomfacts"
version = "1.0"

kotlin {
    android()
    jvm("desktop") {
        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }
    }

    val xcf = XCFramework()
    iosX64 {
        binaries {
            framework {
                baseName = "common"
                xcf.add(this)
            }
        }
    }
    iosArm64 {
        binaries {
            framework {
                baseName = "common"
                xcf.add(this)
            }
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("io.insert-koin:koin-core:3.1.6")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")
                implementation("io.ktor:ktor-client-core:1.6.2")
                implementation("io.ktor:ktor-client-logging:1.6.2")
                implementation("io.ktor:ktor-client-serialization:1.6.2")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-okhttp:1.6.2")
            }
        }
        val androidTest by getting {
            dependencies {
                implementation("junit:junit:4.13.2")
            }
        }
        val desktopMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-apache:1.6.2")
            }
        }
        val desktopTest by getting
        val iosX64Main by getting
        val iosX64Test by getting
        val iosArm64Main by getting
        val iosArm64Test by getting

        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            dependencies {
                implementation("io.ktor:ktor-client-ios:1.6.2")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-native:1.3.8")
            }
        }
    }
}

android {
    compileSdkVersion(31)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdkVersion(24)
        targetSdkVersion(31)
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}