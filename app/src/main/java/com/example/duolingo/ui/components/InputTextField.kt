package com.example.duolingo.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.duolingo.R

@Preview(showBackground = true)
@Composable
fun InputTextField(
    modifier: Modifier = Modifier.Companion,
    value: String = "",
    onValueChange: (String) -> Unit = {},
    onClickTogglePassword: () -> Unit = {},
    placeholder: String = "placeholder",
    isPasswordVisible: Boolean? = null
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = {
            Text(
                text = placeholder,
                fontSize = 20.sp,
                color = Color(0xFFCCCCCC)
            )
        },
        shape = RoundedCornerShape(10.dp),
        textStyle = TextStyle(
            fontSize = 20.sp
        ),
        visualTransformation = if (isPasswordVisible == false)
            PasswordVisualTransformation()
        else
            VisualTransformation.None,
        trailingIcon = {
            if (isPasswordVisible != null)
                Icon(
                    imageVector = ImageVector.Companion.vectorResource(
                        if (isPasswordVisible == true)
                            R.drawable.password_off
                        else
                            R.drawable.password
                    ),
                    contentDescription = "Icon Password Visible",
                    tint = Color.Unspecified,
                    modifier = Modifier.Companion
                        .size(26.dp)
                        .clickable {
                            onClickTogglePassword()
                        }
                )
        },
        modifier = modifier
            .fillMaxWidth()
            .border(
                2.dp,
                Color(0xFFE5E5E5),
                androidx.compose.foundation.shape.RoundedCornerShape(10.dp)
            )
    )
}