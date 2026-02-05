package com.example.demo.repository

import com.example.demo.dto.User

interface UserRepository {
    fun findByEmailOrNull(email: String): User?
    fun findById(id: Long): User
    fun findAllUsers(): List<User>
    fun create(user: User): User
    fun delete(id: Long): Boolean
}