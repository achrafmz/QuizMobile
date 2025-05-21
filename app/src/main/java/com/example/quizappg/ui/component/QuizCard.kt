@Composable
fun QuizCard(quiz: Quiz, onClick: () -> Unit) {
    val imageUrl = "data:image/jpeg;base64,${quiz.photo}"

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Image(
                painter = rememberImagePainter(imageUrl),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(text = quiz.nom, style = MaterialTheme.typography.titleMedium)
            Text(text = quiz.categorie.nom, style = MaterialTheme.typography.bodySmall)
        }
    }
}