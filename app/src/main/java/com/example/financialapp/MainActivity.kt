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
import com.example.financialapp.activities.Screens
import com.example.financialapp.activities.addNewUserScreen.NewUserScreen
import com.example.financialapp.activities.addNewUserScreen.NewUserScreenViewModel
import com.example.financialapp.activities.addNewUserScreen.UserListScreen
import com.example.financialapp.activities.addNewUserScreen.UserListScreenViewModel
import com.example.financialapp.activities.expendituresScreen.ExpenditureScreen
import com.example.financialapp.activities.expendituresScreen.ExpenditureScreenViewModel
import com.example.financialapp.activities.expendituresScreen.NewExpenditureScreen
import com.example.financialapp.activities.expendituresScreen.NewExpenditureViewModel
import com.example.financialapp.activities.homeScreen.HomeScreen
import com.example.financialapp.activities.homeScreen.HomeScreenViewModel
import com.example.financialapp.activities.incomeScreen.IncomeScreen
import com.example.financialapp.activities.incomeScreen.IncomeScreenViewModel
import com.example.financialapp.activities.incomeScreen.NewIncomeSourceScreen
import com.example.financialapp.activities.incomeScreen.NewIncomeSourceViewModel
import com.example.financialapp.activities.loginScreen.LoginScreen
import com.example.financialapp.activities.loginScreen.LoginScreenViewModel
import com.example.financialapp.activities.savingsScreen.NewSavingsScreen
import com.example.financialapp.activities.savingsScreen.NewSavingsViewModel
import com.example.financialapp.activities.savingsScreen.SavingsScreen
import com.example.financialapp.activities.savingsScreen.SavingsScreenViewModel
import com.example.financialapp.databases.expenditureDatabase.expendituresDatabase.ExpenditureDatabase
import com.example.financialapp.databases.expenditureDatabase.incomeDatabase.IncomeDatabase
import com.example.financialapp.databases.expenditureDatabase.savingsDatabase.SavingsDatabase
import com.example.financialapp.databases.expenditureDatabase.userInfoDatabase.UserInfoDatabase
import com.example.financialapp.ui.theme.FinancialAppTheme

class MainActivity : ComponentActivity() {

    //Database?!?
    companion object{
        var userID = "0"
        lateinit var userInfoDatabase: UserInfoDatabase
        lateinit var incomeSourceDatabase: IncomeDatabase
        lateinit var expenditureSourceDatabase: ExpenditureDatabase
        lateinit var savingsDatabase: SavingsDatabase
    }

    //-----ViewModels-------
    //LoginScreen
    private val loginScreenViewModel by viewModels<LoginScreenViewModel>()
    //newUserScreen
    private val newUserScreenViewModel by viewModels<NewUserScreenViewModel>()
    //newUserScreen_DEBUG
    private val userListScreenViewModel by viewModels<UserListScreenViewModel>()
    //HomeScreen
    private val homeScreenViewModel by viewModels<HomeScreenViewModel>()
    //IncomeScreen
    private val incomeScreenViewModel by viewModels<IncomeScreenViewModel>()
    //ExpendituresScreen
    private val expenditureScreenViewModel by viewModels<ExpenditureScreenViewModel>()
    //SavingsScreen
    private val savingsScreenViewModel by viewModels<SavingsScreenViewModel>()
    //NewIncomeSourceScreen
    private val newIncomeSourceViewModel by viewModels<NewIncomeSourceViewModel>()
    //NewExpenditure
    private val newExpenditureViewModel by viewModels<NewExpenditureViewModel>()
    //NewSavingsScree
    private val newSavingsViewModel by viewModels<NewSavingsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Database?!?
        userInfoDatabase = Room.databaseBuilder(
            applicationContext,
            UserInfoDatabase::class.java,
            "UserInfo"
        ).allowMainThreadQueries().build()

        incomeSourceDatabase = Room.databaseBuilder(
            applicationContext,
            IncomeDatabase::class.java,
            "IncomeInformationV3"
        ).allowMainThreadQueries().build()

        expenditureSourceDatabase = Room.databaseBuilder(
            applicationContext,
            ExpenditureDatabase::class.java,
            "ExpenditureInformation"
        ).allowMainThreadQueries().build()

        savingsDatabase = Room.databaseBuilder(
            applicationContext,
            SavingsDatabase::class.java,
            "SavingsInformation"
        ).allowMainThreadQueries().build()

        enableEdgeToEdge()
        setContent {
            FinancialAppTheme {
                Navigation(
                    loginScreenViewModel,
                    newUserScreenViewModel,
                    userListScreenViewModel,
                    homeScreenViewModel,
                    incomeScreenViewModel,
                    expenditureScreenViewModel,
                    savingsScreenViewModel,
                    newIncomeSourceViewModel,
                    newExpenditureViewModel,
                    newSavingsViewModel
                    )
            }
        }
    }
}

@Composable
fun Navigation(
    loginScreenViewModel: LoginScreenViewModel,
    newUserScreenViewModel: NewUserScreenViewModel,
    userListScreenViewModel: UserListScreenViewModel,
    homeScreenViewModel: HomeScreenViewModel,
    incomeScreenViewModel: IncomeScreenViewModel,
    expenditureScreenViewModel: ExpenditureScreenViewModel,
    savingsScreenViewModel: SavingsScreenViewModel,
    newIncomeSourceViewModel: NewIncomeSourceViewModel,
    newExpenditureViewModel: NewExpenditureViewModel,
    newSavingsViewModel: NewSavingsViewModel
){
    val loginScreen = LoginScreen()
    val newUserScreen = NewUserScreen()
    val userListScreen = UserListScreen()
    val homeScreen = HomeScreen()
    val incomeScreen = IncomeScreen()
    val expenditureScreen = ExpenditureScreen()
    val savingsScreen = SavingsScreen()
    val newIncomeSourceScreen = NewIncomeSourceScreen()
    val newExpenditureScreen = NewExpenditureScreen()
    val newSavingsScreen = NewSavingsScreen()

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.loginScreen.name){
        composable(route = Screens.loginScreen.name){
            loginScreen.Base(
                loginScreenViewModel,
                navController = navController,
                context = LocalContext.current
            )
        }
        composable(route = Screens.newUserScreen.name){
            newUserScreen.Base(
                newUserScreenViewModel,
                navController = navController
            )
        }
        composable(route = Screens.userListScreen.name){
            userListScreen.Base(
                userListScreenViewModel,
                navController = navController
            )
        }
        composable(route = Screens.homeScreen.name){
            homeScreen.Base(
                homeScreenViewModel,
                navController = navController
            )
        }
        composable(route = Screens.incomeScreen.name){
            incomeScreen.Base(
                incomeScreenViewModel,
                navController = navController
            )
        }
        composable(route = Screens.savingsScreen.name){
            savingsScreen.Base(
                savingsScreenViewModel,
                navController = navController
            )
        }
        composable(route = Screens.newIncomeSource.name){
            newIncomeSourceScreen.Base(
                newIncomeSourceViewModel,
                navController = navController
            )
        }
        composable(route = Screens.expendituresScreen.name){
            expenditureScreen.Base(
                expenditureScreenViewModel,
                navController = navController
            )
        }
        composable(route = Screens.newExpenditure.name){
            newExpenditureScreen.Base(
                newExpenditureViewModel,
                navController = navController
            )
        }
        composable(route = Screens.newSavings.name){
            newSavingsScreen.Base(
                newSavingsViewModel,
                navController = navController
            )
        }
    }
}