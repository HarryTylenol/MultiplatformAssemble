package app.harry.multiplatformassemble.di

import io.ktor.client.engine.*
import io.ktor.client.engine.js.*

actual val engineFactory: HttpClientEngineFactory<*> get() = JsClient()