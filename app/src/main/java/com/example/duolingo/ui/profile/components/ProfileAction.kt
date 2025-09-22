package com.example.duolingo.ui.profile.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
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
fun ProfileAction(
    onClickShare: () -> Unit = {},
    onClickInvite: () -> Unit = {},
    modifier: Modifier = Modifier.Companion
) {
    Row(
        modifier = Modifier.Companion.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        OutlinedButton(
            onClick = onClickInvite,
            colors = ButtonDefaults.buttonColors(
                contentColor = Color(0xFF1CB0F6),
                containerColor = Color.Companion.White
            ),
            border = BorderStroke(3.dp, Color(0xFFE5E5E5))
        ) {
            Row(
                modifier = Modifier.Companion.padding(horizontal = 80.dp),
                verticalAlignment = Alignment.Companion.CenterVertically
            ) {
                Icon(
                    imageVector = ImageVector.Companion.vectorResource(R.drawable.add_friends),
                    contentDescription = "Icon Profile",
                    tint = Color.Companion.Unspecified,
                    modifier = Modifier.Companion.size(25.dp)
                )
                Text(
                    text = "INVITE",
                    fontSize = 18.sp,
                    modifier = Modifier.Companion
                        .padding(start = 10.dp)
                )
            }
        }
        OutlinedButton(
            onClick = onClickShare,
            contentPadding = PaddingValues(0.dp),
            border = BorderStroke(3.dp, Color(0xFFE5E5E5))
        ) {
            Icon(
                imageVector = ImageVector.Companion.vectorResource(R.drawable.share),
                contentDescription = "Icon Profile",
                tint = Color.Companion.Unspecified,
                modifier = Modifier.Companion.size(25.dp)
            )
        }
    }
}