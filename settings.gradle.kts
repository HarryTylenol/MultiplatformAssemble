
pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "MultiplatformAssemble"

plugins {
    id("de.fayard.refreshVersions") version "0.10.0"
}

include(":android")
include(":shared")
include(":server")
include(":web")