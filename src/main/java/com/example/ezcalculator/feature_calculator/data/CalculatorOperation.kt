package com.example.ezcalculator.feature_calculator.data

sealed class CalculatorOperation(val symbol: String) {
    object Add: CalculatorOperation("+")
    object Subtract: CalculatorOperation("-")
    object Multiply: CalculatorOperation("x")
    object Divide: CalculatorOperation("÷")
    object Remainder : CalculatorOperation("%")
    object Decimal : CalculatorOperation(".")
    object Clear : CalculatorOperation("C")
}