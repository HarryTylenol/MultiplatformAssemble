package app.harry.multiplatformassemble.data

import app.harry.multiplatformassemble.model.Member
import io.ktor.client.*
import io.ktor.client.request.*

const val HOST_API_URL = "127.0.0.1"

const val CLIENT_API_URL = "https://75d619d18119.ngrok.io"

class MemberClientApi(
    private val client : HttpClient
) {

    suspend fun getAndroidMembers() = client.get<List<Member>>("$CLIENT_API_URL/androids")

}