package com.example.ezcalculator.core

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ezcalculator.R

@Composable
fun CalculatorButton(
    modifier: Modifier,
    symbol: String? = null,
    icon: Painter? = null,
    isOperation: Boolean = false,
    onClick: () -> Unit
) {
    Button(
        shape = RoundedCornerShape(10.dp),
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp),
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(id = R.color.buttonColor),
            contentColor = colorResource(id = if (isOperation) R.color.operationColor else R.color.numberColor)
        ),
        elevation = ButtonDefaults.buttonElevation(7.dp)
    ) {
        if (symbol != null) {
            Text(
                text = symbol,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp
            )
        }
        if (icon != null) {
            Image(
                painter = icon,
                contentDescription = null,
                alignment = Alignment.Center,
                colorFilter = ColorFilter.tint(colorResource(id = if (isOperation) R.color.operationColor else R.color.numberColor))
            )
        }
    }
}