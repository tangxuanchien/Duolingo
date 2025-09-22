package com.example.duolingo.ui.profile.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
fun Overview(
    score: String = "10",
    dayStreak: String = "10",
    league: String = "10",
    totalXP: String = "10",
    modifier: Modifier = Modifier.Companion
) {
    Column(
        modifier = Modifier.padding(vertical = 10.dp)
    ) {
        Text(
            text = "Overview",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = Color(0xFF4B4B4B)
        )
        Row(
            modifier = Modifier.Companion
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Box(
                modifier = Modifier.Companion
                    .border(2.dp, Color(0xFFE5E5E5), RoundedCornerShape(16.dp))
                    .padding(10.dp)
                    .weight(1f)
            ) {
                Row {
                    Icon(
                        imageVector = ImageVector.Companion.vectorResource(R.drawable.streak),
                        contentDescription = "Icon Overview",
                        tint = Color.Companion.Unspecified,
                        modifier = Modifier.Companion.size(18.dp)
                    )
                    Column(
                        modifier = Modifier.Companion.padding(start = 10.dp)
                    ) {
                        Text(
                            text = dayStreak,
                            color = Color(0xFF4B4B4B),
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Companion.Bold
                        )
                        Text(
                            text = "Day streak",
                            fontSize = 18.sp,
                            color = Color(0xFFAFAFAF)
                        )
                    }
                }
            }
            Box(
                modifier = Modifier.Companion
                    .border(
                        2.dp,
                        Color(0xFFE5E5E5),
                        androidx.compose.foundation.shape.RoundedCornerShape(16.dp)
                    )
                    .padding(10.dp)
                    .weight(1f)
            ) {
                Row {
                    Icon(
                        imageVector = ImageVector.Companion.vectorResource(R.drawable.thunder),
                        contentDescription = "Icon Overview",
                        tint = Color.Companion.Unspecified,
                        modifier = Modifier.Companion.size(18.dp)
                    )
                    Column(
                        modifier = Modifier.Companion.padding(start = 10.dp)
                    ) {
                        Text(
                            text = totalXP,
                            color = Color(0xFF4B4B4B),
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Companion.Bold
                        )
                        Text(
                            text = "Total XP",
                            fontSize = 18.sp,
                            color = Color(0xFFAFAFAF)
                        )
                    }
                }
            }
        }
        Row(
            modifier = Modifier.Companion.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Box(
                modifier = Modifier.Companion
                    .border(
                        2.dp,
                        Color(0xFFE5E5E5),
                        androidx.compose.foundation.shape.RoundedCornerShape(16.dp)
                    )
                    .padding(10.dp)
                    .weight(1f)
            ) {
                Row {
                    Icon(
                        imageVector = ImageVector.Companion.vectorResource(R.drawable.chart),
                        contentDescription = "Icon Overview",
                        tint = Color.Companion.Unspecified,
                        modifier = Modifier.Companion.size(18.dp)
                    )
                    Column(
                        modifier = Modifier.Companion.padding(start = 10.dp)
                    ) {
                        Text(
                            text = league,
                            color = Color(0xFF4B4B4B),
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Companion.Bold
                        )
                        Text(
                            text = "League",
                            fontSize = 18.sp,
                            color = Color(0xFFAFAFAF)
                        )
                    }
                }
            }
            Box(
                modifier = Modifier.Companion
                    .border(
                        2.dp,
                        Color(0xFFE5E5E5),
                        androidx.compose.foundation.shape.RoundedCornerShape(16.dp)
                    )
                    .padding(10.dp)
                    .weight(1f)
            ) {
                Row {
                    Icon(
                        imageVector = ImageVector.Companion.vectorResource(R.drawable.training),
                        contentDescription = "Icon Overview",
                        tint = Color.Companion.Unspecified,
                        modifier = Modifier.Companion.size(18.dp)
                    )
                    Column(
                        modifier = Modifier.Companion.padding(start = 10.dp)
                    ) {
                        Text(
                            text = score,
                            color = Color(0xFF4B4B4B),
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Companion.Bold
                        )
                        Text(
                            text = "English Score",
                            fontSize = 18.sp,
                            color = Color(0xFFAFAFAF)
                        )
                    }
                }
            }
        }
    }
}