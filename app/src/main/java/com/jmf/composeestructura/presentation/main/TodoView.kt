package com.jmf.composeestructura.presentation.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@ExperimentalMaterial3Api
@Composable
fun TodoView(vm: TodoViewModel) {

    LaunchedEffect(Unit, block = {
        vm.getTodos()
    })

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Todos")
                }
            )
        },
        content = {padding ->
            Column(modifier = Modifier.padding(16.dp)) {
                LazyColumn(modifier = Modifier.fillMaxHeight()) {
                    items(count = vm.todos.size) { index ->
                        val todo = vm.todos[index % vm.todos.size]
                        Row(modifier = Modifier.padding(16.dp)) {
                            Checkbox(checked = todo.completed, onCheckedChange = null)
                            Spacer(modifier = Modifier.width(5.dp))
                            Text(todo.title)
                        }
                        Divider()
                    }
                }
            }
        }
    )
}