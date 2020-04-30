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
}

object Deps {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.ktx}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    const val daggerAndroidProcessor =
        "com.google.dagger:dagger-android-processor:${Versions.dagger}"
    const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    const val daggerAndroid = "com.google.dagger:dagger-android-support:${Versions.daggerAndroid}"
    const val navigationUI = "android.arch.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val navigationFragment =
        "android.arch.navigation:navigation-fragment-ktx:${Versions.navigation}"
}

object TestDeps
