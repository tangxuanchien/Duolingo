package com.example.duolingo.ui.lesson.read

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.duolingo.ui.lesson.components.LessonAction
import com.example.duolingo.ui.lesson.components.LessonDivider
import com.example.duolingo.ui.lesson.components.LessonHeader
import com.example.duolingo.ui.lesson.components.LessonQuestion

@Preview(showBackground = true)
@Composable
fun LessonMatchWord(
    modifier: Modifier = Modifier,
    onClickBack: () -> Unit = {},
    onClickLessonSuccess: () -> Unit = {},
) {
    var progress by remember { mutableFloatStateOf(0.2f) }
    var answer by remember { mutableStateOf("We can do it!") }
    var question by remember { mutableStateOf("Chúng ta làm được!") }
    var hearts by remember { mutableIntStateOf(3) }
    var exercise by remember { mutableStateOf("Translate this sentence") }
    val vocabulary = remember { answer.split(" ").shuffled().toMutableStateList() }
    var result = remember { mutableStateListOf<String>() }
    var isCheckLesson by remember { mutableStateOf(false) }
    var isCorrectLesson by remember { mutableStateOf<Boolean?>(null) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(horizontal = 12.dp)
                .padding(top = 16.dp)
        ) {
            LessonHeader(
                onClickBack = onClickBack,
                progress = progress,
                exercise = exercise,
                hearts = hearts
            )
            LessonQuestion(
                question = question,
                isCorrectLesson = isCorrectLesson
            )
        }
        Box(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(horizontal = 12.dp)
                .padding(
                    bottom =
                        if (result.size <= 5) {
                            160.dp
                        } else {
                            100.dp
                        }
                )
        ) {
            Column {
                FlowRow(
                    maxItemsInEachRow = 5,
                    modifier = Modifier
                        .padding(vertical = 4.dp)
                ) {
                    result.forEach { word ->
                        Box(
                            modifier = Modifier
                                .padding(horizontal = 4.dp, vertical = 4.dp)
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
                                .clickable(
                                    enabled = !(isCheckLesson and (isCorrectLesson != null))
                                ) {
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
            }
        }

        LessonDivider(
            modifier = Modifier.align(Alignment.Center)
        )

        FlowRow(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
                .padding(top = 240.dp)
                .padding(horizontal = 12.dp)
        ) {
            vocabulary.forEach { word ->
                Box(
                    modifier = Modifier
                        .padding(horizontal = 4.dp, vertical = 4.dp)
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
        LessonAction(
            modifier = Modifier
                .align(Alignment.BottomCenter),
            isCheckLesson = isCheckLesson,
            isCorrectLesson = isCorrectLesson,
            answer = answer,
            onClickCheckLesson = {
                isCorrectLesson = result.joinToString(" ") == answer
            },
            onClickLessonSuccess = onClickLessonSuccess
        )
    }
}


