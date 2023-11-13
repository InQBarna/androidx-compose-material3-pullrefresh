@file:Suppress("UnstableApiUsage")

import java.util.Properties

val localProperties: Properties = Properties().apply {
    val file = rootProject.file("local.properties")
    if (!file.exists()) file.createNewFile()
    load(file.inputStream())
}

fun localProperty(key: String): String =
    localProperties[key] as? String
        ?: error("Property [$key] not found in ${file("local.properties").absolutePath}.")

plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    namespace = "me.omico.compose.material3.pullrefresh"
    compileSdk = 34
    defaultConfig {
        minSdk = 21
    }
    buildFeatures {
        compose = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }
}

dependencies {
    compileOnly(platform("androidx.compose:compose-bom:2023.10.01"))
    compileOnly("androidx.compose.foundation:foundation")
    compileOnly("androidx.compose.material3:material3")
    compileOnly("androidx.compose.ui:ui")
}
