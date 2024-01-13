package com.jmf.composeestructura.domain.usecase

import com.jmf.composeestructura.data.repository.TodoRepository
import com.jmf.composeestructura.domain.model.Todo

class GetTodos(
    private val repository: TodoRepository
) {
    suspend operator fun invoke(): List<Todo> {
        return repository.getTodos()
    }
}