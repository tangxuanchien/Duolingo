package com.example.duolingo.ui.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.duolingo.R

@Composable
fun Lesson(modifier: Modifier = Modifier.Companion) {
    Box(
        modifier = Modifier.Companion.fillMaxWidth()
            .padding(top = 18.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.lesson_avatar),
            contentDescription = "Lesson Avatar",
            modifier = Modifier.Companion.align(Alignment.Companion.CenterStart)
                .size(220.dp)
                .padding(end = 50.dp)
        )
        Column(
            modifier = Modifier.Companion.fillMaxWidth()
                .align(Alignment.Companion.Center),
            horizontalAlignment = Alignment.Companion.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Icon(
                imageVector = ImageVector.Companion.vectorResource(R.drawable.level_start),
                contentDescription = "Icon Level",
                tint = Color.Companion.Unspecified,
                modifier = Modifier.Companion.size(80.dp)
            )
            Icon(
                imageVector = ImageVector.Companion.vectorResource(R.drawable.level_training),
                contentDescription = "Icon Level",
                tint = Color.Companion.Unspecified,
                modifier = Modifier.Companion
                    .padding(start = 80.dp)
                    .size(80.dp)
            )
            Icon(
                imageVector = ImageVector.Companion.vectorResource(R.drawable.level_repeat),
                contentDescription = "Icon Level",
                tint = Color.Companion.Unspecified,
                modifier = Modifier.Companion
                    .padding(start = 150.dp)
                    .size(80.dp)
            )
            Icon(
                imageVector = ImageVector.Companion.vectorResource(R.drawable.level_listen),
                contentDescription = "Icon Level",
                tint = Color.Companion.Unspecified,
                modifier = Modifier.Companion
                    .padding(start = 80.dp)
                    .size(80.dp)
            )
            Icon(
                imageVector = ImageVector.Companion.vectorResource(R.drawable.level_video),
                contentDescription = "Icon Level",
                tint = Color.Companion.Unspecified,
                modifier = Modifier.Companion.size(80.dp)
            )
        }
    }
}