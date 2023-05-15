object DefaultsConfig {
    const val applicationId = "com.mobsky.gitlistusers"
    const val minSdk = 24
    const val targetSdk = 33
    const val versionCode = 1
    const val versionName = "1.0"
    const val kotlinCompilerExtensionVersion = "1.4.2"
    const val jvmTargetVersion = "17"
}

object Versions {
    const val koinVersion = "3.2.2"
    const val koinAndroidVersion = "3.3.0"
    const val koinAndroidComposeVersion = "3.4.4"
    const val retrofitVersion = "2.9.0"
    const val gsonVersion = "2.8.9"
    const val loggingInterceptorVersion = "4.2.0"
    const val okhttpVersion = "4.2.0"
    const val coroutinesCoreVersion = "1.6.4"
    const val coroutinesTestingVersion = "1.6.4"
    const val composeBomVersion = "2023.01.00"
    const val composeNavigationVersion = "2.5.3"
    const val composeViewModelVersion = "2.5.1"
    const val composeActivityVersion = "1.6.1"
    const val androidXCoreKtxVersion = "1.10.1"
    const val androidXAppCompatVersion = "1.6.1"
    const val androidMaterialVersion = "1.9.0"
    const val glideComposeVersion = "1.0.0-alpha.3"
}

object Koin {
    const val koinCore = "io.insert-koin:koin-core:${Versions.koinVersion}"
    const val koinAndroid = "io.insert-koin:koin-android:${Versions.koinAndroidVersion}"
    const val koinAndroidCompat =
        "io.insert-koin:koin-android-compat:${Versions.koinAndroidVersion}"
    const val koinAndroidxWorkmanager =
        "io.insert-koin:koin-androidx-workmanager:${Versions.koinAndroidVersion}"
    const val koinAndroidxCompose =
        "io.insert-koin:koin-androidx-compose:${Versions.koinAndroidComposeVersion}"
}

object Retrofit {
    const val retrofitGsonConverter =
        "com.squareup.retrofit2:converter-gson:${Versions.retrofitVersion}"
    const val retrofitCore = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
}

object Gson {
    const val gsonCore = "com.google.code.gson:gson:${Versions.gsonVersion}"
}

object Interceptor {
    const val loggingInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptorVersion}"
}

object Okhttp {
    const val okhttpCore = "com.squareup.okhttp3:okhttp:${Versions.okhttpVersion}"
}

object kotlinxCoroutines {
    const val coroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesCoreVersion}"
    const val coroutinesTest =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutinesTestingVersion}"
}

object Compose {
    const val bom = "androidx.compose:compose-bom:${Versions.composeBomVersion}"
    const val material3 = "androidx.compose.material3:material3"
    const val material = "androidx.compose.material:material"
    const val foundation = "androidx.compose.foundation:foundation"
    const val ui = "androidx.compose.ui:ui"
    const val uiUtil = "androidx.compose.ui:ui-util"
    const val preview = "androidx.compose.ui:ui-tooling-preview"
    const val tooling = "androidx.compose.ui:ui-tooling"
    const val iconsCore = "androidx.compose.material:material-icons-core"
    const val windowSizeClass = "androidx.compose.material3:material3-window-size-class"
    const val activityCompose = "androidx.activity:activity-compose:${Versions.composeActivityVersion}"
    const val viewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.composeViewModelVersion}"
    const val livedataCompose = "androidx.compose.runtime:runtime-livedata"
    const val navigationCompose =
        "androidx.navigation:navigation-compose:${Versions.composeNavigationVersion}"
}

object AndroidX {
    const val coreKtx = "androidx.core:core-ktx:${Versions.androidXCoreKtxVersion}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.androidXAppCompatVersion}"
}

object Android{
    const val material = "com.google.android.material:material:${Versions.androidMaterialVersion}"
}

object Glide{
    const val glideCompose = "com.github.bumptech.glide:compose:${Versions.glideComposeVersion}"
}
