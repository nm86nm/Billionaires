plugins {
    id("com.android.application")
    id("com.google.dagger.hilt.android")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.compose")
    id("kotlin-kapt")
}

android {
    namespace = "com.mnp.billionaires"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.mnp.billionaires"
        minSdk = 24
        //targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
    kotlinOptions {
        jvmTarget = "21"
    }
    buildFeatures {
        compose = true
    }
    /*composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }*/

    dependencies {
        implementation("androidx.core:core-ktx:1.16.0")
        implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.9.1")
        implementation("androidx.activity:activity-compose:1.10.1")
        implementation(platform("androidx.compose:compose-bom:2025.06.00"))
        implementation("androidx.compose.ui:ui")
        implementation("androidx.compose.ui:ui-graphics")
        implementation("androidx.compose.ui:ui-tooling-preview")
        implementation("androidx.compose.material3:material3")
        testImplementation("junit:junit:4.13.2")
        androidTestImplementation("androidx.test.ext:junit:1.2.1")
        androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
        androidTestImplementation(platform("androidx.compose:compose-bom:2025.06.00"))
        androidTestImplementation("androidx.compose.ui:ui-test-junit4")
        debugImplementation("androidx.compose.ui:ui-tooling")
        debugImplementation("androidx.compose.ui:ui-test-manifest")

        // Compose dependencies
        implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.9.1")
        implementation ("androidx.navigation:navigation-compose:2.9.0")
        implementation ("com.google.accompanist:accompanist-flowlayout:0.17.0")

        // Coroutines
        implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0")
        implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.9.0")

        // Coroutine Lifecycle Scopes
        implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.9.1")
        implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.9.1")

        //Dagger - Hilt
        implementation ("com.google.dagger:hilt-android:2.56.2")
        kapt ("com.google.dagger:hilt-compiler:2.56.2")
        //implementation ("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")
        kapt ("androidx.hilt:hilt-compiler:1.2.0")
        implementation ("androidx.hilt:hilt-navigation-compose:1.2.0")

        // Retrofit
        implementation ("com.squareup.retrofit2:retrofit:2.9.0")
        implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
        implementation ("com.squareup.okhttp3:okhttp:5.0.0-alpha.2")
        implementation ("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.2")

        //Coil
        implementation("io.coil-kt:coil-compose:2.5.0")
    }
}