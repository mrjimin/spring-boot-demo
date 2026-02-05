package com.example.demo.service

import com.example.demo.dto.User
import com.example.demo.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
) {

    fun createUser(user: User): User = userRepository.create(user)

    fun getUser(id: Long): User = userRepository.findById(id)

    fun getAll(): List<User> = userRepository.findAllUsers()

}