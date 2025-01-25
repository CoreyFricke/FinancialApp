package com.example.financialapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LoginScreenViewModel: ViewModel() {
    var number by mutableIntStateOf(0)
    var userInput by mutableStateOf("")

    fun addOne(){
        number++
    }

    fun MultiplyByTwo() : Int{
        return number * 2
    }

}