package com.example.ezcalculator.feature_calculator.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ezcalculator.R
import com.example.ezcalculator.feature_calculator.data.CalculatorState

@Composable
fun CalculatorDisplay(modifier: Modifier, state: CalculatorState) {
    Card(
        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.displayColor)),
        modifier = Modifier
            .background(Color.Transparent)
            .fillMaxWidth()
            .then(modifier), // Set weight
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp),
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Bottom
        ) {
            Text(
                text = state.number1 + (state.operation?.symbol ?: "") + state.number2,
                color = colorResource(id = R.color.inputTextColor),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 5,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
}