package com.fighter.donutsapp.ui.screens.composable

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import com.fighter.donutsapp.ui.theme.Gray
import com.fighter.donutsapp.ui.theme.Inter

@Composable
fun HomeDescription(text:String) {
    Text(
        text = text,
        fontSize = 14.sp,
        overflow = TextOverflow.Clip,
        maxLines = 1,
        fontFamily = Inter,
        fontWeight = FontWeight.Medium,
        color = Gray
    )
}