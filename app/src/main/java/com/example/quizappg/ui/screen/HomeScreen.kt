package com.example.quizappg.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.quizappg.data.model.Quiz
import com.example.quizappg.ui.component.QuizCard
import com.example.quizappg.viewmodel.QuizViewModel

@Composable
fun HomeScreen(
    viewModel: QuizViewModel,
    navController: NavHostController
) {
    Column {
        Text(text = "Mes Quizs", style = androidx.compose.material3.MaterialTheme.typography.headlineMedium)

        LazyColumn(modifier = Modifier.weight(1f)) {
            items(viewModel.quizzes.value) { quiz ->
                QuizCard(quiz = quiz, navController = navController)
            }
        }
    }
}