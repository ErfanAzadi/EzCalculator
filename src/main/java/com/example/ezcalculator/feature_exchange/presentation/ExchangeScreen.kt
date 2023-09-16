package com.example.ezcalculator.feature_exchange.presentation

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
import com.example.ezcalculator.feature_exchange.domain.ExchangeViewModel
import com.example.ezcalculator.feature_exchange.presentation.components.ExchangeDisplay
import com.example.ezcalculator.feature_exchange.presentation.components.ExchangeKeyboard

@Composable
fun ExchangeScreen(exchangeViewModel: ExchangeViewModel, navController: NavController) {
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

            ExchangeDisplay(exchangeViewModel, Modifier.weight(0.4f))

            CalculatorAccessBar()

            ExchangeKeyboard(exchangeViewModel, modifier = Modifier.weight(1f))
        }
    }

    if (exchangeViewModel.state.changeExchanger) {
        ChangeExchangerCountry(exchangeViewModel) {
            exchangeViewModel.state =
                exchangeViewModel.state.copy(changeExchanger = !exchangeViewModel.state.changeExchanger)
        }
    }
}