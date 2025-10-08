package com.example.duolingo.ui.lesson.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.duolingo.R

@Preview(showBackground = true)
@Composable
fun LessonQuestion(
    modifier: Modifier = Modifier.Companion,
    question: String = "We don't talk anymore",
    isCorrectLesson: Boolean? = false
) {
    Box(
        modifier = Modifier.Companion.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(
                if (isCorrectLesson == true) {
                    R.drawable.lesson_avatar_check
                } else {
                    R.drawable.lesson_avatar_uncheck
                }
            ),
            contentDescription = "Lesson Avatar",
            modifier = Modifier.Companion
                .size(170.dp)
                .offset(x = (-40).dp, y = 0.dp)
        )
        Box(
            modifier = Modifier.Companion
                .align(Alignment.Companion.CenterEnd)
                .offset(x = (-10).dp, y = (-40).dp)
        ) {
            Icon(
                imageVector = ImageVector.Companion.vectorResource(R.drawable.lession_message),
                contentDescription = "Icon Level",
                tint = Color.Companion.Unspecified,
                modifier = Modifier.Companion
                    .size(255.dp)
            )
            Icon(
                imageVector = ImageVector.Companion.vectorResource(R.drawable.speaker),
                contentDescription = "Icon Level",
                tint = Color.Companion.Unspecified,
                modifier = Modifier.Companion
                    .size(30.dp)
                    .offset(x = 30.dp, y = 90.dp)
            )
            Text(
                text = question,
                fontSize = 22.sp,
                lineHeight = 36.sp,
                color = Color(0xFF4B4B4B),
                modifier = Modifier.Companion
                    .offset(x = 66.dp, y = 88.dp)
                    .width(170.dp)
            )
        }
    }
}