package com.example.ezcalculator.feature_exchange.domain.use_case

data class ExchangeUseCases(
    val fetchCurrencyPrice: FetchCurrencyPrice,
    val convertCurrency: ConvertCurrency,
)
