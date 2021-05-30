package app.harry.multiplatformassemble.domain

import kotlinx.serialization.Serializable

@Serializable
data class Member(
    val name : String,
    val level : String
)