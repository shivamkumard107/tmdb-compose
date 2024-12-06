plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.jetbrains.kotlin.kapt)
    alias(libs.plugins.dagger.hilt)
    alias(libs.plugins.jetbrains.kotlin.serialization)
    alias(libs.plugins.jetbrains.kotlin.parcelize)
}

android {
    namespace = "com.dev.sk.compose"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.dev.sk.compose"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        debug {
            buildConfigField("String", "API_KEY", "\"eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI0NGE2YTIxZGEwZTIyN2Y3YzRmMzdlZGE0ZWM4ZDc3MCIsIm5iZiI6MTYyMDU0NzUxOS41MDIsInN1YiI6IjYwOTc5N2JmNWVkOGU5MDAzZGQ2ZjZkYyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.4oUO_gMWsF2WOlD0HfvzY87TYf2g7H4kQW8aepQ56zk\"")
        }
        release {
            isMinifyEnabled = false
            buildConfigField("String", "API_KEY", "\"eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI0NGE2YTIxZGEwZTIyN2Y3YzRmMzdlZGE0ZWM4ZDc3MCIsIm5iZiI6MTYyMDU0NzUxOS41MDIsInN1YiI6IjYwOTc5N2JmNWVkOGU5MDAzZGQ2ZjZkYyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.4oUO_gMWsF2WOlD0HfvzY87TYf2g7H4kQW8aepQ56zk\"")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.fragment.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)


    // retrofit
    implementation(libs.retrofit)
    implementation(libs.gson)
    implementation(libs.retrofit.kotlinx.serializer)

    //Serialization
    implementation(libs.kotlin.serialization.json)

    // glide
    implementation(libs.glide)
    annotationProcessor(libs.compiler)

    // okhttp
    implementation(libs.okhttp)
    implementation(libs.logging.interceptor)

    // room
    implementation(libs.room.runtime)
    kapt(libs.room.compiler)
    implementation(libs.room.ktx)

    // hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)

    // testing
    testImplementation(libs.android.test.core)
    testImplementation(libs.kotlin.coroutines.test)
    testImplementation(libs.google.truth.test)
    testImplementation(libs.okhttp.mock.web.server)
    testImplementation(libs.mockk)
    testImplementation(libs.junit)
    testImplementation(libs.mockito.core)
    testImplementation(libs.mockito.kotlin)
    testImplementation(libs.turbine)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

}

kapt {
    correctErrorTypes = true
}