package com.example.ezcalculator.feature_exchange.domain.util

import com.example.ezcalculator.R

sealed class Currency(
    val name: String,
    val id: String,
    val flag: Int
) {
    object USD: Currency(name = "US Dollar", id = "USD", flag = R.drawable.us)
    object EUR: Currency(name = "Euro", id = "EUR", flag = R.drawable.euro)
    object CAD: Currency(name = "Canadian Dollar", id = "CAD", flag = R.drawable.canada)
    object AUD: Currency(name = "Australian Dollar", id = "AUD", flag = R.drawable.australia)
    object JPY: Currency(name = "Japanese Yen", id = "JPY", flag = R.drawable.japan)
    object GBP: Currency(name = "British Pound", id = "GBP", flag = R.drawable.uk)
    object IRR: Currency(name = "Iranian Rial", id = "IRR", flag = R.drawable.iran)
    object TRY: Currency(name = "Turkish Lira", id = "TRY", flag = R.drawable.turkey)
    object RUB: Currency(name = "Russian Ruble", id = "RUB", flag = R.drawable.russia)

    object DEFAULT: Currency(name = "Select", id = "Select", flag = R.drawable.ic_default_flag)
}