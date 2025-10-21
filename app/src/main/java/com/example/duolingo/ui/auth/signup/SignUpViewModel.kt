package com.example.duolingo.ui.auth.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.duolingo.database.entity.User
import com.example.duolingo.database.repository.UserRepository
import com.example.duolingo.log
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {
    private val _state = MutableStateFlow(SignUpState())
    val state: StateFlow<SignUpState> = _state

    fun processIntent(intent: SignUpIntent) {
        when (intent) {
            is SignUpIntent.ChangeEmail -> {
                _state.update {
                    it.copy(email = intent.email)
                }
            }

            is SignUpIntent.ChangePassword -> {
                _state.update {
                    it.copy(password = intent.password)
                }
            }

            is SignUpIntent.ChangeConfirmPassword -> {
                _state.update {
                    it.copy(confirmPassword = intent.confirmPassword)
                }
            }

            is SignUpIntent.ChangeUsername -> {
                _state.update {
                    it.copy(username = intent.username)
                }
            }

            SignUpIntent.SignUp -> {
                val currentState = _state.value
                if (currentState.password == currentState.confirmPassword && currentState.isValid()) {
                    viewModelScope.launch {
                        userRepository.insert(
                            User(
                                username = currentState.username,
                                email = currentState.email,
                                password = currentState.password
                            )
                        )
                    }
                    log("true")
                } else {
                    log("false")
                }
            }

        }
    }
}