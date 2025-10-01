package com.example.duolingo.ui.lesson.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
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
fun ResultStatCard(
    modifier: Modifier = Modifier.Companion,
    headerStat: String = "Header",
    contentStat: String = "Card",
    iconStat: Int = R.drawable.heart,
    colorStat: Color = Color.Companion.Red
) {
    Box(
        modifier = Modifier.Companion
            .background(colorStat, RoundedCornerShape(18.dp))
            .height(94.dp)
    ) {
        Text(
            text = headerStat.uppercase(),
            fontSize = 14.sp,
            fontWeight = FontWeight.Companion.Bold,
            color = Color(0xFFFFFFFF),
            modifier = Modifier.Companion
                .align(Alignment.Companion.TopCenter)
                .padding(top = 6.dp)
        )
        Box(
            modifier = Modifier.Companion
                .align(Alignment.Companion.BottomCenter)
                .padding(vertical = 2.dp, horizontal = 2.dp)
                .background(
                    Color(0xFFFFFFFF),
                    androidx.compose.foundation.shape.RoundedCornerShape(18.dp)
                )
                .height(66.dp)
                .width(104.dp)
        ) {
            Box(modifier = Modifier.Companion.align(Alignment.Companion.Center)) {
                Row {
                    Icon(
                        imageVector = ImageVector.Companion.vectorResource(
                            iconStat
                        ),
                        contentDescription = "Icon Stat",
                        tint = Color.Companion.Unspecified,
                        modifier = Modifier.Companion
                            .size(26.dp)
                    )
                    Text(
                        text = contentStat,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Companion.Bold,
                        color = colorStat,
                        modifier = Modifier.Companion.padding(start = 6.dp)
                    )
                }
            }
        }
    }
}