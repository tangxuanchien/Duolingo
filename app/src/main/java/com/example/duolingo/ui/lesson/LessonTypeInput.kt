package com.example.duolingo.ui.lesson


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.duolingo.ui.lesson.components.LessonAction
import com.example.duolingo.ui.lesson.components.LessonHeader
import com.example.duolingo.ui.lesson.components.LessonQuestion

@Preview(showBackground = true)
@Composable
fun LessonTypeInput(
    modifier: Modifier = Modifier,
    onClickBack: () -> Unit = {},
    onClickLessonSuccess: () -> Unit = {},
) {
    var progress by remember { mutableFloatStateOf(0.2f) }
    var answer by remember { mutableStateOf("We can do it") }
    var input by remember { mutableStateOf("") }
    var question by remember { mutableStateOf("Chúng ta làm được!") }
    var hearts by remember { mutableIntStateOf(3) }
    var exercise by remember { mutableStateOf("Translate this sentence") }
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
            OutlinedTextField(
                value = input,
                onValueChange = {
                    input = it
                    isCheckLesson = input.isNotEmpty()
                },
                placeholder = {
                    Text(
                        text = "Type answer here ...",
                        fontSize = 20.sp,
                        color = Color(0xFFCCCCCC)
                    )
                },
                shape = RoundedCornerShape(10.dp),
                maxLines = 3,
                textStyle = TextStyle(
                    fontSize = 20.sp
                ),
                modifier = modifier
                    .fillMaxWidth()
                    .heightIn(min = 150.dp)
                    .offset(x = 0.dp, y = -(50).dp)
                    .border(2.dp, Color(0xFFE5E5E5), RoundedCornerShape(10.dp))
            )
        }
        LessonAction(
            modifier = Modifier
                .align(Alignment.BottomCenter),
            isCheckLesson = isCheckLesson,
            isCorrectLesson = isCorrectLesson,
            answer = answer,
            onClickCheckLesson = {
                isCorrectLesson = answer.equals(input.trim(), ignoreCase = true)
            },
            onClickLessonSuccess = onClickLessonSuccess
        )
    }
}


