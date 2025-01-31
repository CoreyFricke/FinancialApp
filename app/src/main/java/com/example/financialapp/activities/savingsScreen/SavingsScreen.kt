package com.example.financialapp.activities.savingsScreen

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
import com.example.financialapp.databases.expenditureDatabase.savingsDatabase.SavingsData

class SavingsScreen {
    @Composable
    fun Base(viewModel: SavingsScreenViewModel, navController: NavController){

        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray)
        ){
            Box(
                contentAlignment = Alignment.BottomCenter,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Gray)
                    .size(60.dp)
            ){
            }
            Text(
                modifier = Modifier
                    .padding(16.dp),
                textAlign = TextAlign.Center,
                text = "Savings",
                fontSize = 50.sp,
                color = Color.Black
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
                    contentDescription = "Back to Home Screen",
                    modifier = Modifier
                        .size(20.dp)
                )
            }
            Text(
                modifier = Modifier
                    .padding(top = 16.dp),
                textAlign = TextAlign.Center,
                text = "Remaining Monthly Budget:",
                fontSize = 25.sp,
                color = Color.Black,
                lineHeight = 50.sp
            )
            Text(
                modifier = Modifier
                    .padding(bottom = 16.dp),
                textAlign = TextAlign.Center,
                text = "$" + viewModel.calcRemainingfunds(),
                fontSize = 35.sp,
                color = Color.Black
            )
            //NewSavings
            Button(
                colors = ButtonColors(Color.DarkGray, Color.White, Color.DarkGray, Color.White),
                modifier = Modifier
                    .padding(16.dp),
                onClick = {
                    navController.navigate(Screens.newSavings.name)
                }) {
                Text(
                    text = "New Savings Goal"
                )
            }

            List(viewModel, viewModel.getSavingsList())
        }
    }

    @Composable
    fun List(viewModel: SavingsScreenViewModel, list : List<SavingsData>){
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth(),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(list){savingsGoal ->
                ListItem(viewModel, savingsGoal)
            }
        }
    }

    @Composable
    fun ListItem(
        viewModel: SavingsScreenViewModel,
        savingsData: SavingsData
    ){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Gray)
                .padding(16.dp)
        ){
            Column(){
                Text(
                    modifier = Modifier
                        .padding(4.dp),
                    text = savingsData.description,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    modifier = Modifier
                        .padding(4.dp),
                    text = "Amount To Save: ",
                    fontStyle = FontStyle.Italic
                )
                Text(
                    modifier = Modifier
                        .padding(4.dp),
                    text = "$" + savingsData.amountToSave
                )
                Text(
                    modifier = Modifier
                        .padding(4.dp),
                    text = "Monthly Contribution: ",
                    fontStyle = FontStyle.Italic
                )
                Text(
                    modifier = Modifier
                        .padding(4.dp),
                    text = "$" + savingsData.percentageContribution
                )
            }
            Button(
                colors = ButtonColors(Color.DarkGray, Color.White, Color.DarkGray, Color.White),
                modifier = Modifier
                    .align(Alignment.CenterEnd),
                onClick = {
                    viewModel.deleteSavingsGoal(savingsData.savingsItemID)
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