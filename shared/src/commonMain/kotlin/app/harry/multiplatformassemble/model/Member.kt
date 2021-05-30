package app.harry.multiplatformassemble.model

import kotlinx.serialization.Serializable

@Serializable
data class Member(
    val name : String,
    val level : String
)