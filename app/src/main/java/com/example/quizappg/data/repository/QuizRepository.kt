package com.example.quizappg.data.repository

import com.example.quizappg.data.api.RetrofitClient
import com.example.quizappg.data.model.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class QuizRepository {

    private val api = RetrofitClient.quizApi

    suspend fun getQuizzes(): List<Quiz> = withContext(Dispatchers.IO) {
        api.getAllQuizzes()
    }

    suspend fun getCategories(): List<Category> = withContext(Dispatchers.IO) {
        api.getCategories()
    }

    suspend fun getUserResults(userId: String): List<QuizResult> = withContext(Dispatchers.IO) {
        api.getUserResults(userId)
    }
}