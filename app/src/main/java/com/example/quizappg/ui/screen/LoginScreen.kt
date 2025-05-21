package com.example.quizapp.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.quizapp.util.Firebase
import com.google.firebase.auth.FirebaseAuth

@Composable
fun LoginScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Connexion", style = MaterialTheme.typography.h5)
        CustomInputField(label = "Email", value = email, onValueChange = { email = it })
        CustomInputField(label = "Mot de passe", value = password, onValueChange = { password = it }, isPassword = true)

        Button(onClick = {
            Firebase.auth.signInWithEmailAndPassword(email, password)
                .addOnSuccessListener {
                    navController.navigate("home")
                }
                .addOnFailureListener {
                    Toast.makeText(LocalContext.current, it.message!!, Toast.LENGTH_LONG).show()
                }
        }) {
            Text("Se connecter")
        }

        TextButton(onClick = { navController.navigate("register") }) {
            Text("Pas encore inscrit ? S'inscrire")
        }
    }
}