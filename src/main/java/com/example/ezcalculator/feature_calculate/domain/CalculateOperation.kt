package com.example.ezcalculator.feature_calculate.domain

sealed class CalculateOperation(val symbol: String) {
    object Add: CalculateOperation("+")
    object Subtract: CalculateOperation("-")
    object Multiply: CalculateOperation("x")
    object Divide: CalculateOperation("÷")
    object Remainder : CalculateOperation("%")
    object Decimal : CalculateOperation(".")
    object Clear : CalculateOperation("C")
}