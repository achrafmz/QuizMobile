package com.example.quizappg.ui.screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.quizappg.data.model.Quiz
import com.example.quizappg.ui.component.QuizCard
import com.example.quizappg.viewmodel.QuizViewModel

@Composable
fun HomeScreen(
    viewModel: QuizViewModel,
    navController: NavHostController
) {
    val quizzes by remember { mutableStateOf(listOf(
        Quiz(1, "Android Basics", null, ""),
        Quiz(2, "Kotlin Fundamentals", null, "")
    )) }

    LazyColumn {
        items(quizzes) { quiz ->
            QuizCard(quiz = quiz, navController = navController)
        }
    }
}