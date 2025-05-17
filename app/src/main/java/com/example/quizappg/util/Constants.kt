package com.example.quizappg.util

object Constants {
    // 🔗 Base URL pour l'API
    const val BASE_URL = "http://10.0.2.2:9090/" // 10.0.2.2 = localhost sur émulateur

    // 🧩 Noms des écrans pour la navigation
    const val SCREEN_HOME = "home"
    const val SCREEN_LOGIN = "login"
    const val SCREEN_REGISTER = "register"
    const val SCREEN_PROFILE = "profile"
    const val SCREEN_MY_QUIZZES = "myquizzes"
    const val SCREEN_QUIZ_DETAIL = "quiz_detail/{quizId}"

    // 📱 Titres d'écrans
    const val TITLE_HOME = "Quiz App"
    const val TITLE_PROFILE = "Mon Profil"
    const val TITLE_MY_QUIZZES = "Mes Quizs"

    // 📡 Messages d'erreur
    const val ERROR_MESSAGE_DEFAULT = "Une erreur est survenue."
    const val ERROR_MESSAGE_NETWORK = "Erreur réseau, veuillez réessayer."
    const val ERROR_MESSAGE_NO_QUIZZES = "Aucun quiz trouvé."

    // ⏱ Temps
    const val SPLASH_SCREEN_DELAY = 2000L // 2 secondes

    // 🎨 Couleurs (si pas dans Theme.kt)
    val COLOR_PRIMARY = androidx.compose.ui.graphics.Color(0xFF6200EE)
    val COLOR_PRIMARY_VARIANT = androidx.compose.ui.graphics.Color(0xFF3700B3)
    val COLOR_ON_PRIMARY = androidx.compose.ui.graphics.Color.White
}