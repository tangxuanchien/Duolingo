package com.example.duolingo.ui.profile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedIconButton
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
import com.example.duolingo.ui.components.NavigationBar

@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(vertical = 10.dp, horizontal = 10.dp)
    ) {
        Column {
            Text(
                text = "Tang Xuan Chien",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = Color(0xFF4B4B4B)
            )
            Row {
                Text(
                    text = "@tangxchien",
                    fontSize = 16.sp,
                    color = Color(0xFF777777)
                )
                Text(
                    text = " · Joined November 2003",
                    fontSize = 16.sp,
                    color = Color(0xFF777777)
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                OutlinedButton(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color(0xFF1CB0F6),
                        containerColor = Color.White
                    ),
                    border = BorderStroke(3.dp, Color(0xFFE5E5E5))
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 80.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = ImageVector.Companion.vectorResource(R.drawable.add_friends),
                            contentDescription = "Icon Navigation",
                            tint = Color.Companion.Unspecified,
                            modifier = Modifier.size(25.dp)
                        )
                        Text(
                            text = "INVITE",
                            fontSize = 18.sp,
                            modifier = Modifier
                                .padding(start = 10.dp)
                        )
                    }
                }
                OutlinedButton(
                    onClick = {},
                    contentPadding = PaddingValues(0.dp),
                    border = BorderStroke(3.dp, Color(0xFFE5E5E5))
                ) {
                    Icon(
                        imageVector = ImageVector.Companion.vectorResource(R.drawable.share),
                        contentDescription = "Icon Navigation",
                        tint = Color.Companion.Unspecified,
                        modifier = Modifier.size(25.dp)
                    )
                }
            }
        }
        NavigationBar(
            modifier = Modifier
                .align(Alignment.BottomCenter)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewProfileScreen(
) {
    ProfileScreen()
}