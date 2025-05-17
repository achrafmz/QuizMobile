package com.example.quizappg.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.quizappg.viewmodel.QuizViewModel
import com.example.quizappg.ui.screen.*

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            LoginScreen(navController)
        }

        composable("home") {
            val quizViewModel: QuizViewModel = viewModel()
            HomeScreen(viewModel = quizViewModel, navController = navController)
        }

        composable("myquizzes") {
            val quizViewModel: QuizViewModel = viewModel()
            MyQuizzesScreen(viewModel = quizViewModel, navController = navController)
        }

        composable("profile") {
            ProfileScreen(navController = navController)
        }
    }
}