package com.example.ezcalculator.util

sealed class Screens(val rout: String) {
    object Calculation: Screens("calculation")
    object Exchange: Screens("exchanger")
}