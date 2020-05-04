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

}

dependencies {
    api(Deps.kotlin)
    api(Deps.dagger)
    kapt(Deps.daggerCompiler)
    implementation(Deps.retrofit)
    implementation(Deps.retrofitGson)
    implementation(Deps.okhttp)
    implementation(Deps.okhttpInterceptor)
    implementation(Deps.gson)
    api(project(AppModule.coreSdk))
    implementation(Deps.roomRuntime)
    kapt(Deps.roomCompiler)

    testImplementation(TestDeps.junit)
    testImplementation(TestDeps.mockitoCore)

}
