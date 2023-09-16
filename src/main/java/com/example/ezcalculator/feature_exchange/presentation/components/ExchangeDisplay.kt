package com.example.ezcalculator.feature_exchange.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ezcalculator.R
import com.example.ezcalculator.feature_exchange.domain.ExchangeCountry
import com.example.ezcalculator.feature_exchange.domain.ExchangeAction
import com.example.ezcalculator.feature_exchange.domain.ExchangeViewModel
import com.example.ezcalculator.feature_exchange.domain.Exchanger

@Composable
fun ExchangeDisplay(exchangeViewModel: ExchangeViewModel, modifier: Modifier) {

    val state = exchangeViewModel.state
    val selectedExchanger = state.selectedExchanger

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
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            ExchangeRow(
                exchangeViewModel,
                country = ExchangeCountry(
                    flag = painterResource(id = R.drawable.us), title = "US Dollar"
                ), state.firstExchangerValue, Modifier.background(
                    color = if (selectedExchanger != null && selectedExchanger == Exchanger.First) {
                        colorResource(id = R.color.selectedBackground)
                    } else {
                        Color.Transparent
                    }
                )
            ) {
                exchangeViewModel.onAction(ExchangeAction.SelectExchanger(Exchanger.First))
            }

            ExchangeRow(
                exchangeViewModel,
                country = ExchangeCountry(
                    flag = painterResource(id = R.drawable.australia), title = "Australia Dollar"
                ), state.secondExchangerValue, Modifier.background(
                    color = if (selectedExchanger != null && selectedExchanger == Exchanger.Second) {
                        colorResource(id = R.color.selectedBackground)
                    } else {
                        Color.Transparent
                    }
                )
            ) {
                exchangeViewModel.onAction(ExchangeAction.SelectExchanger(Exchanger.Second))
            }
        }
    }
}

@Composable
private fun ExchangeRow(viewModel: ExchangeViewModel, country: ExchangeCountry, amount: String, modifier: Modifier, onClick: () -> Unit) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .clip(RoundedCornerShape(5.dp))
        .clickable { onClick() }
        .then(modifier)
        .padding(horizontal = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(5.dp)) {
        Image(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .size(25.dp)
                .clickable {
                    viewModel.state =
                        viewModel.state.copy(changeExchanger = !viewModel.state.changeExchanger)
                },
            painter = country.flag,
            contentDescription = null
        )
        Text(
            text = country.title,
            color = colorResource(id = R.color.numberColor),
            fontSize = 16.sp,
            fontWeight = FontWeight.ExtraBold
        )
        Image(
            modifier = Modifier
                .clip(CircleShape)
                .size(20.dp),
            painter = painterResource(id = R.drawable.ic_arrow_right),
            contentDescription = null,
            colorFilter = ColorFilter.tint(color = colorResource(id = R.color.numberColor))
        )
        Text(
            text = amount,
            color = colorResource(id = R.color.numberColor),
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}