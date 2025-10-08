package com.example.duolingo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.duolingo.ui.lesson.LessonMatchPair
import com.example.duolingo.ui.lesson.LessonTypeInput

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//            Navigation()
            LessonTypeInput()
        }
    }
}