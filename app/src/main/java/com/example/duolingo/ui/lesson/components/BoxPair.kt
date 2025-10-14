package com.example.duolingo.ui.lesson.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.duolingo.ui.lesson.read.WordPair

@Preview(showBackground = true)
@Composable
fun BoxPair(
    modifier: Modifier = Modifier.Companion,
    item: WordPair = WordPair("word", "word"),
    text: String? = "Word",
    isChoose: Boolean = false,
    isWrongPair: Boolean = false,
    onClickBoxPair: () -> Unit = {}
) {
    Box(
        modifier = Modifier.Companion
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth()
            .background(
                if (item.isWordPair.value == true) Color(0xFFecffde) else if(isWrongPair) Color(0xFFffdfe0) else if(isChoose) Color(0xFFb5def2) else Color.White
            )
            .border(
                2.dp,
                if (item.isWordPair.value == true) Color(0xFFa4da7c) else if(isWrongPair) Color(0xFFff4b4b) else if(isChoose) Color(0xFF1cb0f6) else Color(0xFFE5E5E5),
                RoundedCornerShape(10.dp)
            )
            .clickable (
                enabled = item.isWordPair.value != true,
                onClick = onClickBoxPair
            )
    ) {
        Text(
            text = text.toString(),
            fontSize = 18.sp,
            color = if (item.isWordPair.value == true) Color(0xFFa3d97b) else if(isWrongPair) Color(0xFFff4b4b) else if(isChoose) Color(0xFF1cb0f6) else Color(0xFF4B4B4B),
            modifier = Modifier.Companion
                .padding(vertical = 24.dp)
                .align(Alignment.Companion.Center),
        )
    }
}