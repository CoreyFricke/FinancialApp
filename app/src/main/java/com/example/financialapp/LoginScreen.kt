package com.example.financialapp

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

class LoginScreen{
    @Composable
    fun FirstScreen(viewModel: LoginScreenViewModel, navController: NavController){

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
                    .background(Color.DarkGray)
                    .size(120.dp)
            ){
                Text(
                    modifier = Modifier
                        .padding(16.dp),
                    textAlign = TextAlign.Center,
                    text = "Login Screen",
                    fontSize = 50.sp,
                    color = Color.White
                )
            }
            TextField(
                modifier = Modifier
                    .padding(16.dp),
                value = viewModel.userInput,
                onValueChange = {viewModel.userInput = it},
                label = {Text("Label")}
            )
            //Counter
            Box(){
                Text(
                    modifier = Modifier
                        .padding(16.dp),
                    textAlign = TextAlign.Center,
                    text = viewModel.MultiplyByTwo().toString(),
                    fontSize = 50.sp,
                    color = Color.Black
                )
            }
            Button(onClick = {
                viewModel.addOne()
            }) {
                Text(
                    text = viewModel.number.toString()
                )
            }
            //Navigation
            Button(onClick = {
                navController.navigate(Screens.Second.name)
            }) {
                Text(
                    text = "Change Screen"
                )
            }
        }
    }
}