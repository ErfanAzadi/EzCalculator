package com.example.ezcalculator.feature_calculate.domain

data class CalculateState(
    var number1: String = "",
    var number2: String = "",
    var operation: CalculateOperation? = null
)