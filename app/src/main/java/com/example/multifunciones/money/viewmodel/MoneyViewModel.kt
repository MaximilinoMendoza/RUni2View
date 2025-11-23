package com.example.multifunciones.money.viewmodel

import androidx.lifecycle.ViewModel
import com.example.multifunciones.money.model.MoneyState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MoneyViewModel : ViewModel() {

    private val _state = MutableStateFlow(MoneyState())
    val state: StateFlow<MoneyState> = _state

    private val bills = listOf(20, 50, 100, 200, 500, 1000)

    fun selectBill(bill: Int) {
        if (bill !in _state.value.selectedBills) {
            val newSet = _state.value.selectedBills + bill
            _state.value = _state.value.copy(
                selectedBills = newSet,
                total = newSet.sum()
            )
        }
    }
}
