import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import app.harry.multiplatformassemble.model.*
import app.harry.multiplatformassemble.data.*
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json

fun main() {
    embeddedServer(Netty, port = 8080, host = HOST_API_URL) {
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
                call.respondText(Json.encodeToString(ListSerializer(Member.serializer()), members))
            }
        }
    }.start(wait = true)
}