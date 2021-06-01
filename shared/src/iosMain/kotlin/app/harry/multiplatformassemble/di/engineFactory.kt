package app.harry.multiplatformassemble.di

import io.ktor.client.engine.*
import io.ktor.client.engine.ios.*

actual val engineFactory: HttpClientEngineFactory<*> get() = Ios