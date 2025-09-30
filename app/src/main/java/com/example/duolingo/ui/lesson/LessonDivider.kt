package com.example.duolingo.ui.lesson

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun LessonDivider(modifier: Modifier = Modifier.Companion) {
    Box(
        modifier = modifier
            .padding(horizontal = 12.dp)
            .padding(bottom = 100.dp)
    ) {
        Column {
            HorizontalDivider(
                thickness = 3.dp,
                color = Color.Companion.LightGray
            )
            HorizontalDivider(
                thickness = 3.dp,
                color = Color.Companion.LightGray,
                modifier = Modifier.Companion.padding(top = 60.dp)
            )
            HorizontalDivider(
                thickness = 3.dp,
                color = Color.Companion.LightGray,
                modifier = Modifier.Companion.padding(top = 60.dp)
            )
        }
    }
}