

package com.example.multifunciones.agenda.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.multifunciones.agenda.viewmodel.AgendaViewModel

@Composable
fun AgendaScreen(
    viewModel: AgendaViewModel = viewModel()
) {
    val contacts by viewModel.contacts.collectAsState()
    var name by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Text("Agenda", style = MaterialTheme.typography.titleLarge)

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Nombre") }
        )

        OutlinedTextField(
            value = phone,
            onValueChange = { phone = it },
            label = { Text("Teléfono") }
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {
            viewModel.addContact(name, phone)
            name = ""
            phone = ""
        }) {
            Text("Agregar")
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(contacts) { contact ->
                Text("${contact.name} - ${contact.phone}")
            }
        }
    }
}


