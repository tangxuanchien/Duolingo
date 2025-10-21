package com.example.duolingo.database.repository

import android.content.Context
import com.example.duolingo.database.AppDatabase
import com.example.duolingo.database.entity.User
import dagger.hilt.android.qualifiers.ApplicationContext
import jakarta.inject.Inject

class UserRepository @Inject constructor(
    @ApplicationContext private val context: Context
) {
    val userDao = AppDatabase.getInstance(context).userDao()

    suspend fun insert(user: User) = userDao.insert(user)
}