package com.jmf.composeestructura.presentation.main

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jmf.composeestructura.domain.model.Todo
import com.jmf.composeestructura.domain.usecase.GetTodos
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TodoViewModel constructor(
    private val getTodosUseCase: GetTodos
) : ViewModel() {
    private val _todos = mutableStateListOf<Todo>()

    val todos: List<Todo>
        get() = _todos


    suspend fun getTodos() {
        viewModelScope.launch(Dispatchers.IO) {
            _todos.addAll(getTodosUseCase())
        }
    }
}