package com.seunghoon.designsystem.ui.card

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.seunghoon.designsystem.ui.theme.GramColors
import com.seunghoon.designsystem.utils.gramClickable

@Composable
fun GramCard(
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
    enabled: Boolean = true,
    content: @Composable () -> Unit,
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .height(120.dp)
            .gramClickable(
                onClick = { onClick?.invoke() },
                pressDepth = 0.98f,
                enabled = enabled,
            ),
        color = GramColors.Gray1100,
        shape = RoundedCornerShape(8.dp),
    ) {

    }
}

@Preview(showBackground = true)
@Composable
private fun GramCardPreview() {
    GramCard{

    }
}
