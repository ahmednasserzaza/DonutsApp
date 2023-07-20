package com.fighter.donutsapp.ui.screens.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.fighter.donutsapp.R

@Composable
fun BottomNavigation(){
    Box(
        contentAlignment = Alignment.BottomCenter,
        modifier = Modifier.fillMaxHeight(1f).padding(bottom = 24.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .aspectRatio(1f)
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            BottomNavIcon(painter = painterResource(id = R.drawable.icon_home))
            BottomNavIcon(painter = painterResource(id = R.drawable.icon_heart))
            BottomNavIcon(painter = painterResource(id = R.drawable.icon_notification))
            BottomNavIcon(painter = painterResource(id = R.drawable.icon_buy))
            BottomNavIcon(painter = painterResource(id = R.drawable.icon_user))
        }
    }
}