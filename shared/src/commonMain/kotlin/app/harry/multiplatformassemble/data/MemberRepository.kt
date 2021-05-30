package app.harry.multiplatformassemble.data

import app.harry.multiplatformassemble.model.Member

interface MemberRepository {
    suspend fun getAndroidMembers() : List<Member>
}