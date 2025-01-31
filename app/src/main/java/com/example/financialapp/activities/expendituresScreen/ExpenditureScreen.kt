package com.example.financialapp.activities.expendituresScreen

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
import com.example.financialapp.databases.expenditureDatabase.expendituresDatabase.ExpenditureData

class ExpenditureScreen {
    @Composable
    fun Base(viewModel: ExpenditureScreenViewModel, navController: NavController) {

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
                text = "Expenditure Summary",
                fontSize = 50.sp,
                color = Color.Black,
                lineHeight = 50.sp
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
                )}
            Text(
                modifier = Modifier
                    .padding(top = 16.dp),
                textAlign = TextAlign.Center,
                text = "Total Monthly: $" + viewModel.calcTotalMonthlyExpenditure(),
                fontSize = 30.sp,
                color = Color.Black,
                lineHeight = 50.sp
            )
            Text(
                modifier = Modifier
                    .padding(bottom = 16.dp),
                textAlign = TextAlign.Center,
                text = "(Rounded Up)",
                fontSize = 15.sp,
                color = Color.Black,
                fontStyle = FontStyle.Italic
            )
            //NewExpenditureSourceScreen
            Button(
                colors = ButtonColors(Color.DarkGray, Color.White, Color.DarkGray, Color.White),
                modifier = Modifier
                    .padding(16.dp),
                onClick = {
                    navController.navigate(Screens.newExpenditure.name)
                }) {
                Text(
                    text = "New Expenditure"
                )
            }
            List(viewModel, viewModel.getExpenditureSources())
        }
    }

    @Composable
    fun List(viewModel: ExpenditureScreenViewModel, list : List<ExpenditureData>){
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth(),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(list){incomeSource ->
                ListItem(viewModel, incomeSource)
            }
        }
    }

    @Composable
    fun ListItem(
        viewModel: ExpenditureScreenViewModel,
        expenditureData: ExpenditureData
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
                    text = expenditureData.description,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    modifier = Modifier
                        .padding(4.dp),
                    text = "Type: ",
                    fontStyle = FontStyle.Italic
                )
                Text(
                    modifier = Modifier
                        .padding(4.dp),
                    text = expenditureData.expenditureType
                )
                Text(
                    modifier = Modifier
                        .padding(4.dp),
                    text = "Amount: ",
                    fontStyle = FontStyle.Italic
                )
                Text(
                    modifier = Modifier
                        .padding(4.dp),
                    text = "$" + expenditureData.amount
                )
            }
            Button(
                colors = ButtonColors(Color.DarkGray, Color.White, Color.DarkGray, Color.White),
                modifier = Modifier
                    .align(Alignment.CenterEnd),
                onClick = {
                    viewModel.deleteExpenditureData(expenditureData.expenditureSourceID)
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