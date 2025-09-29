package com.example.duolingo.ui.lesson

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.duolingo.R
import com.example.duolingo.ui.lesson.components.LessonAction
import com.example.duolingo.ui.lesson.components.LessonHeader

@Preview(showBackground = true)
@Composable
fun LessonScreen(modifier: Modifier = Modifier) {
    var progress by remember { mutableFloatStateOf(0.3f) }
    var words by remember { mutableStateOf("We can do it!") }
    val vocabulary = remember { words.split(" ").toMutableStateList() }
    var result = remember { mutableStateListOf<String>() }
    var isCheckLesson by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(bottom = 10.dp, top = 20.dp, start = 14.dp, end = 14.dp)
    ) {
        Column(
            modifier = Modifier.align(Alignment.TopCenter)
        ) {
            LessonHeader()
            Text(
                text = "Translate this sentence",
                fontWeight = FontWeight.Companion.Bold,
                fontSize = 24.sp,
                color = Color(0xFF4B4B4B),
                modifier = Modifier.padding(vertical = 14.dp)
            )
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(R.drawable.lesson_avatar_uncheck),
                    contentDescription = "Lesson Avatar",
                    modifier = Modifier
                        .size(170.dp)
                        .offset(x = (-40).dp, y = 0.dp)
                )
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .offset(x = (-10).dp, y = (-40).dp)
                ) {
                    Icon(
                        imageVector = ImageVector.Companion.vectorResource(R.drawable.lession_message),
                        contentDescription = "Icon Level",
                        tint = Color.Companion.Unspecified,
                        modifier = Modifier.Companion
                            .size(255.dp)
                    )
                    Icon(
                        imageVector = ImageVector.Companion.vectorResource(R.drawable.speaker),
                        contentDescription = "Icon Level",
                        tint = Color.Companion.Unspecified,
                        modifier = Modifier.Companion
                            .size(30.dp)
                            .offset(x = 30.dp, y = 90.dp)
                    )
                    Text(
                        text = "Chúng ta làm được!",
                        fontSize = 22.sp,
                        lineHeight = 30.sp,
                        color = Color(0xFF4B4B4B),
                        modifier = Modifier
                            .offset(x = 65.dp, y = 90.dp)
                            .width(170.dp)
                    )
                }
            }
            HorizontalDivider(
                thickness = 3.dp,
                color = Color.LightGray,
                modifier = Modifier.padding(bottom = 20.dp)
            )
            Row {
                result.forEach { word ->
                    Box(
                        modifier = Modifier
                            .padding(horizontal = 4.dp)
                            .border(2.dp, Color(0xFFE5E5E5), RoundedCornerShape(10.dp))
                            .clickable {
                                result.remove(word)
                                vocabulary.add(word)
                                isCheckLesson = vocabulary.isEmpty()
                            }
                    ) {
                        Text(
                            text = word,
                            fontSize = 22.sp,
                            color = Color(0xFF4B4B4B),
                            modifier = Modifier.padding(horizontal = 14.dp, vertical = 10.dp)
                        )
                    }
                }
            }
            HorizontalDivider(
                thickness = 3.dp,
                color = Color.LightGray,
                modifier = Modifier.padding(vertical = 20.dp)
            )
            HorizontalDivider(
                thickness = 3.dp,
                color = Color.LightGray,
                modifier = Modifier.padding(vertical = 20.dp)
            )
            Row {
                vocabulary.forEach { word ->
                    Box(
                        modifier = Modifier
                            .padding(horizontal = 4.dp)
                            .border(2.dp, Color(0xFFE5E5E5), RoundedCornerShape(10.dp))
                            .clickable {
                                vocabulary.remove(word)
                                result.add(word)
                                isCheckLesson = vocabulary.isEmpty()
                            }
                    ) {
                        Text(
                            text = word,
                            fontSize = 22.sp,
                            color = Color(0xFF4B4B4B),
                            modifier = Modifier.padding(horizontal = 14.dp, vertical = 10.dp)
                        )
                    }
                }
            }
        }
        LessonAction(
            modifier = Modifier
                .align(Alignment.BottomCenter),
            isCheckLesson = isCheckLesson,
            onClickCheckLesson = {
                Log.d("Check", "LessonScreen: true")
            }
        )
    }
}

