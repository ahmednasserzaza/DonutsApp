package com.fighter.donutsapp.ui.screens.composable

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fighter.donutsapp.ui.theme.Inter
import com.fighter.donutsapp.ui.theme.PrimaryColor100

@Composable
fun SubTitle(modifier: Modifier = Modifier, text: String, fontSize: Int) {
    Text(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 19.dp, start = 40.dp, end = 40.dp),
        text = text,
        color = PrimaryColor100,
        fontFamily = Inter,
        fontSize = fontSize.sp,
        fontWeight = FontWeight.Medium
    )
}