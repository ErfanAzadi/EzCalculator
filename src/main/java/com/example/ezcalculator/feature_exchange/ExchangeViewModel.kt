package com.example.ezcalculator.feature_exchange

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ezcalculator.feature_exchange.domain.use_case.FetchCurrencyPrice
import com.example.ezcalculator.feature_exchange.domain.util.Currency
import com.example.ezcalculator.feature_exchange.domain.util.ExchangeAction
import com.example.ezcalculator.feature_exchange.domain.util.ExchangeState
import com.example.ezcalculator.feature_exchange.domain.util.Exchanger
import com.example.ezcalculator.feature_exchange.domain.util.PriceState
import com.example.ezcalculator.feature_exchange.domain.util.dropdown.DropdownState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ExchangeViewModel : ViewModel() {

    var state by mutableStateOf(ExchangeState())

    private var priceState by mutableStateOf(PriceState())

    fun onAction(action: ExchangeAction) {
        when (action) {
            is ExchangeAction.Number -> enterNumber(action.number)
            is ExchangeAction.Delete -> delete()
            is ExchangeAction.Clear -> state = ExchangeState(selectedExchanger = state.selectedExchanger, firstExchangerCurrency = state.firstExchangerCurrency, secondExchangerCurrency = state.secondExchangerCurrency)
            is ExchangeAction.Decimal -> enterDecimal()
            is ExchangeAction.SelectExchanger -> select(exchanger = action.exchanger)
        }
    }

    private fun select(exchanger: Exchanger) {
        state = state.copy(selectedExchanger = exchanger)
    }

    private fun enterNumber(number: Int) {
        val exchanger = state.selectedExchanger

        if (exchanger != null) {
            when (exchanger.id) {
                Exchanger.FirstExchanger.id -> {
                    val newValue = state.firstExchangerValue + number
                    calculate(newValue)
                }

                Exchanger.SecondExchanger.id -> {
                    val newValue = state.secondExchangerValue + number
                    calculate(newValue)
                }
            }
        }
    }

    private fun enterDecimal() {
        val exchanger = state.selectedExchanger
        if (exchanger != null) {
            when (exchanger.id) {
                Exchanger.FirstExchanger.id -> {
                    if (!state.firstExchangerValue.contains('.')) {
                        state = state.copy(firstExchangerValue = state.firstExchangerValue + ".")
                    }
                }

                Exchanger.SecondExchanger.id -> {
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
                Exchanger.FirstExchanger.id -> {
                    if (state.firstExchangerValue.isNotEmpty()) {
                        if (state.firstExchangerValue.count() > 1) {
                            val newValue = state.firstExchangerValue.dropLast(1)
                            calculate(newValue)
                        } else {
                            state = state.copy(firstExchangerValue = "", secondExchangerValue = "")
                        }
                    }
                }

                Exchanger.SecondExchanger.id -> {
                    if (state.secondExchangerValue.isNotEmpty()) {

                        if (state.secondExchangerValue.count() > 1) {
                            val newValue = state.secondExchangerValue.dropLast(1)
                            calculate(newValue)
                        } else {
                            state = state.copy(firstExchangerValue = "", secondExchangerValue = "")
                        }
                    }
                }
            }
        }
    }

    private fun calculate(newValue: String) {
        val exchanger = state.selectedExchanger

        if (exchanger != null) {
            state = when (exchanger) {
                Exchanger.FirstExchanger -> {
                    state.copy(
                        firstExchangerValue = newValue,
                        secondExchangerValue = (newValue.toDouble() * priceState.secondPrice).toString()
                    )
                }

                Exchanger.SecondExchanger -> {
                    state.copy(
                        secondExchangerValue = newValue,
                        firstExchangerValue = (newValue.toDouble() / priceState.secondPrice).toString()
                    )
                }
            }
        }
    }

    fun fetchShit(from: Currency, to: Currency, exchanger: Exchanger) {
        viewModelScope.launch {
            Log.d("test", "Started fetching...")
            withContext(Dispatchers.IO) {
                val fetchCurrency = FetchCurrencyPrice()
                priceState = when(exchanger) {
                    is Exchanger.FirstExchanger -> priceState.copy(firstPrice = fetchCurrency(from, to), secondPrice = 1.0)

                    is Exchanger.SecondExchanger -> priceState.copy(secondPrice = fetchCurrency(from, to), firstPrice = 1.0)
                }
                state = state.copy(
                    firstExchangerValue = priceState.firstPrice.toString(),
                    secondExchangerValue = priceState.secondPrice.toString()
                )
            }
            Log.d("test", "End fetching")
        }
    }
}