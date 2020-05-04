plugins {
    id(AppPlugins.androidApp)
    id(AppPlugins.kotlin)
    id(AppPlugins.kotlinExt)
    id(AppPlugins.kotlinKapt)
}

android {

    compileOptions.sourceCompatibility = JavaVersion.VERSION_1_8
    compileOptions.targetCompatibility = JavaVersion.VERSION_1_8
    compileSdkVersion(App.compileSdk)
    buildToolsVersion(App.buildTools)

    defaultConfig {
        applicationId = App.id
        minSdkVersion(App.minSdk)
        targetSdkVersion(App.targetSdk)
        versionName = App.versionName
        versionCode = App.versionCode
        vectorDrawables.useSupportLibrary = true
    }

    signingConfigs {
        create("release") {
            storeFile = rootProject.file((project.property("ANDROID_KEYSTORE_DIR") as String?)!!)
            storePassword = project.property("ANDROID_KEYSTORE_PASSWORD") as String?
            keyAlias = project.property("ANDROID_KEYSTORE_ALIAS") as String?
            keyPassword = project.property("ANDROID_KEYSTORE_PRIVATE_KEY_PASSWORD") as String?
        }
    }

    buildTypes {
        getByName("release") {
            signingConfig = signingConfigs.getByName("release")
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
    implementation(Deps.kotlin)
    implementation(project(AppModule.uiSdk))
    implementation(project(AppModule.main))
    implementation(project(AppModule.detail))
    kapt(Deps.daggerAndroidProcessor)
    kapt(Deps.daggerCompiler)
}
