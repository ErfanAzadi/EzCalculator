package com.example.ezcalculator.feature_calculator.presentation.access_bar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ezcalculator.feature_calculator.presentation.access_bar.components.CalculatorHistory
import com.example.ezcalculator.feature_calculator.presentation.access_bar.components.CalculatorSettings

@Composable
fun CalculatorAccessBar() {
    Row(
        modifier = Modifier.padding(vertical = 15.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        CalculatorHistory {

        }
        CalculatorSettings {

        }
        /*
        CalculatorTheme {

        }
        */
    }
}