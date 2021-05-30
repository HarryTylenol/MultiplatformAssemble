import app.harry.multiplatformassemble.data.*
import app.harry.multiplatformassemble.domain.*
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.serialization.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(Netty, port = 8080, host = HOST_API_URL) {
        install(ContentNegotiation) {
            json()
        }
        routing {
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