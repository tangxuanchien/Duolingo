package com.example.duolingo.ui.lesson.listen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import com.example.duolingo.ui.lesson.components.LessonAction
import com.example.duolingo.ui.lesson.components.LessonHeader
import com.example.duolingo.ui.lesson.components.LessonQuestionListen
import com.example.duolingo.ui.components.OutlinedButton

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
                    OutlinedButton(
                        text = item,
                        onClick = {},
                    )
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


