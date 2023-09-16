package com.example.ezcalculator.feature_exchange.domain

sealed class Exchanger(val id: String) {
    object First: Exchanger("1")
    object Second: Exchanger("2")
}
