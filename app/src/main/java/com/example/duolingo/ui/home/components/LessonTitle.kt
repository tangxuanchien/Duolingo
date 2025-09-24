package com.example.duolingo.ui.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.duolingo.R

@Composable
fun LessonTitle(
    lessonTitle: String = "Say where people are from",
    lessonProgress: String = "Section 2, Unit 10",
    modifier: Modifier = Modifier.Companion
) {
    Row(
        modifier = Modifier.Companion
            .padding(top = 16.dp)
            .fillMaxWidth()
            .background(Color(0xFFCE82FF), RoundedCornerShape(16.dp))
            .padding(vertical = 14.dp, horizontal = 16.dp),
        verticalAlignment = Alignment.Companion.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(
                text = lessonProgress.uppercase(),
                color = Color(0xFFEDD1FF),
                fontSize = 18.sp,
                fontWeight = FontWeight.Companion.Bold
            )
            Text(
                text = lessonTitle,
                color = Color(0xFFFFFFFF),
                fontSize = 20.sp,
                fontWeight = FontWeight.Companion.Bold
            )
        }
        Box(
            modifier = Modifier.Companion.width(50.dp)
        ) {
            VerticalDivider(
                thickness = 3.dp,
                modifier = Modifier.Companion
                    .padding(horizontal = 6.dp)
                    .height(50.dp),
                color = Color(0xFFA568CC),
            )
            Icon(
                imageVector = ImageVector.Companion.vectorResource(R.drawable.book),
                contentDescription = "Icon Header",
                tint = Color.Companion.Unspecified,
                modifier = Modifier.Companion.size(26.dp)
                    .align(Alignment.Companion.CenterEnd)
            )
        }
    }
}