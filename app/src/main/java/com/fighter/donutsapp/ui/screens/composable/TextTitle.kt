package com.fighter.donutsapp.ui.screens.composable

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.fighter.donutsapp.ui.theme.Inter
import com.fighter.donutsapp.ui.theme.PrimaryColor

@Composable
fun TextTitle(modifier: Modifier = Modifier, text: String) {
    Text(
        modifier = modifier,
        text = text,
        fontSize = 28.sp,
        fontFamily = Inter,
        fontWeight = FontWeight.SemiBold,
        color = PrimaryColor
    )
}