package com.example.ezcalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.core.view.WindowCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ezcalculator.util.Screens
import com.example.ezcalculator.feature_calculate.domain.CalculateViewModel
import com.example.ezcalculator.feature_calculate.presentation.CalculatorScreen
import com.example.ezcalculator.feature_exchange.ExchangeViewModel
import com.example.ezcalculator.feature_exchange.presentation.ExchangeScreen
import com.example.ezcalculator.ui.theme.EzCalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            EzCalculatorTheme {
                val navController = rememberNavController()
                val calculateViewModel = viewModel<CalculateViewModel>()
                val exchangeViewModel = viewModel<ExchangeViewModel>()

                // Added box to prevent screen flashing while navigating
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = colorResource(id = R.color.primaryColor))
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = Screens.Calculation.rout
                    ) {
                        composable(Screens.Calculation.rout) {
                            CalculatorScreen(calculateViewModel, navController)
                        }
                        composable(Screens.Exchange.rout) {
                            ExchangeScreen(exchangeViewModel, navController)
                        }
                    }
                }
            }
        }
    }
}