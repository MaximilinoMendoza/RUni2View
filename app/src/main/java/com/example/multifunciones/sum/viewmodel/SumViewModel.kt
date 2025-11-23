package com.example.multifunciones.sum.viewmodel

import androidx.lifecycle.ViewModel
import com.example.multifunciones.sum.model.SumState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SumViewModel : ViewModel() {

    private val _state = MutableStateFlow(SumState())
    val state: StateFlow<SumState> = _state

    fun onNum1Change(value: String) {
        _state.value = _state.value.copy(num1 = value)
    }

    fun onNum2Change(value: String) {
        _state.value = _state.value.copy(num2 = value)
    }

    fun sumar() {
        val n1 = _state.value.num1.toIntOrNull() ?: 0
        val n2 = _state.value.num2.toIntOrNull() ?: 0
        _state.value = _state.value.copy(result = n1 + n2)
    }
}
