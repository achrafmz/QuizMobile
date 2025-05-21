package com.example.quizapp.data.model

data class Quiz(
    val id: Int,
    val nom: String,
    val photo: String,
    val categorie: Category
)