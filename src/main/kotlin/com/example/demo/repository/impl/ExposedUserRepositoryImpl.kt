package com.example.demo.repository.impl

import com.example.demo.dto.User
import com.example.demo.entity.UserEntity
import com.example.demo.entity.UserTable
import com.example.demo.repository.UserRepository
import org.jetbrains.exposed.v1.core.eq
import org.jetbrains.exposed.v1.jdbc.transactions.transaction
import org.springframework.stereotype.Repository

@Repository
class ExposedUserRepositoryImpl : UserRepository {

    override fun findByEmailOrNull(email: String): User? {
        return transaction {
            UserEntity.find {
                UserTable.email eq email
            }.singleOrNull()?.let { User.from(it) }
        }
    }

    override fun findById(id: Long): User {
        return transaction {
            UserEntity.findById(id)?.let { User.from(it) }
        } ?: throw NoSuchElementException("User with id $id not found")
    }

    override fun findAllUsers(): List<User> {
        return transaction {
            UserEntity.all().map { User.from(it) }
        }
    }

    override fun create(user: User): User {
        return transaction {
            UserEntity.new {
                nickname = user.nickname
                email = user.email
                password = user.password
            }.let { User.from(it) }
        }
    }

    override fun delete(id: Long): Boolean {
        return transaction {
            UserEntity.findById(id)?.let {
                it.delete()
                true
            } ?: false
        }
    }

}