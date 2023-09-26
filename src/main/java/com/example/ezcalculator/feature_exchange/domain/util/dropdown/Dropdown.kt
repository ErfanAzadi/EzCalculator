package com.example.ezcalculator.feature_exchange.domain.util.dropdown

import com.example.ezcalculator.feature_exchange.domain.util.Currency

sealed class Dropdown(
    val id: String,
    val isExpanded: Boolean,
    val value: String,
    val selectedCurrency: Currency
) {
    class FirstDropdown(
        isExpanded: Boolean = false,
        value: String = "",
        selectedCurrency: Currency = Currency.DEFAULT
    ) : Dropdown(
        id = "firstDropdown",
        selectedCurrency = selectedCurrency,
        isExpanded = isExpanded,
        value = value
    )

    class SecondDropdown(
        isExpanded: Boolean = false,
        value: String = "",
        selectedCurrency: Currency = Currency.DEFAULT
    ) : Dropdown(
        id = "secondDropdown",
        selectedCurrency = selectedCurrency,
        isExpanded = isExpanded,
        value = value
    )
}
