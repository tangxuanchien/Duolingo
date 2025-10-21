package com.example.duolingo.ui.auth.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun AuthButton(
    modifier: Modifier = Modifier.Companion,
    onClick: () -> Unit = {},
    enabled: Boolean = false,
    text: String = "AuthButton"
) {
    Button(
        onClick = onClick,
        colors =
            if (!enabled) {
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
        enabled = enabled,
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier.Companion.padding(bottom = 30.dp)
    ) {
        Row(
            modifier = Modifier.Companion
                .fillMaxWidth(),
            verticalAlignment = Alignment.Companion.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = text.uppercase(),
                fontSize = 18.sp,
                fontWeight = FontWeight.Companion.Bold
            )
        }
    }
}