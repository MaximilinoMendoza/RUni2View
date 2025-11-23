

package com.example.multifunciones.agenda.viewmodel

import androidx.lifecycle.ViewModel
import com.example.multifunciones.agenda.model.Contact
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AgendaViewModel : ViewModel() {

    private val _contacts = MutableStateFlow<List<Contact>>(emptyList())
    val contacts: StateFlow<List<Contact>> = _contacts

    fun addContact(name: String, phone: String) {
        if (name.isNotBlank() && phone.isNotBlank()) {
            _contacts.value = _contacts.value + Contact(name, phone)
        }
    }
}
