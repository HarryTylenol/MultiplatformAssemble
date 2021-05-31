package app.harry.multiplatformassemble.data

import app.harry.multiplatformassemble.domain.ApiResponse
import app.harry.multiplatformassemble.domain.Member
import org.koin.core.component.KoinComponent
import org.koin.core.component.get

class MemberRepositoryImp : MemberRepository, KoinComponent {

    private val api = get<MemberClientApi>()

    override suspend fun getAndroidMembers(): ApiResponse<List<Member>> {
        val response = api.getAndroidMembers()
        println("Members : $response")
        return response
    }
}