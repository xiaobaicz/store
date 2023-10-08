plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "vip.oicp.xiaobaicz.lib.store.demo"
    compileSdk = 34

    defaultConfig {
        applicationId = "vip.oicp.xiaobaicz.lib.store.demo"
        minSdk = 23
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
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

    implementation(libs.mmkv)

//    implementation(libs.store)
//    implementation(libs.store.mem)
//    implementation(libs.store.mmkv)
//    implementation(libs.store.sp)
//    implementation(libs.store.serialize.gson)
    implementation(project(path = ":store"))
    implementation(project(path = ":store-mem"))
    implementation(project(path = ":store-mmkv"))
    implementation(project(path = ":store-sp"))
    implementation(project(path = ":store-serialize-gson"))
}