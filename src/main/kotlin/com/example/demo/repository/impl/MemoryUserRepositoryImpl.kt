package com.example.demo.repository.impl

import com.example.demo.dto.User
import com.example.demo.repository.UserRepository
import org.springframework.stereotype.Repository

@Repository
class MemoryUserRepositoryImpl : UserRepository {

    override fun findByEmailOrNull(email: String): User? {
        return users.values.find { it.email.equals(email, true) }
    }

    override fun findById(id: Long): User {
        return users[id] ?: throw NoSuchElementException("User with id $id not found")
    }

    override fun findAllUsers(): List<User> {
        return users.values.toList()
    }

    override fun create(user: User): User {
        return user.copy(id = ++i).also {
            users[it.id] = it
        }
    }

    override fun delete(id: Long): Boolean {
        return users.remove(id) != null
    }

    companion object {
        private val users: MutableMap<Long, User> = hashMapOf()
        private var i = 0L
    }
}