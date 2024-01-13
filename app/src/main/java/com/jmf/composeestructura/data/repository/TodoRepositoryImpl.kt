package com.jmf.composeestructura.data.repository

import com.jmf.composeestructura.data.datasource.api.TodoAPIDataSource
import com.jmf.composeestructura.domain.model.Todo

class TodoRepositoryImpl(private val datasource: TodoAPIDataSource) : TodoRepository {

    override suspend fun getTodos(): List<Todo> {
        return datasource.getTodos()
    }
}