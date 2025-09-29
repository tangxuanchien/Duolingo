package com.example.duolingo.ui.lesson.components

import android.service.autofill.OnClickAction
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LessonAction(
    modifier: Modifier = Modifier.Companion,
    isCheckLesson: Boolean = false,
    onClickCheckLesson: () -> Unit = {}
) {
    Button(
        onClick = onClickCheckLesson,
        colors =
            if (!isCheckLesson) {
                ButtonDefaults.buttonColors(
                    contentColor = Color(0xFF777777),
                    containerColor = Color(0xFFD9D9D9)
                )
            } else {
                ButtonDefaults.buttonColors(
                    contentColor = Color(0xFFFFFFFF),
                    containerColor = Color(0xFF58CC02)
                )
            },
        shape = RoundedCornerShape(12.dp),
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.Companion
                .fillMaxWidth(),
            verticalAlignment = Alignment.Companion.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Check".uppercase(),
                fontSize = 18.sp,
                fontWeight = FontWeight.Companion.Bold
            )
        }
    }
}