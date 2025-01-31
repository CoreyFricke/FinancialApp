package com.example.financialapp.activities.homeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.financialapp.MainActivity
import com.example.financialapp.R
import com.example.financialapp.activities.Screens

class HomeScreen {
    @Composable
    fun Base(viewModel: HomeScreenViewModel, navController: NavController){
        val userInfo = viewModel.getUser(MainActivity.userID)

        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray)
        ) {
            Box(
                contentAlignment = Alignment.BottomCenter,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Gray)
                    .size(60.dp)
            ) {
            }
            Text(
                modifier = Modifier
                    .padding(
                        top = 16.dp,
                        bottom = 8.dp
                    ),
                textAlign = TextAlign.Center,
                text = "${userInfo.userName}'s Summary",
                fontSize = 50.sp,
                color = Color.Black,
                lineHeight = 50.sp
            )
            Text(
                modifier = Modifier
                    .padding(
                        top = 8.dp,
                        bottom = 16.dp
                    ),
                textAlign = TextAlign.Center,
                text = userInfo.email,
                fontSize = 20.sp,
                color = Color.Black,
                fontStyle = FontStyle.Italic
            )
            //Navigate -> HomeScreen
            Button(
                colors = ButtonColors(Color.DarkGray, Color.White, Color.DarkGray, Color.White),
                modifier = Modifier
                    .padding(4.dp),
                onClick = {
                    navController.navigate(Screens.loginScreen.name)
                }) {
                Image(
                    painter = painterResource(R.drawable.baseline_arrow_back_24),
                    contentDescription = "Back to Login Screen",
                    modifier = Modifier
                        .size(20.dp)
                )
            }
            IncomeInformation(viewModel, navController)
            ExpenditureInformation(viewModel, navController)
            SavingsInformation(viewModel, navController)
        }
    }

    //TODO Condense these into reusable composable
    @Composable
    fun IncomeInformation(viewModel: HomeScreenViewModel, navController: NavController){
        Box(
            modifier = Modifier
                .background(Color.Gray)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ){
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
            ){
                Row(){
                    Text(
                        modifier = Modifier
                            .weight(1f)
                            .padding(
                                top = 8.dp,
                                bottom = 8.dp,
                                start = 8.dp
                            ),
                        textAlign = TextAlign.Start,
                        text = "Income Summary",
                        fontSize = 25.sp,
                        color = Color.Black,
                        lineHeight = 50.sp,
                        fontWeight = FontWeight.Bold
                    )
                    //Edit Income info
                    Button(
                        colors = ButtonColors(Color.DarkGray, Color.White, Color.DarkGray, Color.White),
                        modifier = Modifier
                            .padding(16.dp),
                        onClick = {
                            navController.navigate(Screens.incomeScreen.name)
                        }) {
                        Image(
                            painter = painterResource(R.drawable.baseline_edit_24),
                            contentDescription = "Back to Login Screen",
                            modifier = Modifier
                                .size(25.dp)
                        )
                    }
                }
                IncomeText(viewModel)
            }
        }
    }

    @Composable
    fun ExpenditureInformation(viewModel: HomeScreenViewModel, navController: NavController){
        Box(
            modifier = Modifier
                .background(Color.Gray)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ){
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
            ){
                Row(){
                    Text(
                        modifier = Modifier
                            .weight(1f)
                            .padding(
                                top = 8.dp,
                                bottom = 8.dp,
                                start = 8.dp
                            ),
                        textAlign = TextAlign.Start,
                        text = "Expenditure Summary",
                        fontSize = 25.sp,
                        color = Color.Black,
                        lineHeight = 50.sp,
                        fontWeight = FontWeight.Bold
                    )
                    //Edit Income info
                    Button(
                        colors = ButtonColors(Color.DarkGray, Color.White, Color.DarkGray, Color.White),
                        modifier = Modifier
                            .padding(16.dp),
                        onClick = {
                            navController.navigate(Screens.expendituresScreen.name)
                        }) {
                        Image(
                            painter = painterResource(R.drawable.baseline_edit_24),
                            contentDescription = "Back to Login Screen",
                            modifier = Modifier
                                .size(25.dp)
                        )
                    }
                }
                ExpenditureText(viewModel)
            }
        }
    }

    @Composable
    fun SavingsInformation(viewModel: HomeScreenViewModel, navController: NavController){
        Box(
            modifier = Modifier
                .background(Color.Gray)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ){
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
            ){
                Row(){
                    Text(
                        modifier = Modifier
                            .weight(1f)
                            .padding(
                                top = 8.dp,
                                bottom = 8.dp,
                                start = 8.dp
                            ),
                        textAlign = TextAlign.Start,
                        text = "Savings Summary",
                        fontSize = 25.sp,
                        color = Color.Black,
                        lineHeight = 50.sp,
                        fontWeight = FontWeight.Bold
                    )
                    //Edit Income info
                    Button(
                        colors = ButtonColors(Color.DarkGray, Color.White, Color.DarkGray, Color.White),
                        modifier = Modifier
                            .padding(16.dp),
                        onClick = {
                            navController.navigate(Screens.savingsScreen.name)
                        }) {
                        Image(
                            painter = painterResource(R.drawable.baseline_edit_24),
                            contentDescription = "Back to Login Screen",
                            modifier = Modifier
                                .size(25.dp)
                        )
                    }
                }
                SavingsText(viewModel)
            }
        }
    }

    @Composable
    fun IncomeText(viewModel: HomeScreenViewModel){
        val incomeInfo = viewModel.calcAnnualIncome()
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ){
            //Annual Income
            Text(
                modifier = Modifier
                    .padding(8.dp),
                text = "Total Annual income: $" + incomeInfo[1],
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                color = Color.Black,
            )
            //Monthly Income
            Text(
                modifier = Modifier
                    .padding(8.dp),
                text = "Monthly Income: $" + incomeInfo[2],
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                color = Color.Black,
            )
            //Income Sources
            Text(
                modifier = Modifier
                    .padding(8.dp),
                text = "Income Sources: " + incomeInfo[0],
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                color = Color.Black,
            )
        }
    }

    @Composable
    fun ExpenditureText(viewModel: HomeScreenViewModel){
        val expendList = viewModel.calExpenditures()
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ){
            //Annual Income
            Text(
                modifier = Modifier
                    .padding(8.dp),
                text = "Total Monthly Expended: $${expendList[1]}",
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                color = Color.Black,
            )
            //Monthly Income
            Text(
                modifier = Modifier
                    .padding(8.dp),
                text = "Expenditure Sources: ${expendList[0]}",
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                color = Color.Black,
            )
        }
    }

    @Composable
    fun SavingsText(viewModel: HomeScreenViewModel){
        val savingsList = viewModel.calSavings()
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ){
            //Annual Income
            Text(
                modifier = Modifier
                    .padding(8.dp),
                text = "Number of Goals: ${savingsList[0]}",
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                color = Color.Black,
            )
            //Monthly Income
            Text(
                modifier = Modifier
                    .padding(8.dp),
                text = "Remaining  Monthly Funds: $${savingsList[1]}",
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                color = Color.Black,
            )
        }
    }
}