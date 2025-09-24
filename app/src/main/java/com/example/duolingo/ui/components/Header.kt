package com.example.duolingo.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
fun Header(modifier: Modifier = Modifier.Companion) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row {
            Icon(
                imageVector = ImageVector.Companion.vectorResource(R.drawable.french),
                contentDescription = "Icon Navigation",
                tint = Color.Companion.Unspecified,
                modifier = Modifier.Companion.size(20.dp)
            )
            Text(
                text = "14",
                fontWeight = FontWeight.Companion.Bold,
                fontSize = 18.sp,
                color = Color(0xFF4B4B4B),
                modifier = Modifier.Companion.padding(start = 6.dp)
            )
        }
        Row {
            Icon(
                imageVector = ImageVector.Companion.vectorResource(R.drawable.streak),
                contentDescription = "Icon Navigation",
                tint = Color.Companion.Unspecified,
                modifier = Modifier.Companion.size(20.dp)
            )
            Text(
                text = "14",
                fontWeight = FontWeight.Companion.Bold,
                fontSize = 18.sp,
                color = Color(0xFFFF9600),
                modifier = Modifier.Companion.padding(start = 6.dp)
            )
        }
        Row {
            Icon(
                imageVector = ImageVector.Companion.vectorResource(R.drawable.ruby),
                contentDescription = "Icon Navigation",
                tint = Color.Companion.Unspecified,
                modifier = Modifier.Companion.size(20.dp)
            )
            Text(
                text = "14",
                fontWeight = FontWeight.Companion.Bold,
                fontSize = 18.sp,
                color = Color(0xFF1CB0F6),
                modifier = Modifier.Companion.padding(start = 6.dp)
            )
        }
        Row {
            Icon(
                imageVector = ImageVector.Companion.vectorResource(R.drawable.heart),
                contentDescription = "Icon Navigation",
                tint = Color.Companion.Unspecified,
                modifier = Modifier.Companion.size(20.dp)
            )
            Text(
                text = "14",
                fontWeight = FontWeight.Companion.Bold,
                fontSize = 18.sp,
                color = Color(0xFFFF4B4B),
                modifier = Modifier.Companion.padding(start = 6.dp)
            )
        }
    }
}