package com.fighter.donutsapp.ui.screens.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import com.fighter.donutsapp.ui.theme.PinkColor
import com.fighter.donutsapp.ui.theme.PrimaryColor

@Composable
fun IconSearch( modifier: Modifier = Modifier ,painter: Painter) {
    Icon(
        modifier = modifier
            .clip(shape = RoundedCornerShape(12.dp))
            .background(PinkColor)
            .padding(8.dp),
        painter = painter,
        contentDescription = "",
        tint = PrimaryColor
    )
}