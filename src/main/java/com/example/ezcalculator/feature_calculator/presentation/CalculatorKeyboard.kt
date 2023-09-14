package com.example.ezcalculator.feature_calculator.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.ezcalculator.R
import com.example.ezcalculator.core.CalculatorButton
import com.example.ezcalculator.feature_calculator.data.CalculatorAction
import com.example.ezcalculator.feature_calculator.data.CalculatorOperation
import com.example.ezcalculator.feature_calculator.domain.CalculatorViewModel

@Composable
fun CalculatorKeyboard(modifier: Modifier, calculatorViewModel: CalculatorViewModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier)

    ) {
        // Start
        Column {
            Row(Modifier.weight(1f)) {
                CalculatorButton(
                    symbol = CalculatorOperation.Clear.symbol,
                    modifier = Modifier.weight(1f),
                    isOperation = true
                ) {
                    calculatorViewModel.onAction(CalculatorAction.Clear)
                }
                CalculatorButton(
                    symbol = CalculatorOperation.Divide.symbol,
                    modifier = Modifier.weight(1f),
                    isOperation = true
                ) {
                    calculatorViewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Divide))
                }
                CalculatorButton(
                    symbol = CalculatorOperation.Remainder.symbol,
                    modifier = Modifier.weight(1f),
                    isOperation = true
                ) {
                    calculatorViewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Remainder))
                }
                CalculatorButton(
                    icon = painterResource(id = R.drawable.ic_backspace),
                    modifier = Modifier.weight(1f),
                    isOperation = true
                ) {
                    calculatorViewModel.onAction(CalculatorAction.Delete)
                }
            }
            Row(Modifier.weight(1f)) {
                CalculatorButton(symbol = "7", modifier = Modifier.weight(1f)) {
                    calculatorViewModel.onAction(CalculatorAction.Number(7))
                }
                CalculatorButton(symbol = "8", modifier = Modifier.weight(1f)) {
                    calculatorViewModel.onAction(CalculatorAction.Number(8))
                }
                CalculatorButton(symbol = "9", modifier = Modifier.weight(1f)) {
                    calculatorViewModel.onAction(CalculatorAction.Number(9))
                }
                CalculatorButton(
                    symbol = CalculatorOperation.Multiply.symbol,
                    modifier = Modifier.weight(1f),
                    isOperation = true
                ) {
                    calculatorViewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Multiply))
                }
            }
            Row(Modifier.weight(1f)) {
                CalculatorButton(symbol = "4", modifier = Modifier.weight(1f)) {
                    calculatorViewModel.onAction(CalculatorAction.Number(4))
                }
                CalculatorButton(symbol = "5", modifier = Modifier.weight(1f)) {
                    calculatorViewModel.onAction(CalculatorAction.Number(5))
                }
                CalculatorButton(symbol = "6", modifier = Modifier.weight(1f)) {
                    calculatorViewModel.onAction(CalculatorAction.Number(6))
                }
                CalculatorButton(
                    symbol = CalculatorOperation.Add.symbol,
                    modifier = Modifier.weight(1f),
                    isOperation = true
                ) {
                    calculatorViewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Add))
                }
            }
            Row(Modifier.weight(1f)) {
                CalculatorButton(symbol = "1", modifier = Modifier.weight(1f)) {
                    calculatorViewModel.onAction(CalculatorAction.Number(1))
                }
                CalculatorButton(symbol = "2", modifier = Modifier.weight(1f)) {
                    calculatorViewModel.onAction(CalculatorAction.Number(2))
                }
                CalculatorButton(symbol = "3", modifier = Modifier.weight(1f)) {
                    calculatorViewModel.onAction(CalculatorAction.Number(3))
                }
                CalculatorButton(
                    symbol = CalculatorOperation.Subtract.symbol,
                    modifier = Modifier.weight(1f),
                    isOperation = true
                ) {
                    calculatorViewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Subtract))
                }
            }
            Row(Modifier.weight(1f)) {
                CalculatorButton(
                    symbol = CalculatorOperation.Decimal.symbol, modifier = Modifier.weight(1f)
                ) {
                    calculatorViewModel.onAction(CalculatorAction.Decimal)
                }
                CalculatorButton(symbol = "0", modifier = Modifier.weight(2f)) {
                    calculatorViewModel.onAction(CalculatorAction.Number(0))
                }
                CalculatorButton(symbol = "=", modifier = Modifier.weight(1f), isOperation = true) {
                    calculatorViewModel.onAction(CalculatorAction.Calculate)
                }
            }
        }
    }
}