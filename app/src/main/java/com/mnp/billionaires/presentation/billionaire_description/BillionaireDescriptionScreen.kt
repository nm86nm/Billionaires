package com.mnp.billionaires.presentation.billionaire_description

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.mnp.billionaires.presentation.billionaires_list.BillionaireListViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun BillionaireDescriptionScreen(
    viewModel: BillionaireDescriptionViewModel = hiltViewModel(),
    viewModel2: BillionaireListViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val state2 = viewModel2.state.value

    Box(modifier = Modifier.fillMaxSize()) {
        val listBillionaires = state2.billionaires

        state.billionaireDescription?.let { billionaireDescription ->
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(20.dp)
            ) {
                val billionaireId = billionaireDescription.id.lowercase().replace(' ', '-')
                val imageUrl =
                    "https://github.com/nm86nm/images/blob/main/$billionaireId-1.jpg?raw=true"

                val billionaire = listBillionaires.find { it.name == billionaireDescription.id }

                item {
                    AsyncImage(
                        model = imageUrl,
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxSize()
                            .aspectRatio(1f)
                    )

                    val height = 10
                    Spacer(modifier = Modifier.height(height.dp))
                    Divider()
                    billionaire?.let {
                        Text(text = "name: ${it.name}")
                        Text(text = "age: ${it.age}")
                        Text(text = "networth: ${it.networth}")
                        Text(text = "country/territory: ${it.countryterritory}")
                        Text(text = "industry ${it.industry}")
                        Text(text = "source: ${it.source}")
                    }
                    Divider()
                    Spacer(modifier = Modifier.height(height.dp))
                    Text(
                        text = billionaireDescription.description,
                        textAlign = TextAlign.Justify
                    )
                }
            }
        }

        if (state.error.isNotBlank()) {
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

        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}
