package com.example.multifunciones.money.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.multifunciones.money.viewmodel.MoneyViewModel

@Composable
fun MoneyScreen(
    viewModel: MoneyViewModel = viewModel()
) {
    val state by viewModel.state.collectAsState()
    val bills = listOf(20, 50, 100, 200, 500, 1000)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Text("Contador de Billetes", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(16.dp))

        bills.forEach { bill ->
            Button(
                onClick = { viewModel.selectBill(bill) },
                enabled = bill !in state.selectedBills,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("$ $bill")
            }

            Spacer(modifier = Modifier.height(8.dp))
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Total: $${state.total}", style = MaterialTheme.typography.titleMedium)
    }
}
