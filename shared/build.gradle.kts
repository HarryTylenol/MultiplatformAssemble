import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
    kotlin("plugin.serialization") version "1.4.32"
}

version = "1.0"

android {
    configurations {
        create("androidTestApi")
        create("androidTestDebugApi")
        create("androidTestReleaseApi")
        create("testApi")
        create("testDebugApi")
        create("testReleaseApi")
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

kotlin {
    android()
    jvm()
    val iosTarget: (String, KotlinNativeTarget.() -> Unit) -> KotlinNativeTarget =
        if (System.getenv("SDK_NAME")?.startsWith("iphoneos") == true)
            ::iosArm64
        else
            ::iosX64

    iosTarget("ios") {}

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        ios.deploymentTarget = "14.1"
        frameworkName = "shared"
        podfile = project.file("../ios/Podfile")
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(KotlinX.coroutines.core)
                api(KotlinX.serialization.core)
                api(Ktor.client.core)
                api(Ktor.client.logging)
                api(Ktor.client.cio)
                api(Ktor.client.serialization)
                api(Koin.core)
            }
        }
        val androidMain by getting {
            dependencies {
                api(KotlinX.coroutines.android)

                api(Koin.Android.android)
                api(Koin.Android.compose)
                api(Koin.Android.ext)
                api(Koin.ext)

                api(AndroidX.appCompat)

                api(AndroidX.compose.runtime)
                api(AndroidX.compose.foundation)
                api(AndroidX.compose.ui)
                api(AndroidX.compose.material)
                api(AndroidX.activity.compose)

                api(AndroidX.lifecycle.common)
                api(AndroidX.lifecycle.runtimeKtx)
                api(AndroidX.lifecycle.viewModelKtx)
                api(AndroidX.lifecycle.viewModelCompose)

                api(Google.android.material)
            }
        }
        val iosMain by getting {
            dependencies {
            }
        }
        val jvmMain by getting {
            dependencies {
                api(Ktor.server.core)
                api(Ktor.server.netty)
                api(Koin.Ktor.ktor)
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val androidTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation("junit:junit:4.13.2")
            }
        }
        val iosTest by getting
        val jvmTest by getting
    }
}

android {
    compileSdkVersion(30)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdkVersion(24)
        targetSdkVersion(30)
    }
}