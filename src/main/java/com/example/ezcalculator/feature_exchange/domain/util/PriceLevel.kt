package com.example.ezcalculator.feature_exchange.domain.util

sealed class PriceLevel(val level: String) {
    object Low: PriceLevel("low")
    object High: PriceLevel("high")
    object Average: PriceLevel("average")
}