object App {
    const val id = "ir.alirezaiyan.poi"
    const val name = "Point Of Interest"
    const val compileSdk = 29
    const val buildTools = "29.0.2"
    const val minSdk = 21
    const val targetSdk = 29
    const val versionCode = 1
    const val versionName = "1.0.0"
}

object Versions {
    const val gradle = "3.5.3"
    const val kotlin = "1.3.10"

    const val appcompat = "1.1.0"
    const val ktx = "1.2.0"
    const val material = "1.1.0"
    const val dagger = "2.26"
    const val daggerAndroid = "2.22.1"
    const val navigation = "1.0.0"
    const val coroutines = "1.3.0"
    const val gson = "2.8.5"
    const val okHttp = "3.4.1"
    const val okHttpInterceptor = "3.8.1"
    const val retrofit = "2.8.1"
    const val constraintlayout = "1.1.3"
    const val picasso = "2.71828"
    const val location = "17.0.0"
    const val room = "2.2.5"

    const val junit = "4.12"
    const val testExt = "1.1.1"
    const val mockito = "3.0.0"
}


object BuildPlugins {
    const val gradle = "com.android.tools.build:gradle:${Versions.gradle}"
    const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
}

object AppPlugins {
    const val androidApp = "com.android.application"
    const val androidLib = "com.android.library"
    const val kotlin = "kotlin-android"
    const val kotlinExt = "kotlin-android-extensions"
    const val kotlinKapt = "kotlin-kapt"
}

object AppModule {
    const val app = ":app"
    const val main = ":main-ui"
    const val detail = ":detail-ui"
    const val uiSdk = ":ui-sdk"
    const val coreSdk = ":core-sdk"
    const val data = ":data"
}

object Deps {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.ktx}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintlayout}"
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    const val daggerAndroidProcessor =
        "com.google.dagger:dagger-android-processor:${Versions.dagger}"
    const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    const val daggerAndroid = "com.google.dagger:dagger-android-support:${Versions.daggerAndroid}"
    const val navigationUI = "android.arch.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val navigationFragment =
        "android.arch.navigation:navigation-fragment-ktx:${Versions.navigation}"

    val gson = "com.google.code.gson:gson:${Versions.gson}"
    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    const val okhttpInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.okHttpInterceptor}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val picasso = "com.squareup.picasso:picasso:${Versions.picasso}"
    val serviceLocation = "com.google.android.gms:play-services-location:${Versions.location}"
    val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
}

object TestDeps {
    const val junit = "junit:junit:${Versions.junit}"
    const val testExt = "androidx.test.ext:junit:${Versions.testExt}"
    const val runner = "androidx.test:runner:1.1.0"
    const val rules = "androidx.test:rules:1.2.0"
    const val coreTesting = "androidx.arch.core:core-testing:2.0.1"
    const val core = "androidx.test:core:1.2.0"
    const val mockitoAndroid = "org.mockito:mockito-android:${Versions.mockito}"
    const val mockitoCore = "org.mockito:mockito-core:${Versions.mockito}"
}
