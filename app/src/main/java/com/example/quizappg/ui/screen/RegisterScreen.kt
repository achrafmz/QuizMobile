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

@Composable
fun RegisterScreen(navController: NavController) {
    var fullName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Créer un compte", style = MaterialTheme.typography.h5)

        OutlinedTextField(
            value = fullName,
            onValueChange = { fullName = it },
            label = { Text("Nom complet") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Mot de passe") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            Firebase.auth.createUserWithEmailAndPassword(email, password)
                .addOnSuccessListener { task ->
                    task.user?.updateProfile(
                        UserProfileChangeRequest.Builder().setDisplayName(fullName).build()
                    )
                    navController.navigate("login")
                }
                .addOnFailureListener {
                    Toast.makeText(context, "Erreur : ${it.message}", Toast.LENGTH_LONG).show()
                }
        }) {
            Text("S'inscrire")
        }

        TextButton(onClick = { navController.popBackStack() }) {
            Text("Déjà un compte ? Se connecter")
        }
    }
}