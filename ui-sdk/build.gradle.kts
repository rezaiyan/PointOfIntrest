plugins {
    id(AppPlugins.androidLib)
    id(AppPlugins.kotlin)
    id(AppPlugins.kotlinKapt)
    id(AppPlugins.kotlinExt)
}

android {

    compileOptions.sourceCompatibility = JavaVersion.VERSION_1_8
    compileOptions.targetCompatibility = JavaVersion.VERSION_1_8
    compileSdkVersion(App.compileSdk)
    buildToolsVersion(App.buildTools)

    defaultConfig {
        minSdkVersion(App.minSdk)
        targetSdkVersion(App.targetSdk)
        versionName = App.versionName
        versionCode = App.versionCode
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    dataBinding.isEnabled = true
}

dependencies {
    api(Deps.kotlin)
    api(Deps.appcompat)
    api(Deps.material)
    api(Deps.constraintLayout)
    api(Deps.coreKtx)
    api(Deps.daggerAndroid)
    api(Deps.dagger)
    api(Deps.navigationUI)
    api(Deps.navigationFragment)
}
