package com.fighter.donutsapp.ui.screens.composable

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fighter.donutsapp.ui.theme.Black
import com.fighter.donutsapp.ui.theme.Inter

@Composable
fun SimpleTitle(modifier: Modifier = Modifier ,text:String , color:Color){
    Text(
        modifier = modifier.padding(top = 8.dp, start = 16.dp),
        text = text,
        fontSize = 20.sp,
        fontFamily = Inter,
        fontWeight = FontWeight.SemiBold,
        color = Black
    )
}