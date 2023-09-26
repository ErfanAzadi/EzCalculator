package com.example.ezcalculator.feature_exchange.domain.util

import java.math.BigDecimal

data class ExchangeState(
    var firstExchangerValue: String = "",
    var firstExchangerCurrency: Currency = Currency.DEFAULT,

    var secondExchangerValue: String = "",
    var secondExchangerCurrency: Currency = Currency.DEFAULT,

    var changeExchanger: Boolean = false,
    var selectedExchanger: Exchanger? = null
)