package com.example.ezcalculator.feature_calculate.domain

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.ezcalculator.feature_calculate.domain.util.CalculateAction
import com.example.ezcalculator.feature_calculate.domain.util.CalculateOperation
import com.example.ezcalculator.feature_calculate.domain.util.CalculateState

class CalculateViewModel : ViewModel() {

    var state by mutableStateOf(CalculateState())

    fun onAction(action: CalculateAction) {
        when (action) {
            is CalculateAction.Number -> enterNumber(action.number)
            is CalculateAction.Delete -> delete()
            is CalculateAction.Clear -> state = CalculateState()
            is CalculateAction.Operation -> enterOperation(action.operation)
            is CalculateAction.Decimal -> enterDecimal()
            is CalculateAction.Calculate -> calculate()
        }
    }

    private fun enterNumber(number: Int) {
        if (state.operation != null) {
            state = state.copy(number2 = state.number2 + number)
            return
        }
        state = state.copy(number1 = state.number1 + number)
    }

    private fun enterOperation(operation: CalculateOperation) {
        if (state.number1.isNotEmpty()) {
            if (state.number2.isNotEmpty()) {
                calculate(setOperation = operation)
                return
            }
            state = state.copy(operation = operation)
        }
    }

    private fun enterDecimal() {
        if (state.operation == null && !state.number1.contains(CalculateOperation.Decimal.symbol) && state.number1.isNotBlank()) {
            state = state.copy(number1 = state.number1 + CalculateOperation.Decimal.symbol)
            return
        } else if (!state.number2.contains(CalculateOperation.Decimal.symbol) && state.number2.isNotBlank()) {
            state = state.copy(number2 = state.number2 + ".")
        }
    }

    private fun delete() {
        when {
            state.number2.isNotBlank() -> state = state.copy(number2 = state.number2.dropLast(1))

            state.operation != null -> state = state.copy(operation = null)

            state.number1.isNotBlank() -> state = state.copy(number1 = state.number1.dropLast(1))
        }
    }

    private fun calculate(setOperation: CalculateOperation? = null) {
        val number1 = state.number1.toDoubleOrNull()
        val number2 = state.number2.toDoubleOrNull()

        if (number1 != null && number2 != null) {
            val result = when (state.operation) {
                is CalculateOperation.Add -> number1 + number2
                is CalculateOperation.Subtract -> number1 - number2
                is CalculateOperation.Multiply -> number1 * number2
                is CalculateOperation.Divide -> number1 / number2
                is CalculateOperation.Remainder -> number1 % number2
                null -> return
                else -> return
            }

            // Will show the result better
            val finalResult = if (result % 1 == 0.0) {
                result.toInt().toString()
            } else {
                result.toString()
            }

            state = state.copy(
                number1 = finalResult.take(15), number2 = "", operation = setOperation
            )
        }
    }
}