package com.example.quizapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class ProfileViewModel : ViewModel() {

    private val auth = FirebaseAuth.getInstance()
    val currentUser get() = auth.currentUser

    private val _successMessage = MutableStateFlow("")
    val successMessage: StateFlow<String> get() = _successMessage

    private val _errorMessage = MutableStateFlow("")
    val errorMessage: StateFlow<String> get() = _errorMessage

    fun changePassword(oldPassword: String, newPassword: String, confirmPassword: String) {
        viewModelScope.launch {
            if (newPassword != confirmPassword) {
                _errorMessage.emit("Les mots de passe ne correspondent pas.")
                return@launch
            }

            try {
                val user = auth.currentUser ?: throw Exception("Utilisateur non connecté")
                val credential = EmailAuthProvider.getCredential(user.email!!, oldPassword)
                user.reauthenticate(credential).await()

                user.updatePassword(newPassword).await()
                _successMessage.emit("Mot de passe mis à jour.")
            } catch (e: Exception) {
                when (e) {
                    is FirebaseAuthInvalidCredentialsException -> {
                        _errorMessage.emit("Ancien mot de passe incorrect.")
                    }
                    else -> {
                        _errorMessage.emit(e.message ?: "Erreur inconnue")
                    }
                }
            }
        }
    }
}