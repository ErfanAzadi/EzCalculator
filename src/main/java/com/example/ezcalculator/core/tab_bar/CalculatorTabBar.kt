package com.example.ezcalculator.core.tab_bar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ezcalculator.R
import com.example.ezcalculator.core.CalculatorTab

@Composable
fun CalculatorTabBar(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        TabButton(title = "Calculator") {
            if (navController.currentBackStackEntry?.destination?.route != CalculatorTab.Calculation.rout) {
                navController.navigate(CalculatorTab.Calculation.rout)
            }
        }
        TabButton(title = "Exchange") {
            if (navController.currentBackStackEntry?.destination?.route != CalculatorTab.Exchange.rout) {
                navController.navigate(CalculatorTab.Exchange.rout)
            }
        }
    }
}

@Composable
private fun TabButton(title: String, onClick: () -> Unit) {
    Button(
        onClick = { onClick() }, shape = CircleShape, colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(id = R.color.buttonColor),
            contentColor = colorResource(id = R.color.numberColor)
        ), elevation = ButtonDefaults.buttonElevation(10.dp)
    ) {
        Text(text = title, fontSize = 15.sp)
    }
}