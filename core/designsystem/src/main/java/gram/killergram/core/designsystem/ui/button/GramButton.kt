package gram.killergram.core.designsystem.ui.button

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.seunghoon.designsystem.ui.theme.GramColors
import com.seunghoon.designsystem.ui.theme.GramTypography
import com.seunghoon.designsystem.utils.gramClickable
import com.seunghoon.designsystem.utils.keyboardAsState

@Composable
fun GramBasicButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String,
    enabled: Boolean = true,
    isKeyboardInteractionMode: Boolean = false,
) {
    val backgroundColor by animateColorAsState(
        targetValue = if (enabled) GramColors.Main
        else GramColors.Gray1000,
        label = "",
    )
    val textColor by animateColorAsState(
        targetValue = if (enabled) GramColors.Secondary
        else GramColors.Gray700,
        label = "",
    )
    val horizontalPadding by animateDpAsState(
        targetValue = if (keyboardAsState().value && isKeyboardInteractionMode) 0.dp
        else 24.dp,
        label = "",
    )
    val verticalPadding by animateDpAsState(
        targetValue = if (keyboardAsState().value && isKeyboardInteractionMode) 0.dp
        else 16.dp,
        label = "",
    )
    val cornerShape by animateDpAsState(
        targetValue = if (keyboardAsState().value && isKeyboardInteractionMode) 0.dp
        else 8.dp,
        label = "",
    )

    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                horizontal = horizontalPadding,
                vertical = verticalPadding,
            )
            .gramClickable(onClick = onClick)
            .clip(RoundedCornerShape(cornerShape))
            .background(backgroundColor)
            .padding(vertical = 16.dp),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = text,
            style = GramTypography.m3,
            color = textColor,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun GramBasicButtonPreview() {
    Column {
        GramBasicButton(
            onClick = {},
            text = "로그인",
        )
    }
}
