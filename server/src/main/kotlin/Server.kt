import app.harry.multiplatformassemble.data.*
import app.harry.multiplatformassemble.domain.*
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.html.*
import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.routing.get
import io.ktor.serialization.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import kotlinx.css.*
import kotlinx.css.properties.lh
import kotlinx.html.*

private val globalCss = CSSBuilder().apply {
    body {
        margin(0.px)
        padding(0.px)

        fontSize = 13.px
        fontFamily = "-system-ui, -apple-system, BlinkMacSystemFont, Segoe UI, Roboto, Oxygen, Ubuntu, Cantarell, Droid Sans, Helvetica Neue, BlinkMacSystemFont, Segoe UI, Roboto, Oxygen, Ubuntu, Cantarell, Droid Sans, Helvetica Neue, Arial, sans-serif"

        lineHeight = 20.px.lh
    }
}

fun main() {
    embeddedServer(Netty, port = 8080, host = HOST_API_URL) {
        install(ContentNegotiation) {
            json()
        }
        install(CORS) {
            method(HttpMethod.Options)
            method(HttpMethod.Put)
            method(HttpMethod.Delete)
            method(HttpMethod.Patch)
            header(HttpHeaders.Authorization)
            header(HttpHeaders.AccessControlAllowOrigin)
            allowNonSimpleContentTypes = true
            allowCredentials = true
            allowSameOrigin = true
            anyHost()
        }
        routing {
            get("/") {
                call.respondHtml {
                    head {
                        meta {
                            charset = "utf-8"
                        }
                        title {
                            +"Kotlin full stack application demo"
                        }
                        style {
                            unsafe {
                                +globalCss.toString()
                            }
                        }
                    }
                    body {
                        div {
                            id = "root"
                            +"Loading..."
                        }
                        script(src = "/web.js") {
                        }
                    }
                }
            }
            static("/") {
                resources("/")
            }
            get("/androids") {
                val members = listOf(
                    Member("해리", "하수"),
                    Member("손", "중수"),
                    Member("데비", "중수"),
                    Member("루카스", "고수"),
                    Member("제임스", "고수"),
                    Member("링크", "고수"),
                    Member("매덕스", "매덕수"),
                )
                call.respond(ApiResponse(HttpStatusCode.OK.value, "SUCCESS", members))
            }
        }
    }.start(wait = true)
}