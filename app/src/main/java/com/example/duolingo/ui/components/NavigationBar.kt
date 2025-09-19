package com.example.duolingo.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.duolingo.R

@Composable
fun NavigationBar(modifier: Modifier = Modifier.Companion) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconNavigation(
            R.drawable.home
        )
        IconNavigation(
            R.drawable.treasure
        )
        IconNavigation(
            R.drawable.training
        )
        IconNavigation(
            R.drawable.chart
        )
        IconNavigation(
            R.drawable.vip
        )
        IconNavigation(
            R.drawable.options
        )
    }
}

