package com.example.ezcalculator.feature_exchange.domain.use_case

import com.example.ezcalculator.feature_exchange.domain.util.Currency

class ConvertCurrency {

    operator fun invoke(from: Currency, to: Currency): Double {
        val fromPrice = 0.0
        val toPrice = 0.0
        val result = fromPrice * toPrice

        // Multiply their values (Get them from state) And return (Update the state everytime they want to choose converting currencies)

        return result
    }
}