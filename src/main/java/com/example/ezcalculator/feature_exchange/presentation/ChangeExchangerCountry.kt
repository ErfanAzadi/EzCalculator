package com.example.ezcalculator.feature_exchange.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ezcalculator.R
import com.example.ezcalculator.feature_exchange.domain.ExchangeItems
import com.example.ezcalculator.feature_exchange.domain.ExchangeViewModel
import com.example.ezcalculator.feature_exchange.presentation.components.ExchangeItem

@Composable
fun ChangeExchangerCountry(viewModel: ExchangeViewModel, onClose: () -> Unit) {
    val scWidth = LocalConfiguration.current.screenWidthDp
    val scHeight = LocalConfiguration.current.screenHeightDp
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xB3000000))
            .clickable(onClick = { /* Do nothing */ }), contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .width((scWidth / 1.2).dp)
                .height((scHeight / 2).dp)
                .clip(RoundedCornerShape(12.dp))
                .background(colorResource(id = R.color.primaryColor))
        ) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .background(colorResource(id = R.color.buttonColor))
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Change Currency",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = colorResource(id = R.color.numberColor)
                )
                Image(
                    modifier = Modifier
                        .size(20.dp)
                        .clickable { onClose() },
                    painter = painterResource(id = R.drawable.ic_close),
                    contentDescription = "close button",
                    colorFilter = ColorFilter.tint(color = colorResource(id = R.color.numberColor))
                )
            }



            LazyColumn(modifier = Modifier.weight(1f)) {
                items(items = ExchangeItems.list) {
                    ExchangeItem(it) {
                        println("You clicked on : " + it.title)
                        // Set state selected currency here....
                    }
                }
            }
        }
    }
}