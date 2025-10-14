package com.example.duolingo.ui.lesson.read

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.duolingo.ui.lesson.components.BoxPair
import com.example.duolingo.ui.lesson.components.LessonAction
import com.example.duolingo.ui.lesson.components.LessonHeader
import kotlinx.coroutines.delay

data class WordPair(
    var left: String?,
    var right: String?,
    var isWordPair: MutableState<Boolean> = mutableStateOf(false)
)

@Preview(showBackground = true)
@Composable
fun LessonMatchPair(
    modifier: Modifier = Modifier,
    onClickBack: () -> Unit = {},
    onClickLessonSuccess: () -> Unit = {},
) {

    var progress by remember { mutableFloatStateOf(0.2f) }
    var answer = remember {
        mutableStateListOf(
            WordPair("viết", "write"),
            WordPair("chơi", "play"),
            WordPair("thành phố", "city"),
            WordPair("bài hát", "music")
        )
    }
    var hearts by remember { mutableIntStateOf(3) }
    var exercise by remember { mutableStateOf("Tap the matching pairs") }
    var pair by remember { mutableStateOf(WordPair(null, null)) }
    var wrongPair by remember { mutableStateOf(WordPair(null, null)) }
    var isCheckLesson by remember { mutableStateOf(false) }
    var isCorrectLesson by remember { mutableStateOf<Boolean?>(null) }

    LaunchedEffect(wrongPair) {
        delay(1000)
        wrongPair = WordPair(null, null)
    }

    fun checkPair() {
        answer.forEach { item ->
            if (item.left == pair.left && item.right == pair.right) {
                item.isWordPair.value = true
                pair = WordPair(null, null)
            }
        }

        if (answer.all { it.isWordPair.value == true }) {
            Log.d("TAG", "checkPair: true")
            isCheckLesson = true
            isCorrectLesson = true
        } else {
            Log.d("TAG", "checkPair: false")
            Log.d("TAG", "checkPair: $answer")
        }

        if (pair.left != null && pair.right != null) {
            wrongPair = pair
            pair = WordPair(null, null)
        }
    }

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
                hearts = hearts,
                exercise = exercise
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center),
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                answer.forEach { item ->
                    BoxPair(
                        item = item,
                        text = item.left,
                        isChoose = pair.left == item.left,
                        isWrongPair = wrongPair.left == item.left,
                        onClickBoxPair = {
                            pair = pair.copy(left = item.left)
                            checkPair()
                        }
                    )
                }
            }
            Column(
                modifier = Modifier.weight(1f)
            ) {
                answer.forEach { item ->
                    BoxPair(
                        item = item,
                        text = item.right,
                        isChoose = pair.right == item.right,
                        isWrongPair = wrongPair.right == item.right,
                        onClickBoxPair = {
                            pair = pair.copy(right = item.right)
                            checkPair()
                        }
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


