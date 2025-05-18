package com.example.quizappg.data.repository

import com.example.quizappg.data.model.Quiz
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class QuizRepository {
    suspend fun getQuizzes(): List<Quiz> = withContext(Dispatchers.IO) {
        listOf(
            Quiz(1, "Android Basics", null),
            Quiz(2, "Kotlin Fundamentals", null)
        )
    }
}