package com.example.financialapp.activities.loginScreen

import android.content.Context
import android.widget.Toast
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
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.financialapp.activities.Screens

class LoginScreen{
    @Composable
    fun Base(viewModel: LoginScreenViewModel, navController: NavController, context: Context){
        viewModel.setAccessGranted(false)
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
                    .padding(
                        top = 16.dp,
                        bottom = 8.dp
                    ),
                textAlign = TextAlign.Center,
                text = "Final Finance",
                fontSize = 50.sp,
                color = Color.Black
            )
            Text(
                modifier = Modifier
                    .padding(8.dp),
                textAlign = TextAlign.Start,
                text = "Disclaimer: The test build of this application includes features that are meant" +
                        "for ease of use during testing, such as the pre-loaded users, debug screens, etc...",
                fontSize = 12.sp,
                color = Color.Black,
                fontStyle = FontStyle.Italic
            )
            Text(
                modifier = Modifier
                    .padding(8.dp),
                textAlign = TextAlign.Start,
                text = "Please Sign In or Create New User",
                fontSize = 18.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
            Identification(viewModel, navController, context)
        }
    }

    @Composable
    fun Identification(viewModel: LoginScreenViewModel, navController: NavController, context: Context){

        //Username
        Text(
            modifier = Modifier
                .padding(top = 8.dp),
            textAlign = TextAlign.Center,
            text = "Username",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        TextField(
            modifier = Modifier
                .padding(bottom = 16.dp),
            value = viewModel.getUsername(),
            onValueChange = {viewModel.setUsername(it)},
            label = {Text("Username")}
        )
        //Password
        Text(
            modifier = Modifier
                .padding(top = 8.dp),
            textAlign = TextAlign.Center,
            text = "Password",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        TextField(
            modifier = Modifier
                .padding(bottom = 16.dp),
            value = viewModel.getPassword(),
            onValueChange = {viewModel.setPassword(it)},
            label = {Text("Password")}
        )
        //Login
        Button(
            colors = ButtonColors(Color.DarkGray, Color.White, Color.DarkGray, Color.White),
            onClick = {
            Toast.makeText(context, viewModel.loginUser(viewModel.getUsername()), Toast.LENGTH_LONG).show()

            if(viewModel.getAccessGranted()){
                navController.navigate(Screens.homeScreen.name)
            }
        }) {
            Text(
                text = "Login",
                color = Color.White
            )
        }
        //Navigation -> newUser
        Button(
            colors = ButtonColors(Color.DarkGray, Color.White, Color.DarkGray, Color.White),
            onClick = {
            navController.navigate(Screens.newUserScreen.name)
        }) {
            Text(
                text = "Create New User",
                color = Color.White
            )
        }
        //DEBUG
        Text(
            modifier = Modifier
                .padding(top = 16.dp),
            textAlign = TextAlign.Center,
            text = "----------DEBUG/TESTING----------",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        //Navigate -> UserListScreen
        Button(
            modifier = Modifier
                .padding(top = 16.dp),
            colors = ButtonColors(Color.DarkGray, Color.White, Color.DarkGray, Color.White),
            onClick = {
            navController.navigate(Screens.userListScreen.name)
        }) {
            Text(
                text = "User Info Database",
                color = Color.White
            )
        }
        Button(
            modifier = Modifier
                .padding(top = 16.dp),
            colors = ButtonColors(Color.DarkGray, Color.White, Color.DarkGray, Color.White),
            onClick = {
            viewModel.loadPreMade1()
        }) {
            Text(
                text = "Load Pre-made_1: Tommy",
                color = Color.White
            )
        }
        Button(
            modifier = Modifier
                .padding(top = 16.dp),
            colors = ButtonColors(Color.DarkGray, Color.White, Color.DarkGray, Color.White),
            onClick = {
            viewModel.loadPreMade2()
        }) {
            Text(
                text = "Load Pre-made_2: Rachel",
                color = Color.White
            )
        }
    }
}