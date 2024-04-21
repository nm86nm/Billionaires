package com.mnp.billionaires.presentation.billionaires_list.components

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mnp.billionaires.domain.model.Billionaire

@Composable
fun BillionaireListItem(
    billionaire: Billionaire,
    onItemClick: (Billionaire) -> Unit
) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(billionaire) }
            .padding(15.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        val fontSize = 17
        Text(
            text = "${billionaire.rank}. ${billionaire.name}",
            style = MaterialTheme.typography.bodyLarge,
            overflow = TextOverflow.Ellipsis,
            fontSize = fontSize.sp,
            modifier = Modifier.width(250.dp)
        )
        Text(
            text = billionaire.networth,
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.End,
            fontSize = fontSize.sp
        )
    }
}