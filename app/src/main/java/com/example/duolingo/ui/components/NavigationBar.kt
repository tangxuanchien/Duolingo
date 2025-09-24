package com.example.duolingo.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.duolingo.R

@Preview(showBackground = true)
@Composable
fun NavigationBar(modifier: Modifier = Modifier.Companion) {
    Column(
        modifier = modifier
    ) {
        HorizontalDivider(
            thickness = 2.dp,
            color = Color.LightGray,
        )
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 14.dp)
                .padding(bottom = 10.dp, top = 8.dp),
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
}

