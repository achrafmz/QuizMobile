package com.example.quizappg.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quizappg.data.model.Quiz
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import com.example.quizappg.data.repository.QuizRepository

class QuizViewModel : ViewModel() {
    private val repository = QuizRepository()

    private val _quizzes = MutableStateFlow<List<Quiz>>(emptyList())
    val quizzes: StateFlow<List<Quiz>> = _quizzes

    init {
        fetchQuizzes()
    }

    fun fetchQuizzes() {
        viewModelScope.launch {
            _quizzes.value = repository.getQuizzes()
        }
    }
}