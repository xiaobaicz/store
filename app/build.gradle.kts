plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "io.github.xiaobaicz.store.demo"
    compileSdk = 34

    defaultConfig {
        applicationId = "io.github.xiaobaicz.store.demo"
        minSdk = 23
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        signingConfig = signingConfigs["debug"]
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)

    implementation(libs.auto.service.annotations)
    kapt(libs.auto.service)

    implementation(libs.initializer)

    implementation(project(path = ":store-mmkv"))
}