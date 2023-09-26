package com.example.ezcalculator.feature_exchange.domain.util.dropdown

data class DropdownState(
    val firstDropdown: Dropdown = Dropdown.FirstDropdown(),
    val secondDropdown: Dropdown = Dropdown.SecondDropdown()
)