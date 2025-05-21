package com.example.quizapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quizapp.data.model.Category
import com.example.quizapp.data.model.Quiz
import com.example.quizapp.util.ApiClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class QuizViewModel : ViewModel() {

    private val _quizzes = MutableStateFlow<List<Quiz>>(emptyList())
    val quizzes: StateFlow<List<Quiz>> get() = _quizzes

    private val _categories = MutableStateFlow<List<Category>>(emptyList())
    val categories: StateFlow<List<Category>> get() = _categories

    private val _loading = MutableStateFlow(true)
    val loading: StateFlow<Boolean> get() = _loading

    init {
        fetchQuizzes()
        fetchCategories()
    }

    private fun fetchQuizzes() {
        viewModelScope.launch {
            try {
                _quizzes.value = ApiClient.apiService.getAllQuizzes()
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                _loading.value = false
            }
        }
    }

    private fun fetchCategories() {
        viewModelScope.launch {
            try {
                _categories.value = ApiClient.apiService.getAllCategories()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}