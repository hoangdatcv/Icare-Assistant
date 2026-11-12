plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.trolyyte"
    compileSdk = 34
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    androidResources {
        noCompress += "tflite"  // Không nén file có đuôi .tflite
        noCompress += "json"    // Không nén tài nguyên JSON.
    }
    defaultConfig {
        applicationId = "com.example.trolyyte"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        ndk {
            // Hỗ trợ cả thiết bị ARM và máy ảo x86.
            abiFilters.add("armeabi-v7a")
            abiFilters.add("arm64-v8a")
            abiFilters.add("x86")
            abiFilters.add("x86_64")
        }
    }

    buildFeatures {
        viewBinding = true
        dataBinding = true
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    
    // Suy luận NLU trên thiết bị.
    // Dùng cùng phiên bản cho TFLite và Select TF Ops.
    implementation("org.tensorflow:tensorflow-lite:2.16.1")
    implementation("org.tensorflow:tensorflow-lite-select-tf-ops:2.16.1")
    implementation("org.tensorflow:tensorflow-lite-support:0.4.4")
    
    // Đọc dữ liệu JSON.
    implementation("com.google.code.gson:gson:2.10.1")

    // Nhận dạng giọng nói trên thiết bị.
    implementation("com.alphacephei:vosk-android:0.3.47")

    // Lưu trữ dữ liệu cục bộ.
    val roomVersion = "2.6.1"
    implementation("androidx.room:room-runtime:$roomVersion")
    annotationProcessor("androidx.room:room-compiler:$roomVersion")
}
