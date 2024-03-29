package com.mnp.billionaires.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mnp.billionaires.presentation.billionaire_description.BillionaireDescriptionScreen
import com.mnp.billionaires.presentation.billionaires_list.BillionaireListScreen
import com.mnp.billionaires.presentation.ui.theme.BillionairesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BillionairesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = Screen.BillionaireListScreen.route
                    ){
                        composable(route = Screen.BillionaireListScreen.route){
                            BillionaireListScreen(navController)
                        }
                        composable(route = Screen.BillionaireDescriptionScreen.route + "/{name}"){
                            BillionaireDescriptionScreen()
                        }
                    }
                }
            }
        }
    }
}
