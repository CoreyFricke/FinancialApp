package com.example.financialapp

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class PremadeComposables {
    @Composable
    fun TitleText(){
        Text(
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Center,
            text = "New User Signup",
            fontSize = 50.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            lineHeight = 40.sp
        )
    }

}