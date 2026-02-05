package com.example.demo.dto

import com.example.demo.entity.UserEntity
import java.time.LocalDateTime

data class User(
    val id: Long = 0L, // only memory
    val nickname: String,
    val email: String,
    val password: String,
    val createdAt: LocalDateTime = LocalDateTime.now()
) {
    companion object {
        fun from(userEntity: UserEntity) = User(
            nickname = userEntity.nickname,
            email = userEntity.email,
            password = userEntity.password
        )
    }
}