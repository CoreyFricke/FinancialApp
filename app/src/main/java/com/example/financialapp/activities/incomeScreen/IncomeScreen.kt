package com.example.financialapp.activities.incomeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.example.financialapp.R
import com.example.financialapp.activities.Screens
import com.example.financialapp.databases.expenditureDatabase.incomeDatabase.IncomeData

class IncomeScreen {
    //TODO - Add deductibles to paycheck calculations (current numbers are pre-tax)
    @Composable
    fun Base(viewModel: IncomeScreenViewModel, navController: NavController) {
        val annualIncome = viewModel.calcAnnualIncome()

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
                    .padding(16.dp),
                textAlign = TextAlign.Center,
                text = "Income Sources",
                fontSize = 50.sp,
                color = Color.Black,
                lineHeight = 20.sp
            )
            //Navigate -> HomeScreen
            Button(
                colors = ButtonColors(Color.DarkGray, Color.White, Color.DarkGray, Color.White),
                modifier = Modifier
                    .padding(4.dp),
                onClick = {
                    navController.navigate(Screens.homeScreen.name)
                }) {
                Image(
                    painter = painterResource(R.drawable.baseline_arrow_back_24),
                    contentDescription = "Back to Login Screen",
                    modifier = Modifier
                        .size(20.dp)
                )
            }
            Text(
                modifier = Modifier
                    .padding(8.dp),
                textAlign = TextAlign.Center,
                text = "Annual Income: $" + annualIncome,
                fontSize = 25.sp,
                color = Color.Black
            )
            //NewIncomeSourceScreen
            Button(
                colors = ButtonColors(Color.DarkGray, Color.White, Color.DarkGray, Color.White),
                modifier = Modifier
                    .padding(8.dp),
                onClick = {
                    navController.navigate(Screens.newIncomeSource.name)
                }) {
                Text(
                    text = "Add New Income Source"
                )
            }
            List(viewModel, viewModel.getIncomeSources())
        }
    }

    @Composable
    fun List(viewModel: IncomeScreenViewModel, list: List<IncomeData>) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth(),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(list) { incomeSource ->
                ListItem(viewModel, incomeSource)
            }
        }
    }

    @Composable
    fun ListItem(
        viewModel: IncomeScreenViewModel,
        incomeData: IncomeData
    ) {

        if (incomeData.salaryType == "Hourly Pay") {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Gray)
                    .padding(8.dp)
            ) {
                Column() {
                    Text(
                        modifier = Modifier
                            .padding(4.dp),
                        text = incomeData.description,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        modifier = Modifier
                            .padding(1.dp),
                        text = "Hourly Income:",
                        fontStyle = FontStyle.Italic
                    )
                    Text(
                        modifier = Modifier
                            .padding(1.dp),
                        text = "$" + incomeData.hourlyIncome
                    )
                    Text(
                        modifier = Modifier
                            .padding(1.dp),
                        text = "Hours Per Week:",
                        fontStyle = FontStyle.Italic
                    )
                    Text(
                        modifier = Modifier
                            .padding(1.dp),
                        text =incomeData.hoursPerWeek
                    )
                }
                Button(
                    colors = ButtonColors(Color.DarkGray, Color.White, Color.DarkGray, Color.White),
                    modifier = Modifier
                        .align(Alignment.CenterEnd),
                    onClick = {
                        viewModel.deleteIncomeSource(incomeData.incomeSourceID)
                    }) {
                    Image(
                        painter = painterResource(R.drawable.baseline_delete_24),
                        contentDescription = "Back to Login Screen",
                        modifier = Modifier
                            .size(20.dp)
                    )
                }
            }
        } else {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Gray)
                    .padding(8.dp)
            ) {
                Column() {
                    Text(
                        modifier = Modifier
                            .padding(4.dp),
                        text = incomeData.description,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        modifier = Modifier
                            .padding(4.dp),
                        text = "Annual Income:",
                        fontStyle = FontStyle.Italic
                    )
                    Text(
                        modifier = Modifier
                            .padding(4.dp),
                        text = "$" + incomeData.annualSalary
                    )
                }
                Button(
                    colors = ButtonColors(Color.DarkGray, Color.White, Color.DarkGray, Color.White),
                    modifier = Modifier
                        .align(Alignment.CenterEnd),
                    onClick = {
                        viewModel.deleteIncomeSource(incomeData.incomeSourceID)
                    }) {
                    Image(
                        painter = painterResource(R.drawable.baseline_delete_24),
                        contentDescription = "Back to Login Screen",
                        modifier = Modifier
                            .size(20.dp)
                    )
                }
            }
        }
    }
}

