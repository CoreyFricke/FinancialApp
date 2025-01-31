package com.example.financialapp.activities.savingsScreen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.financialapp.R
import com.example.financialapp.activities.Screens

class NewSavingsScreen {
    @Composable
    fun Base(viewModel: NewSavingsViewModel, navController: NavController) {
        var context = LocalContext.current
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
                text = "New Savings Goal",
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
                    navController.navigate(Screens.savingsScreen.name)
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
                    .padding(16.dp),
                textAlign = TextAlign.Center,
                text = "Remaining Funds: $" + viewModel.calcRemainingfunds(),
                fontSize = 20.sp,
                color = Color.Black,
                lineHeight = 50.sp
            )
            Button(
                colors = ButtonColors(Color.DarkGray, Color.White, Color.DarkGray, Color.White),
                modifier = Modifier
                    .padding(16.dp),
                onClick = {
                    viewModel.addSavingsGoal()
                    Toast.makeText(context, "Saving Goal Saved!", Toast.LENGTH_LONG).show()
                }) {
                Text(
                    text = "Save Savings Goal"
                )
            }
            Description(viewModel)
            AmountToSave(viewModel)
            Contribution(viewModel)
        }
    }
    @Composable
    fun Description(
        viewModel: NewSavingsViewModel
    ){
        Text(
            modifier = Modifier
                .padding(top = 8.dp),
            textAlign = TextAlign.Center,
            text = "Title",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        TextField(
            modifier = Modifier
                .padding(bottom = 16.dp),
            value = viewModel.description,
            onValueChange = {viewModel.description = it},
            label = { Text("Title") }
        )
    }

    @Composable
    fun AmountToSave(
        viewModel: NewSavingsViewModel
    ){
        Text(
            modifier = Modifier
                .padding(top = 8.dp),
            textAlign = TextAlign.Center,
            text = "Amount To Save",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        TextField(
            modifier = Modifier
                .padding(bottom = 16.dp),
            value = viewModel.amount,
            onValueChange = {viewModel.amount = it},
            label = { Text("Amount to Save") }
        )
    }

    @Composable
    fun Contribution(
        viewModel: NewSavingsViewModel
    ){
        Text(
            modifier = Modifier
                .padding(top = 8.dp),
            textAlign = TextAlign.Center,
            text = "Monthly Contribution",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        TextField(
            modifier = Modifier
                .padding(bottom = 16.dp),
            value = viewModel.percentageContribution,
            onValueChange = {viewModel.percentageContribution = it},
            label = { Text("Monthly Contribution") }
        )
    }


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun ExpenditureType(
        viewModel: NewSavingsViewModel
    ){
        ExposedDropdownMenuBox(
            expanded = viewModel.isExpanded,
            onExpandedChange = {viewModel.isExpanded = !viewModel.isExpanded}
        ) {
            TextField(
                modifier = Modifier
                    .menuAnchor(),
                value = viewModel.selectedText,
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = viewModel.isExpanded)}
            )

            ExposedDropdownMenu(
                expanded = viewModel.isExpanded,
                onDismissRequest = {viewModel.isExpanded = false}
            ){
                viewModel.dropDownOptions.forEachIndexed { index, text ->
                    DropdownMenuItem(
                        text = { Text(text = text) },
                        onClick = {
                            viewModel.selectedText = viewModel.dropDownOptions[index]
                            viewModel.isExpanded = false
                        },
                        contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                    )
                }
            }
        }
        Text(text = "Currently selected: ${viewModel.selectedText}")
    }
}
