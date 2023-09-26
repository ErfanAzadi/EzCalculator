package com.example.ezcalculator.feature_exchange.presentation.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ezcalculator.R
import com.example.ezcalculator.feature_exchange.ExchangeViewModel
import com.example.ezcalculator.feature_exchange.domain.util.Currency
import com.example.ezcalculator.feature_exchange.domain.util.Exchanger
import com.example.ezcalculator.feature_exchange.presentation.components.exchanger.ExchangerItem

@Composable
fun ExchangeDisplay(exchangeViewModel: ExchangeViewModel, modifier: Modifier) {
    Column(
        modifier = Modifier
            .background(Color.Transparent)
            .fillMaxWidth()
            .then(modifier), // Set weight
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        // First Exchanger
        exchanger(exchangeViewModel, Exchanger.FirstExchanger, modifier = modifier.weight(1f)) {
            // Choose this as selected exchanger
            exchangeViewModel.state = exchangeViewModel.state.copy(selectedExchanger = Exchanger.FirstExchanger)
        }
        // Second Exchanger
        exchanger(exchangeViewModel, Exchanger.SecondExchanger, modifier = modifier.weight(1f)) {
            // Choose this as selected exchanger
            exchangeViewModel.state = exchangeViewModel.state.copy(selectedExchanger = Exchanger.SecondExchanger)
        }
    }
}

@Composable
private fun exchanger(viewModel: ExchangeViewModel, exchanger: Exchanger, modifier: Modifier, onSelect: () -> Unit) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = colorResource(id = if (viewModel.state.selectedExchanger == exchanger) R.color.selectedBackground else R.color.displayColor),
                shape = RoundedCornerShape(15.dp)
            )
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ) {
                onSelect()
            },
        verticalAlignment = Alignment.CenterVertically,
    ) {
        exchangerDropdown(viewModel, exchanger) { currency ->
            when(exchanger) {
                is Exchanger.FirstExchanger -> {
                    viewModel.state = viewModel.state.copy(firstExchangerCurrency = currency)
                    if (viewModel.state.secondExchangerCurrency != Currency.DEFAULT)
                        viewModel.fetchShit(viewModel.state.firstExchangerCurrency, viewModel.state.secondExchangerCurrency, Exchanger.FirstExchanger)
                    }
                is Exchanger.SecondExchanger -> {
                    viewModel.state = viewModel.state.copy(secondExchangerCurrency = currency)
                    if (viewModel.state.firstExchangerCurrency != Currency.DEFAULT) {
                        viewModel.fetchShit(viewModel.state.firstExchangerCurrency, viewModel.state.secondExchangerCurrency, Exchanger.SecondExchanger)
                    }
                }
            }
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = Color.Transparent,
                    shape = RoundedCornerShape(topEnd = 15.dp, bottomEnd = 15.dp)
                )
                .padding(10.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = when(exchanger) {
                    is Exchanger.FirstExchanger -> viewModel.state.firstExchangerValue
                    is Exchanger.SecondExchanger -> viewModel.state.secondExchangerValue
                },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun exchangerDropdown(
    viewModel: ExchangeViewModel,
    exchanger: Exchanger,
    onSelectCurrency: (Currency) -> Unit
) {
    val exchangerItem = ExchangerItem()
    var isExpanded by remember { mutableStateOf(false) }
    var selectedCurrency by remember {
        val savedCurrency = when(exchanger) {
            Exchanger.FirstExchanger -> viewModel.state.firstExchangerCurrency
            Exchanger.SecondExchanger -> viewModel.state.secondExchangerCurrency
        }
        mutableStateOf<Currency>(savedCurrency)
    }

    ExposedDropdownMenuBox(
        expanded = isExpanded,
        onExpandedChange = { newValue ->
            isExpanded = newValue
        }
    ) {
        TextField(
            value = "",
            onValueChange = {},
            readOnly = true,
            trailingIcon = {
                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(10.dp)) {
                    Image(painter = painterResource(id = selectedCurrency.flag), contentDescription = null, modifier = Modifier.size(20.dp))
                    Spacer(modifier = Modifier.weight(1f))

                    Text(text = selectedCurrency.id)

                    Spacer(modifier = Modifier.weight(1f))
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
                }

            },
            placeholder = {
                Text(text = selectedCurrency.name)
            },
            colors = ExposedDropdownMenuDefaults.textFieldColors(),
            modifier = Modifier
                .menuAnchor()
                .width(110.dp)
                .clip(RoundedCornerShape(topStart = 15.dp, bottomStart = 15.dp))
        )
        ExposedDropdownMenu(
            expanded = isExpanded,
            onDismissRequest = {
                isExpanded = false
            }
        ) {
            ExchangerItem.list.forEach { currency ->
                DropdownMenuItem(
                    text = { exchangerItem(currency) },
                    onClick = {
                        isExpanded = false
                        selectedCurrency = currency
                        onSelectCurrency(currency)
                    }
                )
            }
        }
    }
}


/*
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun exchangerDropdown(
    onSelectCurrency: (Currency) -> Unit
) {
    val exchangerItem = ExchangerItem()
    var isExpanded by remember { mutableStateOf(false) }
    var selectedCurrency by remember { mutableStateOf<Currency>(Currency.DEFAULT) }


    ExposedDropdownMenuBox(
        expanded = isExpanded,
        onExpandedChange = { newValue ->
            isExpanded = newValue
        }
    ) {
        TextField(
            value = selectedCurrency.name,
            onValueChange = {},
            readOnly = true,
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
            },
            placeholder = {
                Text(text = "Please select your gender")
            },
            colors = ExposedDropdownMenuDefaults.textFieldColors(),
            modifier = Modifier.menuAnchor().width(200.dp)
        )
        ExposedDropdownMenu(
            expanded = isExpanded,
            onDismissRequest = {
                isExpanded = false
            }
        ) {
            ExchangerItem.list.forEach { currency ->
                DropdownMenuItem(
                    text = { exchangerItem(currency) },
                    onClick = {
                        isExpanded = false
                        selectedCurrency = currency
                        onSelectCurrency(currency)
                    }
                )
            }
        }
    }
}
 */