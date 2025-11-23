package com.example.multifunciones.money.model

data class MoneyState(
    val selectedBills: Set<Int> = emptySet(),
    val total: Int = 0
)
