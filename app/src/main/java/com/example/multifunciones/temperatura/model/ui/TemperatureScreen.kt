
package com.example.multifunciones.temperature.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.multifunciones.temperature.viewmodel.TemperatureViewModel

@Composable
fun TemperatureScreen(
    viewModel: TemperatureViewModel = viewModel()
) {
    val state by viewModel.state.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Conversor de Temperatura", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = state.input,
            onValueChange = viewModel::onValueChange,
            label = { Text("Valor") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = viewModel::celsiusToFahrenheit) {
            Text("Celsius → Fahrenheit")
        }

        Button(onClick = viewModel::fahrenheitToCelsius) {
            Text("Fahrenheit → Celsius")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Resultado: ${state.result}")
    }
}
