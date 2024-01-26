package com.mnp.billionaires.presentation.billionaires_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mnp.billionaires.domain.model.Billionaire
import com.mnp.billionaires.presentation.Screen
import com.mnp.billionaires.presentation.billionaires_list.components.BillionaireListItem

@Composable
fun BillionaireListScreen(
    navController: NavController,
    viewModel: BillionaireListViewModel = hiltViewModel()
) {    
    val state = viewModel.state.value
    
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(state.billionaires){billionaire ->
                val billionaireName = billionaire.name.replace(' ', '-').lowercase()

                BillionaireListItem(
                    billionaire = billionaire,
                    onItemClick = {
                        navController.navigate(Screen.BillionaireDescriptionScreen.route + "/${billionaireName}")
                    }
                )
            }
        }
        
        if (state.error.isNotBlank()){
            Text(
                text = state.error,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        
        if(state.isLoading){
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}