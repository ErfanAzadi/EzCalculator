package com.example.ezcalculator.core.access_bar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ezcalculator.R

@Composable
fun CalculatorAccessBar() {
    Row(
        modifier = Modifier.padding(vertical = 15.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        AccessBarButton(painterResource(id = R.drawable.ic_history)) {

        }
        AccessBarButton(painterResource(id = R.drawable.ic_settings)) {

        }
        AccessBarButton(painterResource(id = R.drawable.ic_theme)) {

        }
    }
}