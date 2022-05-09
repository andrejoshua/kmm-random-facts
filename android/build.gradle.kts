plugins {
    id("com.android.application")
    kotlin("android")
}

group = "com.andre.apps.randomfacts"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":common"))
    implementation("androidx.activity:activity-compose:1.4.0")
    implementation("androidx.compose.runtime:runtime:1.1.1")
    implementation("androidx.compose.foundation:foundation:1.1.1")
    implementation("androidx.compose.material:material:1.1.1")
    implementation("androidx.compose.compiler:compiler:1.1.1")

    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.4.1")
    implementation("androidx.lifecycle:lifecycle-process:2.4.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.4.1")

    // Koin main features for Android
    implementation("io.insert-koin:koin-android:3.1.6")
}

android {
    compileSdk = 31
    defaultConfig {
        applicationId = "com.andre.apps.randomfacts.android"
        minSdk = 26
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerVersion = "1.6.10"
        kotlinCompilerExtensionVersion = "1.1.1"
    }
}