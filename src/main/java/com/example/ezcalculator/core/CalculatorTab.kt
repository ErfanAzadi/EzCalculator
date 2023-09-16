package com.example.ezcalculator.core

sealed class CalculatorTab(val rout: String) {
    object Calculation: CalculatorTab("calculation")
    object Exchange: CalculatorTab("exchanger")
}