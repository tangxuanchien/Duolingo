package com.example.duolingo.ui.lesson.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.duolingo.R

@Preview(showBackground = true)
@Composable
fun LessonHeader(
    progress: Float = 0.4f,
    hearts: Int = 3,
    onClickBack: () -> Unit = {},
    exercise: String = "Exercise",
    modifier: Modifier = Modifier
) {
    Column {
        Row(
            modifier = modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Companion.CenterVertically
        ) {
            Icon(
                imageVector = ImageVector.Companion.vectorResource(R.drawable.cancel),
                contentDescription = "Icon Lesson",
                tint = Color.Companion.Unspecified,
                modifier = Modifier.Companion.size(24.dp)
                    .clickable {
                        onClickBack()
                    }
            )
            LinearProgressIndicator(
                progress = { progress },
                modifier = Modifier.Companion
                    .height(16.dp)
                    .width(200.dp),
                color = Color(0xFFFFC800),
                trackColor = Color(0xFFE5E5E5)
            )
            Row {
                Icon(
                    imageVector = ImageVector.Companion.vectorResource(R.drawable.heart),
                    contentDescription = "Icon Lesson",
                    tint = Color.Companion.Unspecified,
                    modifier = Modifier.Companion.size(20.dp)
                )
                Text(
                    text = hearts.toString(),
                    fontWeight = FontWeight.Companion.Bold,
                    fontSize = 18.sp,
                    color = Color(0xFFFF4B4B),
                    modifier = Modifier.Companion.padding(start = 6.dp)
                )
            }
        }
        Text(
            text = exercise,
            fontWeight = FontWeight.Companion.Bold,
            fontSize = 24.sp,
            color = Color(0xFF4B4B4B),
            modifier = Modifier.Companion.padding(top = 14.dp)
        )
    }
}