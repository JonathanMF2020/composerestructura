package com.jmf.composeestructura.data.datasource.api.entity

import com.jmf.composeestructura.domain.model.Todo

data class TodoAPIEntity(
    val id: Int,
    val completed: Boolean,
    val title: String
)

fun TodoAPIEntity.toTodo(): Todo {
    return Todo(
        id = id,
        completed = completed,
        title = title
    )
}