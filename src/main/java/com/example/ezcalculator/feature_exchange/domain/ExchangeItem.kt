package com.example.ezcalculator.feature_exchange.domain

import com.example.ezcalculator.R

sealed class ExchangeItem(val title: String, val resourceId: Int) {
    object UsDollar : ExchangeItem("US Dollar", R.drawable.us)
    object AuDollar : ExchangeItem("AU Dollar", R.drawable.australia)
    object CaDollar : ExchangeItem("CA Dollar", R.drawable.canada)
    object Pound : ExchangeItem("Pound sterling", R.drawable.uk)
    object Euro : ExchangeItem("Euro", R.drawable.euro)
    object Yen : ExchangeItem("Japan Yen", R.drawable.japan)
    object Yuan : ExchangeItem("Chinese Yuan", R.drawable.china)
    object Rial : ExchangeItem("Iran Rials", R.drawable.iran)
}