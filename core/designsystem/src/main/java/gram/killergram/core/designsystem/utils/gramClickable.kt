package gram.killergram.core.designsystem.utils

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale

@Composable
fun Modifier.gramClickable(
    onClick: () -> Unit,
    pressDepth: Float = 0.97f,
    enabled: Boolean = true,
): Modifier {
    val interactionSource = remember { MutableInteractionSource() }
    val scale by animateFloatAsState(
        targetValue = if (interactionSource.collectIsPressedAsState().value) pressDepth
        else 1f,
        label = "",
    )

    return scale(scale).clickable(
        onClick = onClick,
        interactionSource = interactionSource,
        indication = null,
        enabled = enabled,
    )
}
