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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.duolingo.R

@Composable
fun FriendStreaks(modifier: Modifier = Modifier.Companion) {
    Box(
        modifier = Modifier.Companion
            .border(
                2.dp,
                Color(0xFFE5E5E5),
                RoundedCornerShape(16.dp)
            )
            .padding(10.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.Companion
                .padding(vertical = 8.dp, horizontal = 6.dp)
        ) {
            Text(
                text = "Friend Streaks",
                fontWeight = FontWeight.Companion.Bold,
                fontSize = 24.sp,
                color = Color(0xFF4B4B4B)
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.Companion
                    .fillMaxWidth()
                    .padding(vertical = 10.dp)
            ) {
                Icon(
                    imageVector = ImageVector.Companion.vectorResource(R.drawable.friend_streaks),
                    contentDescription = "Icon Overview",
                    tint = Color.Companion.Unspecified,
                    modifier = Modifier.Companion.size(40.dp)
                )
                Icon(
                    imageVector = ImageVector.Companion.vectorResource(R.drawable.friend_streaks),
                    contentDescription = "Icon Overview",
                    tint = Color.Companion.Unspecified,
                    modifier = Modifier.Companion.size(40.dp)
                )
                Icon(
                    imageVector = ImageVector.Companion.vectorResource(R.drawable.friend_streaks),
                    contentDescription = "Icon Overview",
                    tint = Color.Companion.Unspecified,
                    modifier = Modifier.Companion.size(40.dp)
                )
                Icon(
                    imageVector = ImageVector.Companion.vectorResource(R.drawable.friend_streaks),
                    contentDescription = "Icon Overview",
                    tint = Color.Companion.Unspecified,
                    modifier = Modifier.Companion.size(40.dp)
                )
                Icon(
                    imageVector = ImageVector.Companion.vectorResource(R.drawable.friend_streaks),
                    contentDescription = "Icon Overview",
                    tint = Color.Companion.Unspecified,
                    modifier = Modifier.Companion.size(40.dp)
                )
            }
        }
    }
}