package com.example.quizappg.data.api

import QuizResult
import retrofit2.http.*
import com.example.quizappg.data.model.*

interface QuizApiService {
    @GET("api/quizzes")
    suspend fun getAllQuizzes(): List<Quiz>

    @GET("api/categories")
    suspend fun getCategories(): List<Category>

    @GET("api/quiz-results/user/{userId}")
    suspend fun getUserResults(@Path("userId") userId: String): List<QuizResult>
}