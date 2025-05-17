package com.example.quizappg.data.model

data class Quiz(
    val id: Int,
    val nom: String,
    val categorie: Category?,
    val photo: String?
)