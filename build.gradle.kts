// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.10.0" apply false
    id("org.jetbrains.kotlin.android") version "2.1.21" apply false
    id("org.jetbrains.kotlin.plugin.compose") version "2.1.21"
    id("com.google.devtools.ksp") version "2.1.21-2.0.1" apply false
}

buildscript {
val agp_version by extra("8.10.0")
    //    val agp_version by extra("8.10.0")
    dependencies {
        classpath ("com.google.dagger:hilt-android-gradle-plugin:2.56.2")
    }
}