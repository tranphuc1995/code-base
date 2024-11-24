import com.android.build.gradle.internal.api.BaseVariantOutputImpl

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    id("maven-publish")
}

android {
    buildFeatures {
        viewBinding = true
        buildConfig = true
    }



    namespace = "com.phucth.mycodebase"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.phucth.mycodebase"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    flavorDimensions += listOf("environment")
    productFlavors {
        create("dev") {
            dimension = "environment"
            versionCode = 1
            versionName = "1.0"
            applicationId = "com.phucth.dev.mycodebase"
            buildConfigField("String", "BASE_URL", "\"https://api.themoviedb.org\"")
        }
        create("pro") {
            dimension = "environment"
            versionCode = 1
            versionName = "1.0"
            applicationId = "com.phucth.mycodebase"
            buildConfigField("String", "BASE_URL", "\"https://api.themoviedb.org.pro\"")
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    testImplementation(libs.mockito.inline)
    testImplementation(libs.mockito.core)
    testImplementation(libs.androidx.core.testing)
    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.mockk)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.mockito.android)
    androidTestImplementation(libs.mockk.android)

    //retrofit
    implementation(libs.retrofit)
    implementation(libs.moshi.kotlin)
    implementation(libs.converter.moshi)
    implementation(libs.converter.gson)

    //hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)

    //coroutine
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.coroutines.core)

    //viewmodel
    implementation(libs.androidx.lifecycle.viewmodel.ktx)

    //navigation
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.androidx.navigation.dynamic.features.fragment)

    //my library
    implementation(libs.tranphuc.base)
    implementation(libs.tranphuc.component)
}

kapt {
    correctErrorTypes = true
}