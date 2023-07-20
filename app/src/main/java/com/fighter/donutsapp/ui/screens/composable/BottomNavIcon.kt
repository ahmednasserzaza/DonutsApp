package com.fighter.donutsapp.ui.screens.composable

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import com.fighter.donutsapp.ui.theme.PrimaryColor

@Composable
fun BottomNavIcon(painter: Painter){
    Icon(
        modifier = Modifier.size(28.dp),
        painter = painter,
        contentDescription = "", tint = PrimaryColor
    )
}