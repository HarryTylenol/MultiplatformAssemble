package app.harry.multiplatformassemble.di

import io.ktor.client.engine.*
import io.ktor.client.engine.cio.*

actual val engineFactory: HttpClientEngineFactory<*> get() = CIO