@file:OptIn(ExperimentalMaterial3Api::class)

package com.jmf.composeestructura

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jmf.composeestructura.data.datasource.api.TodoAPIDataSource
import com.jmf.composeestructura.data.repository.TodoAPIImpl
import com.jmf.composeestructura.data.repository.TodoRepositoryImpl
import com.jmf.composeestructura.domain.usecase.GetTodos
import com.jmf.composeestructura.presentation.main.TodoView
import com.jmf.composeestructura.presentation.main.TodoViewModel
import com.jmf.composeestructura.ui.theme.ComposeEstructuraTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val vm = TodoViewModel(
            getTodosUseCase = GetTodos(
                repository = TodoRepositoryImpl(
                    datasource = TodoAPIImpl()
                )
            )
        )
        super.onCreate(savedInstanceState)
        setContent {
            ComposeEstructuraTheme {
                TodoView(vm)
            }
        }
    }
}