package com.example.quizappg.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.quizappg.data.model.Quiz

@Composable
fun QuizCard(
    quiz: Quiz,
    navController: NavHostController
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                // Naviguer vers un écran détaillé (optionnel pour maintenant)
                // navController.navigate("quiz/${quiz.id}")
            }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = quiz.nom)

            quiz.categorie?.nom?.let {
                Text(text = "Catégorie : $it")
            }
        }
    }
}