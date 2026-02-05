package com.example.demo.api

import com.example.demo.dto.User
import com.example.demo.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/user")
class UserController(
    private val userService: UserService
) {

    @GetMapping
    fun getAll(): List<User> = userService.getAll()

    @GetMapping("/{id}")
    fun getUser(@PathVariable id: Long): ResponseEntity<User> {
        return ResponseEntity.ok(userService.getUser(id))
    }

    @PostMapping
    fun create(@RequestBody user: User): ResponseEntity<User> {
        val user = userService.createUser(user)
        return ResponseEntity.ok(user)
    }
}