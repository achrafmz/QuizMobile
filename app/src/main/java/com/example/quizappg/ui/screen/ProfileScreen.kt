@Composable
fun ProfileScreen() {
    val user = Firebase.currentUser
    var oldPassword by remember { mutableStateOf("") }
    var newPassword by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Personal details", style = MaterialTheme.typography.h5)

        Text("Nom : ${user?.displayName}")
        Text("Email : ${user?.email}")

        Spacer(modifier = Modifier.height(16.dp))

        Text("Changer le mot de passe", style = MaterialTheme.typography.h6)

        CustomInputField(
            label = "Ancien mot de passe",
            value = oldPassword,
            onValueChange = { oldPassword = it },
            isPassword = true
        )

        CustomInputField(
            label = "Nouveau mot de passe",
            value = newPassword,
            onValueChange = { newPassword = it },
            isPassword = true
        )

        CustomInputField(
            label = "Confirmer mot de passe",
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            isPassword = true
        )

        Button(onClick = {
            if (newPassword != confirmPassword) return@Button
            // Implémenter la mise à jour du mot de passe via Firebase
        }) {
            Text("Sauvegarder")
        }
    }
}