package com.goksu.to_doapp.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userDao: UserDao
) {
    suspend fun registerUser(user: User) {
        withContext(Dispatchers.IO) {
            userDao.insertUser(user)
        }
    }

    suspend fun loginUser(email: String, password: String): User? {
        return withContext(Dispatchers.IO) {
            userDao.getUser(email, password)
        }
    }
}
