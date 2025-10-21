package com.example.duolingo.ui.auth.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.duolingo.ui.auth.components.AuthButton
import com.example.duolingo.ui.components.InputTextField

@Preview(showBackground = true)
@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    onClickSignUp: () -> Unit = {},
) {
    var viewModel: SignUpViewModel = hiltViewModel()
    val state by viewModel.state.collectAsState()
    var isPasswordVisible by remember { mutableStateOf(false) }
    var isConfirmPasswordVisible by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 12.dp)
            .padding(top = 16.dp)
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 50.dp)
        ) {
            Text(
                text = "Sign up account",
                fontWeight = FontWeight.Companion.Bold,
                fontSize = 26.sp,
                color = Color(0xFF4B4B4B),
                modifier = Modifier.Companion.padding(vertical = 14.dp)
            )
            InputTextField(
                value = state.username,
                onValueChange = {
                    viewModel.processIntent(SignUpIntent.ChangeUsername(it))
                },
                placeholder = "Username",
                modifier = Modifier.padding(bottom = 20.dp)
            )
            InputTextField(
                value = state.email,
                onValueChange = {
                    viewModel.processIntent(SignUpIntent.ChangeEmail(it))
                },
                placeholder = "Email",
                modifier = Modifier.padding(bottom = 20.dp)
            )
            InputTextField(
                value = state.password,
                onValueChange = {
                    viewModel.processIntent(SignUpIntent.ChangePassword(it))
                },
                placeholder = "Password",
                isPasswordVisible = isPasswordVisible,
                onClickTogglePassword = {
                    isPasswordVisible = !isPasswordVisible
                },
                modifier = Modifier.padding(bottom = 20.dp)
            )
            InputTextField(
                value = state.confirmPassword,
                onValueChange = {
                    viewModel.processIntent(SignUpIntent.ChangeConfirmPassword(it))
                },
                placeholder = "Confirm Password",
                isPasswordVisible = isConfirmPasswordVisible,
                onClickTogglePassword = {
                    isConfirmPasswordVisible = !isConfirmPasswordVisible
                },
                modifier = Modifier.padding(bottom = 20.dp)
            )
            AuthButton(
                text = "SignUp",
                enabled = state.email.isNotEmpty() && state.password.isNotEmpty() && state.confirmPassword.isNotEmpty() && state.username.isNotEmpty(),
                onClick = {
                    viewModel.processIntent(SignUpIntent.SignUp)
                }
            )
        }
    }
}

