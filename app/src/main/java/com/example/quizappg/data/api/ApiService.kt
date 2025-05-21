package com.example.quizapp.data.api

import com.example.quizapp.data.model.Category
import com.example.quizapp.data.model.Quiz
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("quizzes")
    suspend fun getAllQuizzes(): List<Quiz>

    @GET("categories")
    suspend fun getAllCategories(): List<Category>

    @GET("quiz-results/user/{userId}")
    suspend fun getUserResults(@Path("userId") userId: String): List<QuizResult>
}