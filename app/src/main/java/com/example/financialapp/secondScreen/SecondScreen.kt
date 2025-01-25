package com.example.financialapp.secondScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.financialapp.Screens

class SecondScreen {
    @Composable
    fun FirstScreen(viewModel: SecondScreenViewModel, navController: NavController){

        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
        ){
            Box(
                contentAlignment = Alignment.BottomCenter,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Blue)
                    .size(120.dp)
            ){
                Text(
                    modifier = Modifier
                        .padding(16.dp),
                    textAlign = TextAlign.Center,
                    text = "Second Screen",
                    fontSize = 50.sp,
                    color = Color.White
                )
            }
            TextField(
                modifier = Modifier
                    .padding(16.dp),
                value = viewModel.userInput,
                onValueChange = {viewModel.userInput = it},
                label = { Text("Label") }
            )
            Button(onClick = {
                viewModel.addOne()
            }) {
                Text(
                    text = viewModel.number.toString()
                )
            }
            //Navigation
            Button(onClick = {
                navController.navigate(Screens.Login.name)
            }) {
                Text(
                    text = "Change Screen"
                )
            }
        }
    }
}