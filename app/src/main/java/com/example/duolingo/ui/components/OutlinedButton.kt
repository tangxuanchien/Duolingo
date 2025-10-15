package com.example.duolingo.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
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
fun OutlinedButton(
    modifier: Modifier = Modifier.Companion,
    text: String = "Text Button",
    onClick: () -> Unit = {},
    fontWeight: FontWeight = FontWeight.Normal,
    enabledIcon: Boolean = false,
    isSignUpButton: Boolean = false
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clip(RoundedCornerShape(10.dp))
            .border(2.dp, Color(0xFFE5E5E5), RoundedCornerShape(10.dp))
            .drawBehind {
                val strokeWidth = 4.dp.toPx()
                val y = size.height - strokeWidth / 2
                drawLine(
                    color = Color(0xFFE5E5E5),
                    start = Offset(0f, y),
                    end = Offset(size.width, y),
                    strokeWidth = strokeWidth
                )
            }
            .clickable {
                onClick()
            }
            .background(
                if(isSignUpButton){
                    Color(0xFF1CB0F6)
                } else {
                    Color.White
                }
            )
    ) {
        if (enabledIcon) {
            Icon(
                imageVector = ImageVector.Companion.vectorResource(R.drawable.google),
                contentDescription = "Icon Level",
                tint = Color.Unspecified,
                modifier = Modifier.Companion
                    .size(30.dp)
                    .offset(50.dp, 0.dp)
                    .align(Alignment.CenterStart)
            )
        }
        Text(
            text = text,
            fontSize = 20.sp,
            color = if(!isSignUpButton) Color(0xFF4B4B4B) else Color.White,
            fontWeight = fontWeight,
            modifier = modifier
                .align(Alignment.Center)
                .padding(vertical = 12.dp)
        )
    }
}