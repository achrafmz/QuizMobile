package com.example.quizapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quizapp.ui.screens.HomeScreen
import com.example.quizapp.ui.screens.LoginScreen
import com.example.quizapp.ui.screens.MyQuizzesScreen
import com.example.quizapp.ui.screens.ProfileScreen
import com.example.quizapp.ui.screens.RegisterScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginScreen(navController) }
        composable("register") { RegisterScreen(navController) }
        composable("home") { HomeScreen(navController) }
        composable("profile") { ProfileScreen() }
        composable("myquizzes") { MyQuizzesScreen() }
    }
}