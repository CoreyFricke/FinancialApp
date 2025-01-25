package com.example.financialapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.financialapp.secondScreen.SecondScreen
import com.example.financialapp.secondScreen.SecondScreenViewModel
import com.example.financialapp.ui.theme.FinancialAppTheme

class MainActivity : ComponentActivity() {

    //LoginScreen
    private val loginScreenViewModel by viewModels<LoginScreenViewModel>()
    //SecondScreen
    private val secondScreenViewModel by viewModels<SecondScreenViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FinancialAppTheme {
                Navigation(
                    loginScreenViewModel,
                    secondScreenViewModel
                    )
            }
        }
    }
}

@Composable
fun Navigation(
    loginScreenViewModel: LoginScreenViewModel,
    secondScreenViewModel: SecondScreenViewModel
){
    val loginScreen = LoginScreen()
    val secondScreen = SecondScreen()

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.Login.name){
        composable(route = Screens.Login.name){
            loginScreen.FirstScreen(loginScreenViewModel, navController = navController)
        }
        composable(route = Screens.Second.name){
            secondScreen.FirstScreen(secondScreenViewModel, navController = navController)
        }
    }
}