package app.harry.multiplatformassemble.data

import app.harry.multiplatformassemble.domain.ApiResponse
import app.harry.multiplatformassemble.domain.Member

class MemberRepositoryImp(private val memberClientApi: MemberClientApi) : MemberRepository {

    override suspend fun getAndroidMembers(): ApiResponse<List<Member>> {
        val response = memberClientApi.getAndroidMembers()
        println("Members : $response")
        return response
    }
}