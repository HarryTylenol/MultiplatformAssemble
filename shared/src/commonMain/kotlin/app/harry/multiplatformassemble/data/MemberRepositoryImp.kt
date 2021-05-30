package app.harry.multiplatformassemble.data

import app.harry.multiplatformassemble.model.Member

class MemberRepositoryImp(private val memberClientApi: MemberClientApi) : MemberRepository {

    override suspend fun getAndroidMembers(): List<Member> {
        val members = memberClientApi.getAndroidMembers()
        println("Members : $members")
        return members
    }
}