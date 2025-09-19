package com.example.duolingo.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp

@Composable
fun IconNavigation(
    icon: Int,
    modifier: Modifier = Modifier
) {
    Icon(
        imageVector = ImageVector.Companion.vectorResource(icon),
        contentDescription = "Icon Navigation",
        tint = Color.Companion.Unspecified,
        modifier = Modifier.size(35.dp)
    )
}