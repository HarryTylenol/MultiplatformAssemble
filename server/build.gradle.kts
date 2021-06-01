import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
    application
    kotlin("plugin.serialization") version "1.4.32"
    id("distribution")
}

repositories {
    mavenCentral()
}

val browserDist by configurations.creating {
    isCanBeConsumed = false
    isCanBeResolved = true
}

dependencies {
    implementation(project(":shared"))
    implementation("org.slf4j:slf4j-simple:1.6.1")
    implementation(Ktor.features.htmlBuilder)
    implementation("org.jetbrains.kotlin-wrappers:kotlin-css:1.0.0-pre.206-kotlin-1.4.32")

    browserDist(
        project(
            mapOf(
                "path" to ":web",
                "configuration" to "browserDist"
            )
        )
    )
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("ServerKt")
}

tasks.withType<Copy>().named("processResources") {
    from(browserDist)
}

////// Dev server

tasks.register<Copy>("devServerResources") {
    destinationDir = File(project.buildDir, "dev-resources")
    from(sourceSets.main.map { it.resources })
    filter { line -> line.replace("port = 8080", "port = 8081") }
}

tasks.register("prepareDevServer") {
    dependsOn("compileKotlin")
    dependsOn("devServerResources")
}

tasks.register<JavaExec>("devServer") {
    dependsOn("prepareDevServer")

    classpath = project.files(
        configurations.runtimeClasspath,
        File(project.buildDir, "classes/kotlin/main"),
        File(project.buildDir, "dev-resources")
    )
    main = "io.ktor.server.netty.EngineMain"
}
