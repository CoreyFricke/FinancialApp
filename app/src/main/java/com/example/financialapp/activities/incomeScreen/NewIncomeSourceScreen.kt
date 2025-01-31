package com.example.financialapp.activities.incomeScreen

import android.widget.Toast
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

class NewIncomeSourceScreen {
    @Composable
    fun Base(viewModel: NewIncomeSourceViewModel, navController: NavController) {
        val context = LocalContext.current
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
                text = "New Income Source",
                fontSize = 50.sp,
                color = Color.Black,
                lineHeight = 40.sp
            )
            Row() {
                //IncomePage
                Button(
                    colors = ButtonColors(Color.DarkGray, Color.White, Color.DarkGray, Color.White),
                    modifier = Modifier
                        .padding(
                            bottom = 8.dp,
                            end = 4.dp
                        ),
                    onClick = {
                        navController.navigate(Screens.incomeScreen.name)
                    }) {
                    Image(
                        painter = painterResource(R.drawable.baseline_arrow_back_24),
                        contentDescription = "Back to Login Screen",
                        modifier = Modifier
                            .size(25.dp)
                    )
                }
                Button(
                    colors = ButtonColors(Color.DarkGray, Color.White, Color.DarkGray, Color.White),
                    modifier = Modifier
                        .padding(
                            bottom = 8.dp,
                            start = 4.dp
                        ),
                    onClick = {
                        Toast.makeText(context, viewModel.addIncomeSource(), Toast.LENGTH_LONG).show()
                    }) {
                    Text(
                        text = "Save Income Source"
                    )
                }
            }
            Title(viewModel)
            IncomeType(viewModel)
            if(viewModel.getterSelectedText() == viewModel.dropDownOptions[0]){
                HourlyPay(viewModel)
            }
            else if(viewModel.getterSelectedText() == viewModel.dropDownOptions[1]){
                SalaryPay(viewModel)
            }
            else{
                MiscPay(viewModel)
            }
        }
    }

    @Composable
    fun Title(
        viewModel: NewIncomeSourceViewModel
    ) {
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
            value = viewModel.getterDescription(),
            onValueChange = { viewModel.setterDescription(it) },
            label = { Text("Title") }
        )
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun IncomeType(
        viewModel: NewIncomeSourceViewModel
    ) {
        Text(
            modifier = Modifier
                .padding(top = 8.dp),
            textAlign = TextAlign.Center,
            text = "Income Type",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        ExposedDropdownMenuBox(
            expanded = viewModel.isExpanded,
            onExpandedChange = { viewModel.isExpanded = !viewModel.isExpanded }
        ) {
            TextField(
                modifier = Modifier
                    .menuAnchor(),
                value = viewModel.getterSelectedText(),
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = viewModel.isExpanded) }
            )
            ExposedDropdownMenu(
                expanded = viewModel.isExpanded,
                onDismissRequest = { viewModel.isExpanded = false }
            ) {
                viewModel.dropDownOptions.forEachIndexed { index, text ->
                    DropdownMenuItem(
                        text = { Text(text = text) },
                        onClick = {
                            viewModel.setterHourlyIncome("0")
                            viewModel.setterHoursPerWeek("0")
                            viewModel.setterPaycheckDeductibles("0")
                            viewModel.setterAnnualSalary("0")
                            viewModel.setterSelectedText(viewModel.dropDownOptions[index])
                            viewModel.isExpanded = false
                        },
                        contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                    )
                }
            }
        }
    }

    @Composable
    fun HourlyPay(viewModel: NewIncomeSourceViewModel) {
        //HourlyIncome
        Text(
            modifier = Modifier
                .padding(top = 8.dp),
            textAlign = TextAlign.Center,
            text = "Hourly Income",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        TextField(
            modifier = Modifier
                .padding(bottom = 16.dp),
            value = viewModel.getterHourlyIncome(),
            onValueChange = { viewModel.setterHourlyIncome(it) },
            label = { Text("Hourly Income") }
        )
        //HoursPerWeek
        Text(
            modifier = Modifier
                .padding(top = 8.dp),
            textAlign = TextAlign.Center,
            text = "Hours Worked Per Week",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        TextField(
            modifier = Modifier
                .padding(bottom = 16.dp),
            value = viewModel.getterHoursPerWeek(),
            onValueChange = { viewModel.setterHoursPerWeek(it) },
            label = { Text("Hours Per Week") }
        )
        //Deductibles
        Text(
            modifier = Modifier
                .padding(top = 8.dp),
            textAlign = TextAlign.Center,
            text = "Total Paycheck Deductibles (401k, taxes, etc..)",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        TextField(
            modifier = Modifier
                .padding(bottom = 16.dp),
            value = viewModel.getterPaycheckDeductibles(),
            onValueChange = { viewModel.setterPaycheckDeductibles(it) },
            label = { Text("Set Deductibles") }
        )
    }

    @Composable
    fun SalaryPay(viewModel: NewIncomeSourceViewModel) {
        //annualSalary
        Text(
            modifier = Modifier
                .padding(top = 8.dp),
            textAlign = TextAlign.Center,
            text = "Annual Salary",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        TextField(
            modifier = Modifier
                .padding(bottom = 16.dp),
            value = viewModel.getterAnnualSalary(),
            onValueChange = { viewModel.setterAnnualSalary(it) },
            label = { Text("Annual Salary") }
        )
    }

    @Composable
    fun MiscPay(viewModel: NewIncomeSourceViewModel) {
        //Estimated Annual Count
        Text(
            modifier = Modifier
                .padding(top = 8.dp),
            textAlign = TextAlign.Center,
            text = "Estimated Annual Count",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        TextField(
            modifier = Modifier
                .padding(bottom = 16.dp),
            value = viewModel.getterAnnualSalary(),
            onValueChange = { viewModel.setterAnnualSalary(it) },
            label = { Text("Estimated Annual Count") }
        )
    }

}