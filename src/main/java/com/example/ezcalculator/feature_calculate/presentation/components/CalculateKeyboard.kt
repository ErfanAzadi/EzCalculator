package com.example.ezcalculator.feature_calculate.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.ezcalculator.R
import com.example.ezcalculator.core.button.CalculatorButton
import com.example.ezcalculator.feature_calculate.domain.CalculateAction
import com.example.ezcalculator.feature_calculate.domain.CalculateOperation
import com.example.ezcalculator.feature_calculate.domain.CalculateViewModel

@Composable
fun CalculatorKeyboard(modifier: Modifier, calculatorViewModel: CalculateViewModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier)

    ) {
        // Start
        Column {
            Row(Modifier.weight(1f)) {
                CalculatorButton(
                    symbol = CalculateOperation.Clear.symbol,
                    modifier = Modifier.weight(1f),
                    isOperation = true
                ) {
                    calculatorViewModel.onAction(CalculateAction.Clear)
                }
                CalculatorButton(
                    symbol = CalculateOperation.Divide.symbol,
                    modifier = Modifier.weight(1f),
                    isOperation = true
                ) {
                    calculatorViewModel.onAction(CalculateAction.Operation(CalculateOperation.Divide))
                }
                CalculatorButton(
                    symbol = CalculateOperation.Remainder.symbol,
                    modifier = Modifier.weight(1f),
                    isOperation = true
                ) {
                    calculatorViewModel.onAction(CalculateAction.Operation(CalculateOperation.Remainder))
                }
                CalculatorButton(
                    icon = painterResource(id = R.drawable.ic_backspace),
                    modifier = Modifier.weight(1f),
                    isOperation = true
                ) {
                    calculatorViewModel.onAction(CalculateAction.Delete)
                }
            }
            Row(Modifier.weight(1f)) {
                CalculatorButton(symbol = "7", modifier = Modifier.weight(1f)) {
                    calculatorViewModel.onAction(CalculateAction.Number(7))
                }
                CalculatorButton(symbol = "8", modifier = Modifier.weight(1f)) {
                    calculatorViewModel.onAction(CalculateAction.Number(8))
                }
                CalculatorButton(symbol = "9", modifier = Modifier.weight(1f)) {
                    calculatorViewModel.onAction(CalculateAction.Number(9))
                }
                CalculatorButton(
                    symbol = CalculateOperation.Multiply.symbol,
                    modifier = Modifier.weight(1f),
                    isOperation = true
                ) {
                    calculatorViewModel.onAction(CalculateAction.Operation(CalculateOperation.Multiply))
                }
            }
            Row(Modifier.weight(1f)) {
                CalculatorButton(symbol = "4", modifier = Modifier.weight(1f)) {
                    calculatorViewModel.onAction(CalculateAction.Number(4))
                }
                CalculatorButton(symbol = "5", modifier = Modifier.weight(1f)) {
                    calculatorViewModel.onAction(CalculateAction.Number(5))
                }
                CalculatorButton(symbol = "6", modifier = Modifier.weight(1f)) {
                    calculatorViewModel.onAction(CalculateAction.Number(6))
                }
                CalculatorButton(
                    symbol = CalculateOperation.Add.symbol,
                    modifier = Modifier.weight(1f),
                    isOperation = true
                ) {
                    calculatorViewModel.onAction(CalculateAction.Operation(CalculateOperation.Add))
                }
            }
            Row(Modifier.weight(1f)) {
                CalculatorButton(symbol = "1", modifier = Modifier.weight(1f)) {
                    calculatorViewModel.onAction(CalculateAction.Number(1))
                }
                CalculatorButton(symbol = "2", modifier = Modifier.weight(1f)) {
                    calculatorViewModel.onAction(CalculateAction.Number(2))
                }
                CalculatorButton(symbol = "3", modifier = Modifier.weight(1f)) {
                    calculatorViewModel.onAction(CalculateAction.Number(3))
                }
                CalculatorButton(
                    symbol = CalculateOperation.Subtract.symbol,
                    modifier = Modifier.weight(1f),
                    isOperation = true
                ) {
                    calculatorViewModel.onAction(CalculateAction.Operation(CalculateOperation.Subtract))
                }
            }
            Row(Modifier.weight(1f)) {
                CalculatorButton(
                    symbol = CalculateOperation.Decimal.symbol, modifier = Modifier.weight(1f)
                ) {
                    calculatorViewModel.onAction(CalculateAction.Decimal)
                }
                CalculatorButton(symbol = "0", modifier = Modifier.weight(2f)) {
                    calculatorViewModel.onAction(CalculateAction.Number(0))
                }
                CalculatorButton(symbol = "=", modifier = Modifier.weight(1f), isOperation = true) {
                    calculatorViewModel.onAction(CalculateAction.Calculate)
                }
            }
        }
    }
}