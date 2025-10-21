package com.example.duolingo.ui.auth.signup

data class SignUpState(
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val username: String = ""
){
    fun isValid(): Boolean{
        return listOf(email, password, confirmPassword, username).all { it.isNotBlank() }
    }
}

sealed interface SignUpIntent{
    data class ChangeEmail(val email: String): SignUpIntent
    data class ChangePassword(val password: String): SignUpIntent
    data class ChangeConfirmPassword(val confirmPassword: String): SignUpIntent
    data class ChangeUsername(val username: String): SignUpIntent
    data object SignUp: SignUpIntent
}