package com.seunghoon.designsystem.ui.textfield

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.seunghoon.designsystem.ui.theme.GramColors
import com.seunghoon.designsystem.ui.theme.GramTypography
import kotlinx.coroutines.delay

@Composable
private fun GramTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    hint: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Default,
    isPassword: Boolean = false,
    isError: Boolean = false,
    title: String? = null,
    description: String? = null,
) {
    val hintAlpha by animateFloatAsState(
        targetValue = if (value.isEmpty()) 1f
        else 0f,
        label = "",
    )
    val descriptionColor by animateColorAsState(
        targetValue = if (isError) GramColors.System
        else GramColors.Gray800,
        label = "",
    )
    val borderColor by animateColorAsState(
        targetValue = if (isError) GramColors.System
        else GramColors.Gray1000,
        label = "",
    )

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                vertical = 8.dp,
                horizontal = 24.dp,
            ),
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        title?.run {
            Text(
                text = this,
                style = GramTypography.label,
                color = GramColors.Gray800,
            )
        }
        BasicTextField(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .background(
                    color = GramColors.Gray1000,
                )
                .border(
                    width = 2.dp,
                    color = borderColor,
                    shape = RoundedCornerShape(8.dp),
                )
                .padding(all = 16.dp),
            value = value,
            onValueChange = onValueChange,
            textStyle = GramTypography.m3.copy(color = GramColors.White),
            cursorBrush = SolidColor(value = GramColors.White),
            maxLines = 1,
            singleLine = true,
            visualTransformation = if (isPassword) PasswordVisualTransformation()
            else VisualTransformation.None,
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType,
                imeAction = imeAction,
            )
        ) { innerTextField ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.CenterStart) {
                    innerTextField()
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            modifier = Modifier.alpha(hintAlpha),
                            text = hint,
                            style = GramTypography.m3,
                            color = GramColors.Gray800,
                        )
                    }
                }
            }
        }
        description?.run {
            Text(
                text = this,
                style = GramTypography.label,
                color = descriptionColor,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun GramBasicTextFieldPreview() {
    var value by remember { mutableStateOf("") }
    var isError by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        while (true) {
            delay(3000)
            isError = !isError
        }
    }

    GramTextField(
        title = "제목",
        value = value,
        onValueChange = { value = it },
        hint = "비밀번호(영문, 숫자 8~12자)를 입력해 주세요",
        isError = isError,
        description = "실패 이유를 입력해주세요",
    )
}
