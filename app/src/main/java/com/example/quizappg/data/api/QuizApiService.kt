package com.example.quizappg.data.api

import com.example.quizappg.data.model.Category
import com.example.quizappg.data.model.Quiz
import com.example.quizappg.data.model.QuizResult
import retrofit2.http.GET
import retrofit2.http.Path

interface QuizApiService {
    @GET("api/quizzes")
    suspend fun getAllQuizzes(): List<Quiz>

    @GET("api/categories")
    suspend fun getCategories(): List<Category>

    @GET("api/quiz-results/user/{userId}")
    suspend fun getUserResults(@Path("userId") userId: String): List<QuizResult>
}