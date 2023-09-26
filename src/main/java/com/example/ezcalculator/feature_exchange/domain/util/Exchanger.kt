package com.example.ezcalculator.feature_exchange.domain.util

sealed class Exchanger(val id: String) {
    object FirstExchanger: Exchanger("firstExchanger")
    object SecondExchanger: Exchanger("secondExchanger")
}