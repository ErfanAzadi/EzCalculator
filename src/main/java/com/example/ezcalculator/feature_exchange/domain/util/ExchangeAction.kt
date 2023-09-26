package com.example.ezcalculator.feature_exchange.domain.util


sealed class ExchangeAction {
    data class Number(val number: Int): ExchangeAction()
    data class SelectExchanger(val exchanger: Exchanger): ExchangeAction()
    object Clear: ExchangeAction()
    object Delete: ExchangeAction()
    object Decimal: ExchangeAction()
}