package com.jmf.composeestructura.data.repository

import com.jmf.composeestructura.domain.model.Todo

interface TodoRepository {
    suspend fun getTodos(): List<Todo>

}