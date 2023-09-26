package com.example.ezcalculator.feature_exchange.domain.use_case

import android.util.Log
import com.example.ezcalculator.feature_exchange.domain.util.Currency
import com.example.ezcalculator.feature_exchange.domain.util.PriceLevel
import org.json.JSONObject
import java.net.URL

class FetchCurrencyPrice {
    operator fun invoke(from: Currency, to: Currency, priceLevel: PriceLevel = PriceLevel.Average): Double {
        val jsonString = URL("https://www.xe.com/_next/data/oBdMwufpRa2-k5rgNi0FG/en/currencyconverter/convert.json?Amount=1&From=${from.id}&To=${to.id}").readText()
        val jsonObject = JSONObject(jsonString)

        val pageProps = jsonObject.getJSONObject("pageProps")
        val manifest = pageProps.getJSONObject("dataManifest")
        val data = manifest.getJSONObject("5q0Os46sTrMffELfksN8Bc")
        val last1Days = data.getJSONObject("last1Days")

        Log.d("test", "Fetch Result is : " + last1Days.getDouble(priceLevel.level))
        return last1Days.getDouble(priceLevel.level)
    }
}