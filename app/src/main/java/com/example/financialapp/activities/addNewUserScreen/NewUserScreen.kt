package com.example.financialapp.activities.addNewUserScreen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.financialapp.PremadeComposables
import com.example.financialapp.R
import com.example.financialapp.activities.Screens

class NewUserScreen {
    val comp = PremadeComposables()

    @Composable
    fun Base(viewModel: NewUserScreenViewModel, navController: NavController){

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
                        top = 8.dp,
                        bottom = 16.dp
                        ),
                textAlign = TextAlign.Center,
                text = "New User Signup",
                fontSize = 50.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                lineHeight = 40.sp
            )
            Text(
                modifier = Modifier
                    .padding(
                        top = 8.dp,
                        bottom = 4.dp
                        ),
                textAlign = TextAlign.Center,
                text = "Please enter your information",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Text(
                modifier = Modifier
                    .padding(
                        top = 4.dp,
                        bottom = 16.dp
                    ),
                textAlign = TextAlign.Center,
                text = "*Required",
                fontSize = 15.sp,
                fontStyle = FontStyle.Italic,
                color = Color.Black
            )
            UserInformation(viewModel)
            SaveButton(viewModel, navController)
        }
    }

    @Composable
    fun UserInformation(viewModel: NewUserScreenViewModel){

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
            value = viewModel.myUserNameGetter(),
            onValueChange = {viewModel.myUserNameSetter(it)},
            label = { Text("*Username") }
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
            value = viewModel.myUserPasswordGetter(),
            onValueChange = {viewModel.myUserUserPasswordSetter(it)},
            label = { Text("*Password") }
        )
        //Email
        Text(
            modifier = Modifier
                .padding(top = 8.dp),
            textAlign = TextAlign.Center,
            text = "Email",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        TextField(
            modifier = Modifier
                .padding(bottom = 16.dp),
            value = viewModel.myUserEmailGetter(),
            onValueChange = {viewModel.myUserEmailSetter(it)},
            label = { Text("Email") }
        )
        //Age
        Text(
            modifier = Modifier
                .padding(top = 8.dp),
            textAlign = TextAlign.Center,
            text = "Age",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        TextField(
            modifier = Modifier
                .padding(bottom = 16.dp),
            value = viewModel.myUserAgeGetter(),
            onValueChange = {viewModel.myUserAgeSetter(it)},
            label = { Text("Age") }
        )
    }

    @Composable
    fun SaveButton(viewModel: NewUserScreenViewModel, navController: NavController){
        val context = LocalContext.current

        Button(
            colors = ButtonColors(Color.DarkGray, Color.White, Color.DarkGray, Color.White),
            onClick = {
            Toast.makeText(context, viewModel.checkUserExist(), Toast.LENGTH_LONG).show()
        }) {
            Text(
                text = "Save New User"
            )
        }
        Spacer(modifier = Modifier.height(100.dp))
        //Navigate -> LoginScreen
        Button(
            colors = ButtonColors(Color.DarkGray, Color.White, Color.DarkGray, Color.White),
            onClick = {
                navController.navigate(Screens.loginScreen.name)
            }) {
            Image(
                painter = painterResource(R.drawable.baseline_arrow_back_24),
                contentDescription = "Back to Login Screen",
                modifier = Modifier
                    .size(50.dp)
            )
        }
    }
}