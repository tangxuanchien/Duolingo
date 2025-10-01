package com.example.duolingo.ui.lesson

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.duolingo.R
import com.example.duolingo.ui.lesson.components.ResultStatCard

@Preview(showBackground = true)
@Composable
fun LessonSuccess(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 14.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
        ) {
            Image(
                painter = painterResource(R.drawable.lesson_success),
                contentDescription = "Lesson Success",
                modifier = Modifier
                    .size(500.dp)
            )
            Text(
                text = "Lesson complete!",
                fontSize = 34.sp,
                fontWeight = FontWeight.Companion.Bold,
                color = Color(0xFFFFC800),
                modifier = Modifier.padding(bottom = 40.dp)
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
            ) {
                ResultStatCard(
                    headerStat = "Total XP",
                    iconStat = R.drawable.thunder,
                    contentStat = "25",
                    colorStat = Color(0xFFFFC800)
                )
                ResultStatCard(
                    headerStat = "Good",
                    iconStat = R.drawable.target,
                    contentStat = "75%",
                    colorStat = Color(0xFF58CC02)
                )
                ResultStatCard(
                    headerStat = "Speedy",
                    iconStat = R.drawable.clock,
                    contentStat = "1:36",
                    colorStat = Color(0xFF1CB0F6)
                )
            }
        }

        Button(
            onClick = {},
            colors =
                ButtonDefaults.buttonColors(
                    contentColor = Color(0xFFFFFFFF),
                    containerColor = Color(0xFF1CB0F6)
                ),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 20.dp)
        ) {
            Row(
                modifier = Modifier.Companion
                    .fillMaxWidth(),
                verticalAlignment = Alignment.Companion.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Claim XP".uppercase(),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Companion.Bold
                )
            }
        }
    }
}

