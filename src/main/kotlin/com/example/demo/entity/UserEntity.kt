package com.example.demo.entity

import org.jetbrains.exposed.v1.core.dao.id.EntityID
import org.jetbrains.exposed.v1.core.dao.id.LongIdTable
import org.jetbrains.exposed.v1.dao.LongEntity
import org.jetbrains.exposed.v1.dao.LongEntityClass
import org.jetbrains.exposed.v1.javatime.datetime
import java.time.LocalDateTime

object UserTable : LongIdTable("user", "user_id") {
    val nickname = varchar("nickname", 255)
    val email = varchar("email", 255)
    val password = varchar("password", 255)
    val createdAt = datetime("created_at").clientDefault { LocalDateTime.now() }
}

class UserEntity(id: EntityID<Long>) : LongEntity(id) {
    companion object : LongEntityClass<UserEntity>(UserTable)

    var nickname by UserTable.nickname
    var email by UserTable.email
    var password by UserTable.password
    val createdAt by UserTable.createdAt
}