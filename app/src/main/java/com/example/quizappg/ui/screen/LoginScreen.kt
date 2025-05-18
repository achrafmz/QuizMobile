package com.example.quizappg.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun LoginScreen(navController: NavHostController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Connexion", style = MaterialTheme.typography.headlineMedium)

        OutlinedTextField(email, onValueChange = { email = it }, label = { Text("Email") })
        OutlinedTextField(password, onValueChange = { password = it }, label = { Text("Mot de passe") })

        Button(onClick = { navController.navigate("home") }) {
            Text("Se connecter")
        }
    }
}