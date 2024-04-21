package com.mnp.billionaires.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mnp.billionaires.presentation.billionaire_description.BillionaireDescriptionScreen
import com.mnp.billionaires.presentation.billionaires_list.BillionaireListScreen
import com.mnp.billionaires.presentation.check_internet_connection.NetworkStatus
import com.mnp.billionaires.presentation.check_internet_connection.ObserverConnection
import com.mnp.billionaires.presentation.ui.theme.BillionairesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var networkStatus: NetworkStatus

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BillionairesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    if(getInternetStatus() == "Available") {
                        val navController = rememberNavController()

                        NavHost(
                            navController = navController,
                            startDestination = Screen.BillionaireListScreen.route
                        ) {
                            composable(route = Screen.BillionaireListScreen.route) {
                                BillionaireListScreen(navController)
                            }
                            composable(route = Screen.BillionaireDescriptionScreen.route + "/{name}") {
                                BillionaireDescriptionScreen()
                            }
                        }
                    } else {
                        Row {
                            Text(
                                text = "Check internet connection.",
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .align(Alignment.CenterVertically)
                            )
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun getInternetStatus(): String{
        networkStatus = ObserverConnection(applicationContext)

        val status by networkStatus.observe().collectAsState(
            initial = NetworkStatus.Status.Unavailable
        )

        return "$status"
    }
}
