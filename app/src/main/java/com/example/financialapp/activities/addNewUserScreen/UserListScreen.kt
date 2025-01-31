package com.example.financialapp.activities.addNewUserScreen

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.financialapp.activities.Screens
import com.example.financialapp.databases.expenditureDatabase.userInfoDatabase.UserInfo


class UserListScreen {

    @Composable
    fun Base(viewModel: UserListScreenViewModel, navController: NavController){
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
                    .background(Color.Gray)
                    .size(120.dp)
            ){
                Text(
                    modifier = Modifier
                        .padding(16.dp),
                    textAlign = TextAlign.Center,
                    text = "New User Debug",
                    fontSize = 50.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            }
            Button(onClick = {
                navController.navigate(Screens.loginScreen.name)
            }) {
                Text(
                    text = "Previous Screen"
                )
            }

            List(viewModel, viewModel.getUserList())
        }
    }

    @Composable
    fun List(viewModel: UserListScreenViewModel, list : List<UserInfo>){
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth(),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(list){user ->
                ListItem(viewModel, user)
            }
        }
    }

    @Composable
    fun ListItem(
        viewModel: UserListScreenViewModel,
        userInfo: UserInfo
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
                    text = "Username: " + userInfo.userName,
                )
                Text(
                    modifier = Modifier
                        .padding(4.dp),
                    text = "Password: " +userInfo.password
                )
                Text(
                    modifier = Modifier
                        .padding(4.dp),
                    text = "Email: " + userInfo.email
                )
                Text(
                    modifier = Modifier
                        .padding(4.dp),
                    text = "Age: " + userInfo.age.toString()
                )
                Text(
                    modifier = Modifier
                        .padding(4.dp),
                    text = "ID: " + userInfo.id
                )
            }
            Button(
                modifier = Modifier
                    .align(Alignment.CenterEnd),
                onClick = {
                    viewModel.deleteUser(userInfo.userName, userInfo.id.toString())
            }) {
                Text(
                    text = "Delete User"
                )
            }
        }
    }
}
