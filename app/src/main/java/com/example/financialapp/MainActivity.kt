package com.example.financialapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.financialapp.Databases.UserInfoDatabase
import com.example.financialapp.secondScreen.SecondScreen
import com.example.financialapp.secondScreen.SecondScreenViewModel
import com.example.financialapp.ui.theme.FinancialAppTheme

class MainActivity : ComponentActivity() {

    //Database?!?
    companion object{
        lateinit var database: UserInfoDatabase
    }

    //-----ViewModels-------
    //LoginScreen
    private val loginScreenViewModel by viewModels<LoginScreenViewModel>()
    //SecondScreen
    private val secondScreenViewModel by viewModels<SecondScreenViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Database?!?
        database = Room.databaseBuilder(
            applicationContext,
            UserInfoDatabase::class.java,
            "UserInfo"
        ).allowMainThreadQueries().build()

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
            loginScreen.FirstScreen(
                loginScreenViewModel,
                navController = navController,
                context = LocalContext.current
            )
        }
        composable(route = Screens.Second.name){
            secondScreen.FirstScreen(
                secondScreenViewModel,
                navController = navController
            )
        }
    }
}