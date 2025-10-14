package com.example.duolingo.ui.lesson.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
fun LessonQuestionListen(
    modifier: Modifier = Modifier.Companion,
    question: String = "We don't talk anymore",
    isCorrectLesson: Boolean? = false,
    onClickListen: () -> Unit = {},
    onClickListenSlow: () -> Unit = {}
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
                .offset(x = (-50).dp, y = (-20).dp)
        ) {
            Icon(
                imageVector = ImageVector.Companion.vectorResource(R.drawable.lession_message),
                contentDescription = "Icon Box",
                tint = Color.Companion.Unspecified,
                modifier = Modifier.Companion
                    .size(220.dp)
            )
            Icon(
                imageVector = ImageVector.Companion.vectorResource(R.drawable.speaker),
                contentDescription = "Icon Listen",
                tint = Color.Companion.Unspecified,
                modifier = Modifier.Companion
                    .size(45.dp)
                    .offset(x = 40.dp, y = 88.dp)
                    .clickable{
                        onClickListen()
                    }
            )
            VerticalDivider(
                thickness = 2.dp,
                color = Color(0xFFE5E5E5),
                modifier = Modifier.Companion.padding(top = 60.dp)
                    .height(80.dp)
                    .offset(x = 115.dp, y = 10.dp)
            )
            Icon(
                imageVector = ImageVector.Companion.vectorResource(R.drawable.speaker_slow),
                contentDescription = "Icon Listen",
                tint = Color(0xFF1CB0F6),
                modifier = Modifier.Companion
                    .size(50.dp)
                    .offset(x = 140.dp, y = 86.dp)
                    .clickable{
                        onClickListenSlow()
                    }
            )

        }
    }
}