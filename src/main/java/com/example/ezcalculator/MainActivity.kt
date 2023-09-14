package com.example.ezcalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import com.example.ezcalculator.feature_calculator.presentation.CalculatorScreen
import com.example.ezcalculator.ui.theme.EzCalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            EzCalculatorTheme {
                CalculatorScreen()
            }
        }
    }
}