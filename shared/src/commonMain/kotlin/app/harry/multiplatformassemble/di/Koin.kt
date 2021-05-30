package app.harry.multiplatformassemble.di

import app.harry.multiplatformassemble.data.MemberClientApi
import app.harry.multiplatformassemble.data.MemberRepository
import app.harry.multiplatformassemble.data.MemberRepositoryImp
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.http.*
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun initKoin(appDeclaration: KoinAppDeclaration = {}) =
    startKoin {
        appDeclaration()
        modules(
            listOf(
                module {
                    single { MemberClientApi(createHttpClient()) }
                    single<MemberRepository> { MemberRepositoryImp(get()) }
                }
            )
        )
    }

fun initKoin() = initKoin {}

fun createHttpClient() = HttpClient(CIO) {
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