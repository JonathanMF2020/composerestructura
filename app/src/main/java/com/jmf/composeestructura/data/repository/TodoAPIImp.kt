package com.jmf.composeestructura.data.repository

import com.jmf.composeestructura.data.datasource.api.TodoAPIDataSource
import com.jmf.composeestructura.data.datasource.api.entity.TodoAPIEntity
import com.jmf.composeestructura.data.datasource.api.entity.toTodo
import com.jmf.composeestructura.domain.model.Todo
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface TodoApi {

    @GET("todos")
    suspend fun getTodos(): List<TodoAPIEntity>

    companion object {
        var todoApi: TodoApi? = null
        fun getInstance(): TodoApi {
            if (todoApi == null) {
                todoApi = Retrofit.Builder()
                    .baseUrl("https://gettodo.free.beeceptor.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(TodoApi::class.java)
            }
            return todoApi!!
        }
    }
}


class TodoAPIImpl : TodoAPIDataSource {

    override suspend fun getTodos(): List<Todo> {
        return TodoApi.getInstance().getTodos().map {
            it.toTodo()
        }
    }
}