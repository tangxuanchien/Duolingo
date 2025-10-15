package com.example.duolingo.ui.login

import androidx.lifecycle.ViewModel
import com.example.duolingo.log
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class LoginViewModel: ViewModel(){
    private val _state = MutableStateFlow(LoginState())
    val state: StateFlow<LoginState> = _state

    fun processIntent(intent: LoginIntent){
        when(intent) {
            is LoginIntent.ChangeEmail -> {
                _state.update {
                    it.copy(email = intent.email)
                }
            }
            is LoginIntent.ChangePassword -> {
                _state.update {
                    it.copy(password = intent.password)
                }
            }
            LoginIntent.Login -> {
                val currentState = _state.value
                if(currentState.password == "1" && currentState.email == "chien@gmail.com"){
                    log("true")
                } else {
                    log("false")
                }
            }
        }
    }
}