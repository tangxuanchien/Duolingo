package com.example.duolingo.ui.lesson.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
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


@Composable
fun LessonAction(
    modifier: Modifier = Modifier.Companion,
    isCheckLesson: Boolean = false,
    isCorrectLesson: Boolean? = null,
    answer: String = "Here",
    onClickCheckLesson: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(
                if (isCorrectLesson == true) {
                    Color(0xFFD6FFB8)
                } else if (isCorrectLesson == false) {
                    Color(0xFFffdfe0)
                } else {
                    Color.White
                }
            )
            .padding(horizontal = 14.dp, vertical = 10.dp)
    ) {
        if (isCorrectLesson != null) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp)
            ) {
                Column(
                    modifier = Modifier.align(Alignment.CenterStart)
                ) {
                    Row {
                        Icon(
                            imageVector = ImageVector.Companion.vectorResource(
                                if (isCorrectLesson == true) {
                                    R.drawable.circle_v
                                } else {
                                    R.drawable.circle_x
                                },
                            ),
                            contentDescription = "Icon Level",
                            tint = if (isCorrectLesson == true) {
                                Color.Unspecified
                            } else {
                                Color(0xFFff4b4b)
                            },
                            modifier = Modifier.Companion
                                .size(30.dp)
                        )
                        Text(
                            text = if (isCorrectLesson == true) {
                                "Nice!"
                            } else {
                                "Not correct!"
                            },
                            fontWeight = FontWeight.Companion.Bold,
                            fontSize = 24.sp,
                            color = if (isCorrectLesson == true) {
                                Color(0xFF58A700)
                            } else {
                                Color(0xFFff4b4b)
                            },
                            modifier = Modifier.padding(start = 6.dp)
                        )
                    }
                    if (!isCorrectLesson) {
                        Text(
                            text = "Answer:",
                            fontWeight = FontWeight.Companion.Bold,
                            fontSize = 20.sp,
                            color =
                                Color(0xFFff4b4b),
                            modifier = Modifier.padding(top = 10.dp)
                        )
                        Text(
                            text = answer,
                            fontSize = 20.sp,
                            color =
                                Color(0xFFff4b4b),
                            modifier = Modifier.padding(top = 10.dp)
                        )
                    }
                }
                Row(
                    modifier = Modifier.align(Alignment.TopEnd)
                ) {
                    Icon(
                        imageVector = ImageVector.Companion.vectorResource(R.drawable.share),
                        contentDescription = "Icon Level",
                        tint =
                            if (isCorrectLesson == true) {
                                Color(0xFF58A700)
                            } else {
                                Color(0xFFff4b4b)
                            },
                        modifier = Modifier.Companion
                            .size(30.dp)
                            .padding(end = 10.dp)
                    )
                    Icon(
                        imageVector = ImageVector.Companion.vectorResource(R.drawable.report),
                        contentDescription = "Icon Level",
                        tint = if (isCorrectLesson == true) {
                            Color(0xFF58A700)
                        } else {
                            Color(0xFFff4b4b)
                        },
                        modifier = Modifier.Companion
                            .size(30.dp)
                            .padding(start = 10.dp)
                    )
                }
            }
        }

        Button(
            onClick = if (isCheckLesson) {
                onClickCheckLesson
            } else {
                {}
            },
            colors =
                if (!isCheckLesson and (isCorrectLesson == null)) {
                    ButtonDefaults.buttonColors(
                        contentColor = Color(0xFF777777),
                        containerColor = Color(0xFFD9D9D9)
                    )
                } else if (isCheckLesson and (isCorrectLesson == false)) {
                    ButtonDefaults.buttonColors(
                        contentColor = Color(0xFFFFFFFF),
                        containerColor = Color(0xFFff4b4b)
                    )
                } else {
                    ButtonDefaults.buttonColors(
                        contentColor = Color(0xFFFFFFFF),
                        containerColor = Color(0xFF58CC02)
                    )
                },
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.padding(bottom = 20.dp)
        ) {
            Row(
                modifier = Modifier.Companion
                    .fillMaxWidth(),
                verticalAlignment = Alignment.Companion.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text =
                        if (isCorrectLesson == null) {
                            "Check".uppercase()
                        } else {
                            "Continue".uppercase()
                        },
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Companion.Bold
                )
            }
        }
    }
}

@Preview
@Composable
private fun PreviewUncheckLesson() {
    LessonAction(
        isCheckLesson = true
    )
}

@Preview
@Composable
private fun PreviewCheckLesson() {
    LessonAction(
        isCheckLesson = false
    )
}

@Preview
@Composable
private fun PreviewCorrectLesson() {
    LessonAction(
        isCorrectLesson = true,
        isCheckLesson = true
    )
}

@Preview
@Composable
private fun PreviewUnCorrectLesson() {
    LessonAction(
        isCorrectLesson = false,
        isCheckLesson = true
    )
}