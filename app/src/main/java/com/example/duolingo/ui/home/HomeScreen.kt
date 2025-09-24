package com.example.duolingo.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.duolingo.ui.components.Header
import com.example.duolingo.ui.components.NavigationBar
import com.example.duolingo.ui.home.components.Lesson
import com.example.duolingo.ui.home.components.LessonTitle

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(bottom = 10.dp, top = 20.dp)
    ) {
        Box(
            modifier = Modifier
                .padding(horizontal = 14.dp)
                .align(Alignment.TopCenter)
        ) {
            Column {
                Header()
                LessonTitle()
                Lesson()
            }
        }
        NavigationBar(
            modifier = Modifier
                .align(Alignment.BottomCenter)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewHomeScreen(
) {
    HomeScreen()
}