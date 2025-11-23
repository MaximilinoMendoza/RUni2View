package com.example.multifunciones.temperature.viewmodel

import androidx.lifecycle.ViewModel
import com.example.multifunciones.temperature.model.TemperatureState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class TemperatureViewModel : ViewModel() {

    private val _state = MutableStateFlow(TemperatureState())
    val state: StateFlow<TemperatureState> = _state

    fun onValueChange(value: String) {
        _state.value = _state.value.copy(input = value)
    }

    fun celsiusToFahrenheit() {
        val c = _state.value.input.toDoubleOrNull() ?: 0.0
        _state.value = _state.value.copy(result = "${(c * 9 / 5) + 32} °F")
    }

    fun fahrenheitToCelsius() {
        val f = _state.value.input.toDoubleOrNull() ?: 0.0
        _state.value = _state.value.copy(result = "${(f - 32) * 5 / 9} °C")
    }
}
