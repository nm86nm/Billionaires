package com.mnp.billionaires.presentation

sealed class Screen (val route: String){
    object BillionaireDescriptionScreen: Screen("billionaire_description_screen")
    object BillionaireListScreen: Screen("billionaire_list_screen")
}