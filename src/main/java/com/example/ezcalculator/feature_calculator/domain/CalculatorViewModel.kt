package com.example.ezcalculator.feature_calculator.domain

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.ezcalculator.feature_calculator.data.CalculatorAction
import com.example.ezcalculator.feature_calculator.data.CalculatorOperation
import com.example.ezcalculator.feature_calculator.data.CalculatorState

class CalculatorViewModel : ViewModel() {

    var state by mutableStateOf(CalculatorState())

    fun onAction(action: CalculatorAction) {
        when (action) {
            is CalculatorAction.Number -> enterNumber(action.number)
            is CalculatorAction.Delete -> delete()
            is CalculatorAction.Clear -> state = CalculatorState()
            is CalculatorAction.Operation -> enterOperation(action.operation)
            is CalculatorAction.Decimal -> enterDecimal()
            is CalculatorAction.Calculate -> calculate()
        }
    }

    private fun enterNumber(number: Int) {
        if (state.operation != null) {
            state = state.copy(number2 = state.number2 + number)
            return
        }
        state = state.copy(number1 = state.number1 + number)
    }

    private fun enterOperation(operation: CalculatorOperation) {
        if (state.number1.isNotEmpty()) {
            if (state.number2.isNotEmpty()) {
                calculate(setOperation = operation)
                return
            }
            state = state.copy(operation = operation)
        }
    }

    private fun enterDecimal() {
        if (state.operation == null && !state.number1.contains(CalculatorOperation.Decimal.symbol) && state.number1.isNotBlank()) {
            state = state.copy(number1 = state.number1 + CalculatorOperation.Decimal.symbol)
            return
        } else if (!state.number2.contains(CalculatorOperation.Decimal.symbol) && state.number2.isNotBlank()) {
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

    private fun calculate(setOperation: CalculatorOperation? = null) {
        val number1 = state.number1.toDoubleOrNull()
        val number2 = state.number2.toDoubleOrNull()

        if (number1 != null && number2 != null) {
            val result = when (state.operation) {
                is CalculatorOperation.Add -> number1 + number2
                is CalculatorOperation.Subtract -> number1 - number2
                is CalculatorOperation.Multiply -> number1 * number2
                is CalculatorOperation.Divide -> number1 / number2
                is CalculatorOperation.Remainder -> number1 % number2
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