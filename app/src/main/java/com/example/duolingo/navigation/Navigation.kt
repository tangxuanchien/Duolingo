package com.example.duolingo.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entry
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.example.duolingo.ui.home.HomeScreen
import com.example.duolingo.ui.lesson.LessonScreen
import com.example.duolingo.ui.profile.ProfileScreen

sealed interface Screen {
    data object Home : Screen
    data object Profile : Screen
    data object Lesson : Screen
}

@Composable
fun Navigation(modifier: Modifier = Modifier) {
    val backStack = remember { mutableStateListOf<Screen>(Screen.Home) }

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<Screen.Home> {
                HomeScreen(
                    onClickNavHome = {
                        backStack.add(Screen.Home)
                    },
                    onClickNavProfile = {
                        backStack.add(Screen.Profile)
                    },
                    onClickNavLesson = {
                        backStack.add(Screen.Lesson)
                    }
                )
            }
            entry<Screen.Profile> {
                ProfileScreen(

                )
            }
            entry<Screen.Lesson> {
                LessonScreen(

                )
            }
        }
    )
}