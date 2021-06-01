package app.harry.multiplatformassemble.di

import app.harry.multiplatformassemble.data.MemberClientApi
import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun initKoin(appDeclaration: KoinAppDeclaration = {}) =
    startKoin {
        appDeclaration()
        modules(
            listOf(
                module {
                    single { createHttpClient() }
                    single { MemberClientApi(get()) }
                }
            )
        )
    }

fun initKoin() = initKoin {}

expect val engineFactory : HttpClientEngineFactory<*>

fun createHttpClient() = HttpClient(engineFactory) {
    install(JsonFeature) {
        serializer = KotlinxSerializer(
            kotlinx.serialization.json.Json {
                isLenient = true
                ignoreUnknownKeys = true
            }
        )
    }
    install(Logging) {
        logger = Logger.DEFAULT
        level = LogLevel.INFO
    }
}