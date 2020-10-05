package com.devmeist3r.viewmodelscopedemo1.model

import kotlinx.coroutines.delay

class UserRepository {
  suspend fun getUsers(): List<User> {
    delay(8000)

    val users: List<User> = listOf(
      User(1, "Pitoco"),
      User(2, "Bono"),
      User(3, "Spike"),
      User(4, "Bethoven"),
      User(5, "Lua")
    )

    return users
  }
}
