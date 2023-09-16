package com.example.ezcalculator.feature_exchange.domain

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ExchangeViewModel : ViewModel() {

    var state by mutableStateOf(ExchangeState())

    fun onAction(action: ExchangeAction) {
        when (action) {
            is ExchangeAction.Number -> enterNumber(action.number)
            is ExchangeAction.Delete -> delete()
            is ExchangeAction.Clear -> state = ExchangeState(selectedExchanger = state.selectedExchanger)
            is ExchangeAction.Decimal -> enterDecimal()
            is ExchangeAction.SelectExchanger -> select(exchanger = action.exchanger)
        }
    }

    private fun select(exchanger: Exchanger) {
        state = state.copy(selectedExchanger = exchanger)
    }

    // Live currency convert here
    private fun enterNumber(number: Int) {
        val exchanger = state.selectedExchanger
        if (exchanger != null) {
            when (exchanger.id) {
                Exchanger.First.id -> {
                    state = state.copy(firstExchangerValue = state.firstExchangerValue + number)
                }

                Exchanger.Second.id -> {
                    state = state.copy(secondExchangerValue = state.secondExchangerValue + number)
                }
            }
        }
    }

    private fun enterDecimal() {
        val exchanger = state.selectedExchanger
        if (exchanger != null) {
            when (exchanger.id) {
                Exchanger.First.id -> {
                    if (!state.firstExchangerValue.contains('.')) {
                        state = state.copy(firstExchangerValue = state.firstExchangerValue + ".")
                    }
                }

                Exchanger.Second.id -> {
                    if (!state.secondExchangerValue.contains('.')) {
                        state = state.copy(secondExchangerValue = state.secondExchangerValue + ".")
                    }
                }
            }
        }
    }

    private fun delete() {
        val exchanger = state.selectedExchanger
        if (exchanger != null) {
            when (exchanger.id) {
                Exchanger.First.id -> {
                    if (state.firstExchangerValue.isNotEmpty()) {
                        state = state.copy(firstExchangerValue = state.firstExchangerValue.dropLast(1))
                    }
                }

                Exchanger.Second.id -> {
                    if (state.secondExchangerValue.isNotEmpty()) {
                        state = state.copy(secondExchangerValue = state.secondExchangerValue.dropLast(1))
                    }
                }
            }
        }
    }

    private fun calculate() {

    }
}