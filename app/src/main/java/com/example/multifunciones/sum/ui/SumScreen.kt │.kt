package com.example.multifunciones.sum.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.multifunciones.sum.viewmodel.SumViewModel

@Composable
fun SumScreen(
    viewModel: SumViewModel = viewModel()
) {
    val state by viewModel.state.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("Suma de dos números", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = state.num1,
            onValueChange = viewModel::onNum1Change,
            label = { Text("Número 1") }
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = state.num2,
            onValueChange = viewModel::onNum2Change,
            label = { Text("Número 2") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = viewModel::sumar) {
            Text("Sumar")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Resultado: ${state.result}",
            style = MaterialTheme.typography.titleMedium
        )
    }
}
