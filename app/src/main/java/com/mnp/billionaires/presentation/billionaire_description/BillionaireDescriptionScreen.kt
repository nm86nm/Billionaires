package com.mnp.billionaires.presentation.billionaire_description

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage

@Composable
fun BillionaireDescriptionScreen(
    viewModel: BillionaireDescriptionViewModel = hiltViewModel()
) {    
    val state = viewModel.state.value
    
    Box(modifier = Modifier.fillMaxSize()) {
        state.billionaire?.let { billionaire ->
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(20.dp)
            ){
                val billionaireId= billionaire.id.lowercase().replace(' ', '-')
                val imageUrl = "https://github.com/nm86nm/images/blob/main/$billionaireId-1.jpg?raw=true"

                item {
                    AsyncImage(
                        model = imageUrl,
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxSize()
                            .aspectRatio(1f)
                    )
                    Text(text = billionaire.description)
                }
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