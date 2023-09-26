package com.example.ezcalculator.feature_exchange.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.ezcalculator.R
import com.example.ezcalculator.common.CalculatorButton
import com.example.ezcalculator.feature_calculate.domain.util.CalculateOperation
import com.example.ezcalculator.feature_exchange.domain.util.ExchangeAction
import com.example.ezcalculator.feature_exchange.ExchangeViewModel

@Composable
fun ExchangeKeyboard(exchangeViewModel: ExchangeViewModel, modifier: Modifier) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier)

    ) {
        // TODO: Replace with repeat() the keyboard
        Column {
            Row(Modifier.weight(1f)) {
                CalculatorButton(symbol = "7", modifier = Modifier.weight(1f)) {
                    exchangeViewModel.onAction(ExchangeAction.Number(7))
                }
                CalculatorButton(symbol = "8", modifier = Modifier.weight(1f)) {
                    exchangeViewModel.onAction(ExchangeAction.Number(8))
                }
                CalculatorButton(symbol = "9", modifier = Modifier.weight(1f)) {
                    exchangeViewModel.onAction(ExchangeAction.Number(9))
                }
                CalculatorButton(
                    icon = painterResource(id = R.drawable.ic_backspace),
                    modifier = Modifier.weight(1f),
                    isOperation = true
                ) {
                    exchangeViewModel.onAction(ExchangeAction.Delete)
                }
            }
            Row(Modifier.weight(1f)) {
                CalculatorButton(symbol = "4", modifier = Modifier.weight(1f)) {
                    exchangeViewModel.onAction(ExchangeAction.Number(4))
                }
                CalculatorButton(symbol = "5", modifier = Modifier.weight(1f)) {
                    exchangeViewModel.onAction(ExchangeAction.Number(5))
                }
                CalculatorButton(symbol = "6", modifier = Modifier.weight(1f)) {
                    exchangeViewModel.onAction(ExchangeAction.Number(6))
                }
                CalculatorButton(
                    symbol = CalculateOperation.Clear.symbol,
                    modifier = Modifier.weight(1f),
                    isOperation = true
                ) {
                    exchangeViewModel.onAction(ExchangeAction.Clear)
                }
            }
            Row(Modifier.weight(1f)) {
                CalculatorButton(symbol = "1", modifier = Modifier.weight(1f)) {
                    exchangeViewModel.onAction(ExchangeAction.Number(1))
                }
                CalculatorButton(symbol = "2", modifier = Modifier.weight(1f)) {
                    exchangeViewModel.onAction(ExchangeAction.Number(2))
                }
                CalculatorButton(symbol = "3", modifier = Modifier.weight(1f)) {
                    exchangeViewModel.onAction(ExchangeAction.Number(3))
                }
                Spacer(modifier = Modifier.weight(1f))
            }
            Row(Modifier.weight(1f)) {
                CalculatorButton(
                    symbol = CalculateOperation.Decimal.symbol, modifier = Modifier.weight(1f)
                ) {
                    exchangeViewModel.onAction(ExchangeAction.Decimal)
                }
                CalculatorButton(symbol = "0", modifier = Modifier.weight(2f)) {
                    exchangeViewModel.onAction(ExchangeAction.Number(0))
                }
                Spacer(modifier = Modifier.weight(1f))
            }
            Spacer(Modifier.weight(1f))
        }
    }
}