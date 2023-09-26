package com.example.ezcalculator.feature_calculate.domain.util

sealed class CalculateAction {
    data class Number(val number: Int): CalculateAction()
    object Clear: CalculateAction()
    object Delete: CalculateAction()
    data class Operation(val operation: CalculateOperation): CalculateAction()
    object Calculate: CalculateAction()
    object Decimal: CalculateAction()
}