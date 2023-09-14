package com.example.ezcalculator.feature_calculator.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ezcalculator.R
import com.example.ezcalculator.feature_calculator.domain.CalculatorViewModel
import com.example.ezcalculator.feature_calculator.presentation.access_bar.CalculatorAccessBar

@Preview
@Composable
fun CalculatorScreen() {
    val viewModel = viewModel<CalculatorViewModel>()
    val state = viewModel.state

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.primaryColor))
    ) {
        Column(
            modifier = Modifier
                .safeDrawingPadding()
                .padding(horizontal = 20.dp, vertical = 40.dp)
        ) {
            CalculatorDisplay(modifier = Modifier.weight(0.4f), state)

            CalculatorAccessBar()

            CalculatorKeyboard(modifier = Modifier.weight(1f), viewModel)
        }
    }
}