package com.example.ezcalculator.feature_exchange.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ezcalculator.R
import com.example.ezcalculator.feature_exchange.domain.ExchangeItem

@Composable
fun ExchangeItem(item: ExchangeItem, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .padding(horizontal = 10.dp, vertical = 6.dp)
            .clickable { onClick() },
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = item.resourceId),
            contentDescription = item.title,
            modifier = Modifier.size(30.dp)
        )
        Text(
            text = item.title,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(
                id = R.color.numberColor
            )
        )
    }
}