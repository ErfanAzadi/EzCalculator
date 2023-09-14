package com.example.ezcalculator.feature_calculator.presentation.access_bar.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.ezcalculator.R

@Composable
fun CalculatorSettings(size: Dp = 25.dp, onClick: () -> Unit) {
    Image(
        modifier = Modifier
            .size(size)
            .clickable { onClick() },
        painter = painterResource(id = R.drawable.ic_settings),
        contentDescription = "calculator settings",
        colorFilter = ColorFilter.tint(colorResource(id = R.color.iconColor))
    )
}