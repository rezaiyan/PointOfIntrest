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

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation(project(AppModule.main))
    implementation(project(AppModule.detail))
}
