package com.example.ezcalculator.feature_exchange.domain

data class ExchangeState(
    var firstExchangerValue: String = "",
    var firstExchangerCountry: String = "",

    var secondExchangerValue: String = "",
    var secondExchangerCountry: String = "",

    var changeExchanger: Boolean = false,
    var selectedExchanger: Exchanger? = null
)