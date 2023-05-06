plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {

    implementation(Koin.koinCore)
    implementation(Retrofit.retrofitCore)
    implementation(Retrofit.retrofitGsonConverter)
    implementation(Gson.gsonCore)
    implementation(Okhttp.okhttpCore)
    implementation(Interceptor.loggingInterceptor)
    implementation(kotlinxCoroutines.coroutinesCore)

}