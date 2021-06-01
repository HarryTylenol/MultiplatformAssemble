package app.harry.multiplatformassemble.data

import app.harry.multiplatformassemble.domain.ApiResponse
import app.harry.multiplatformassemble.domain.Member
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*
import org.koin.core.component.KoinComponent

const val HOST_API_URL = "127.0.0.1"

const val CLIENT_API_URL = "https://8264ee4cbcae.ngrok.io"

class MemberClientApi(
    private val client : HttpClient
) {

    suspend fun getAndroidMembers() = client.get<ApiResponse<List<Member>>>("$CLIENT_API_URL/androids")

}