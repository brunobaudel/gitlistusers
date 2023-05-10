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

    implementation("androidx.core:core-ktx:1.10.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.core:core-ktx:1.10.0")
    testImplementation("junit:junit:4.13.2")
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
    androidTestImplementation(composeBom)

    implementation(Compose.material3)
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

    implementation("com.github.bumptech.glide:compose:1.0.0-alpha.1")
//    implementation("io.coil-kt:coil-compose:2.3.0")
}