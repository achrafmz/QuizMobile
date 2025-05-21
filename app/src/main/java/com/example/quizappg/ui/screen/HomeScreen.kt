@Composable
fun HomeScreen(navController: NavController) {
    val viewModel: QuizViewModel = viewModel()
    val quizzes by viewModel.quizzes.collectAsState()
    val categories by viewModel.categories.collectAsState()
    val loading by viewModel.loading.collectAsState()
    val user = Firebase.currentUser

    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        Text("Bonjour ${user?.displayName ?: "Invité"}")

        var searchTerm by remember { mutableStateOf("") }
        var selectedCategory by remember { mutableStateOf("Toutes") }

        TextField(
            value = searchTerm,
            onValueChange = { searchTerm = it },
            label = { Text("Rechercher un quiz") },
            modifier = Modifier.fillMaxWidth()
        )

        ExposedDropdownMenuBox(
            expanded = false,
            onExpandedChange = {}
        ) {
            TextField(
                value = selectedCategory,
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = false) },
                colors = ExposedDropdownMenuDefaults.textFieldColors(),
                modifier = Modifier.fillMaxWidth()
            )
            ExposedDropdownMenu(
                expanded = false,
                onDismissRequest = {}
            ) {
                (listOf("Toutes") + categories.map { it.nom }).forEach { item ->
                    DropdownMenuItem(onClick = { selectedCategory = item }) {
                        Text(item)
                    }
                }
            }
        }

        if (loading) {
            Text("Chargement...")
        } else {
            quizzes.forEach { quiz ->
                QuizCard(quiz = quiz) {
                    navController.navigate("quiz/${quiz.id}")
                }
            }
        }
    }
}