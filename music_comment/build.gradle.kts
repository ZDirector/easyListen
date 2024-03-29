plugins {
    id("com.android.library")
//    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id ("kotlin-kapt")
}

android {
    compileSdk = 32

    defaultConfig {
//        applicationId = "com.example.music_comment"
        minSdk = 21
        targetSdk = 32

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
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
    viewBinding {
        isEnabled = true
    }
    dataBinding {
        isEnabled = true
    }
}

dependencies {

    implementation(project(":common"))

    //加载动画库
    implementation("com.wang.avi:library:2.1.3")

    //Glide
    implementation ("com.github.bumptech.glide:glide:4.14.2")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.14.2")

    //下拉刷新上拉加载更多
    implementation ("io.github.scwang90:refresh-layout-kernel:2.0.5")
    implementation ("io.github.scwang90:refresh-footer-classics:2.0.5")
    implementation ("io.github.scwang90:refresh-header-classics:2.0.5")

    // 协程核心库
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.1")
    // 协程 Android 支持库
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.1")

    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0")
    // LiveData
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.2.0")
    // Lifecycles only (without ViewModel or LiveData)
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.2.0")

    //retrofit
    api("com.squareup.retrofit2:retrofit:2.9.0")
    api("com.squareup.retrofit2:converter-gson:2.9.0")

    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.appcompat:appcompat:1.5.1")
    implementation("com.google.android.material:material:1.6.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}