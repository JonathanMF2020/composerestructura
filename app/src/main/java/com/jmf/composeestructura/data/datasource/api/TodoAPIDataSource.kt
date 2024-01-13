package com.jmf.composeestructura.data.datasource.api

import com.jmf.composeestructura.domain.model.Todo

interface TodoAPIDataSource {
    suspend fun getTodos(): List<Todo>
}