object DefaultsConfig {
    const val applicationId = "com.mobsky.gitlistusers" // can't change once defined
    const val minSdk = 24
    const val targetSdk = 33
    const val versionCode = 1       // must be increased by every playstore upload
    const val versionName =
        "1.0" // you should increase too. Suggested approach (https://semver.org/)
}

object Versions {
    const val koinVersion = "3.2.2"
    const val koinAndroidVersion = "3.3.0"
    const val retrofitVersion = "2.9.0"
    const val gsonVersion = "2.8.9"
    const val loggingInterceptorVersion = "4.2.0"
    const val okhttpVersion = "4.2.0"
}

object Koin {
    const val koin_core = "io.insert-koin:koin-core:${Versions.koinVersion}"
    const val koin_android = "io.insert-koin:koin-android:${Versions.koinAndroidVersion}"
    const val koin_android_compat =
        "io.insert-koin:koin-android-compat:${Versions.koinAndroidVersion}"
    const val koin_androidx_workmanager =
        "io.insert-koin:koin-androidx-workmanager:${Versions.koinAndroidVersion}"
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
    const val logging_interceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptorVersion}"
}

object Okhttp {
    const val okhttp_core = "com.squareup.okhttp3:okhttp:${Versions.okhttpVersion}"
}
