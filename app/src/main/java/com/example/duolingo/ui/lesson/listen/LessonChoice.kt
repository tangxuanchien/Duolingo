package com.example.duolingo.ui.lesson.listen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import com.example.duolingo.ui.lesson.components.LessonAction
import com.example.duolingo.ui.lesson.components.LessonHeader
import com.example.duolingo.ui.lesson.components.LessonQuestion
import com.example.duolingo.ui.lesson.components.LessonQuestionListen

@Preview(showBackground = true)
@Composable
fun LessonChoice(
    modifier: Modifier = Modifier,
    onClickBack: () -> Unit = {},
    onClickLessonSuccess: () -> Unit = {},
) {
    var progress by remember { mutableFloatStateOf(0.2f) }
    var answer = remember {
        mutableStateListOf(
            "in the morning",
            "before evening",
            "go to market",
            "playing game"
        )
    }
    val context = LocalContext.current
    var question by remember { mutableStateOf("Chúng ta làm được!") }
    var hearts by remember { mutableIntStateOf(3) }
    var exercise by remember { mutableStateOf("Tap what you hear") }
    var result = remember { mutableStateListOf<String>() }
    var isCheckLesson by remember { mutableStateOf(false) }
    var isCorrectLesson by remember { mutableStateOf<Boolean?>(null) }
    var audio = loadAllMp3Files(context)
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
            LessonQuestionListen(
                question = question,
                isCorrectLesson = isCorrectLesson,
                onClickListen = {
                    playAudio(context, audio.first().path.toUri())
                },
                onClickListenSlow = {
                    playAudioSlow(context, audio.first().path.toUri())
                }
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                answer.forEach { item ->
                    Box(
                        modifier = Modifier
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
                            }
                    ) {
                        Text(
                            text = item,
                            fontSize = 22.sp,
                            color = Color(0xFF4B4B4B),
                            modifier = Modifier
                                .align(Alignment.Center)
                                .padding(horizontal = 14.dp, vertical = 10.dp)
                        )
                    }
                }
            }
        }
        LessonAction(
            modifier = Modifier
                .align(Alignment.BottomCenter),
            isCheckLesson = isCheckLesson,
            isCorrectLesson = isCorrectLesson,
            onClickCheckLesson = {

            },
            onClickLessonSuccess = onClickLessonSuccess
        )
    }
}


