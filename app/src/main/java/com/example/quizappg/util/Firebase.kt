package com.example.quizapp.util

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

object Firebase {
    val auth = FirebaseAuth.getInstance()
    val currentUser: FirebaseUser? get() = auth.currentUser
}