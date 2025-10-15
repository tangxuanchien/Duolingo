package com.example.duolingo.ui.login

data class LoginState(
    val email: String = "",
    val password: String = ""
)

sealed interface LoginIntent{
    data class ChangeEmail(val email: String): LoginIntent
    data class ChangePassword(val password: String): LoginIntent
    data object Login: LoginIntent
}