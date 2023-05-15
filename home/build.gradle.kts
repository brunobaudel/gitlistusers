plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.mobsky.home"
    compileSdk = 33

    defaultConfig {
        minSdk = DefaultsConfig.minSdk

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

        debug {
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildFeatures {
        compose = true
        buildConfig = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = DefaultsConfig.kotlinCompilerExtensionVersion
    }

    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    implementation(project(mapOf("path" to ":navigation")))
    implementation(project(mapOf("path" to ":network")))

    implementation(AndroidX.coreKtx)
    implementation(AndroidX.appCompat)
    implementation(Android.material)

    testImplementation("junit:junit:4.13.2")
    testImplementation("org.mockito:mockito-core:4.5.1")
    testImplementation("androidx.test:core:1.5.0")

    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation(Koin.koinAndroid)
    implementation(Koin.koinAndroidCompat)
    implementation(Koin.koinAndroidxWorkmanager)
    implementation(Koin.koinAndroidxCompose)

    implementation(Retrofit.retrofitCore)

    implementation(Gson.gsonCore)

    //Compose
    val composeBom = platform(Compose.bom)
    implementation(composeBom)
//    androidTestImplementation(composeBom)

    implementation(Compose.material3)
    implementation(Compose.material)
    implementation(Compose.foundation)
    implementation(Compose.ui)
    implementation(Compose.uiUtil)
    implementation(Compose.preview)
    debugImplementation(Compose.tooling)
    implementation(Compose.iconsCore)
    implementation(Compose.windowSizeClass)
    // Integration with activities
    implementation(Compose.activityCompose)
    // Integration with ViewModels
    implementation(Compose.viewModelCompose)
    // Integration with LiveData
    implementation(Compose.livedataCompose)
    // Navigation
    implementation(Compose.navigationCompose)

    implementation(Glide.glideCompose)
}