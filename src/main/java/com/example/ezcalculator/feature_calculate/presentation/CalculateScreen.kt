package com.example.ezcalculator.feature_calculate.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ezcalculator.R
import com.example.ezcalculator.core.access_bar.CalculatorAccessBar
import com.example.ezcalculator.core.tab_bar.CalculatorTabBar
import com.example.ezcalculator.feature_calculate.domain.CalculateViewModel
import com.example.ezcalculator.feature_calculate.presentation.components.CalculatorDisplay
import com.example.ezcalculator.feature_calculate.presentation.components.CalculatorKeyboard

@Composable
fun CalculatorScreen(viewModel: CalculateViewModel, navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.primaryColor))
    ) {
        Column(
            modifier = Modifier
                .safeDrawingPadding()
                .padding(horizontal = 20.dp, vertical = 30.dp)
        ) {
            CalculatorTabBar(navController)

            CalculatorDisplay(modifier = Modifier.weight(0.4f), viewModel)

            CalculatorAccessBar()

            CalculatorKeyboard(modifier = Modifier.weight(1f), viewModel)
        }
    }
}
