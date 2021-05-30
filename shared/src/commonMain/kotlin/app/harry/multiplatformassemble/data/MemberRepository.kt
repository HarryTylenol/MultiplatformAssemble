package app.harry.multiplatformassemble.data

import app.harry.multiplatformassemble.domain.Member
import app.harry.multiplatformassemble.domain.ApiResponse

interface MemberRepository {
    suspend fun getAndroidMembers() : ApiResponse<List<Member>>
}