@file:Suppress("UnstableApiUsage")

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    kotlin("kapt")
}

android {
    namespace = AppConfig.applicationId
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        applicationId = AppConfig.applicationId
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.compileSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName
    }

    signingConfigs {
        create("release") {
            storeFile = file(AppConfig.keyStoreCertificateFilePath)
            storePassword = AppConfig.keyStorePassword
            keyAlias = AppConfig.keyAlias
            keyPassword = AppConfig.keyPasword
        }
    }

    buildTypes {
        getByName("debug") {
            isDebuggable = true
            isMinifyEnabled = false
        }
        getByName("release") {
            isDebuggable = false
            isMinifyEnabled = false
            isShrinkResources = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("release")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.2"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    /* Core related */
    implementation(AppDependencies.core)

    /* LifeCycle related */
    implementation(AppDependencies.lifecycle)

    /* Compose related */
    val composeBom = platform(AppDependencies.composeBom)
    implementation(composeBom)
    androidTestImplementation(composeBom)
    // Compose with material-3
    implementation(AppDependencies.composeWithMaterial)
    // Compose - Integration with liveData
    implementation(AppDependencies.composeWithLiveData)
    // Compose - Integration with activity
    implementation(AppDependencies.composeWithActivity)
    // Android Studio Preview support for compose
    implementation(AppDependencies.androidStudioPreview)
    debugImplementation(AppDependencies.androidStudioPreviewTool)

    /* Hilt related */
    implementation(AppDependencies.hilt)
    kapt(AppDependencies.hiltCompile)

    /* Retrofit related */
    implementation(AppDependencies.retrofit)
    implementation(AppDependencies.retrofitConvertor)

    /* Logging Interceptor related */
    implementation(AppDependencies.loggingInterceptor)

    /* Co-routine related */
    implementation(AppDependencies.coroutine)

    /* Room related */
    implementation(AppDependencies.room)
    // To use Kotlin annotation processing tool (kapt)
    kapt(AppDependencies.roomAnnotation)
    // optional - Kotlin Extensions and Coroutines support for Room
    implementation(AppDependencies.roomWithCoroutine)

    /* Glide related */
    implementation(AppDependencies.glide)
    kapt(AppDependencies.glideAnnotation)

    /* Testing related */
    testImplementation(AppDependencies.testLibraries)
    androidTestImplementation(AppDependencies.androidTestLibraries)
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}