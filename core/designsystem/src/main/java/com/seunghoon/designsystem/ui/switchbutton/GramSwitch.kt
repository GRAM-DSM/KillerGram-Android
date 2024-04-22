package com.seunghoon.designsystem.ui.switchbutton

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.seunghoon.designsystem.ui.theme.GramColors

@Composable
fun GramSwitch(
    modifier: Modifier = Modifier,
    checked: Boolean,
    onClick: () -> Unit,
) {
    val trackColor by animateColorAsState(
        targetValue = if (checked) GramColors.Secondary
        else GramColors.Gray700,
        label = "",
    )
    val thumbColor by animateColorAsState(
        targetValue = if (checked) GramColors.Main
        else GramColors.Gray400,
        label = "",
    )
    val position by animateDpAsState(
        targetValue = if (checked) 24.dp
        else 0.dp,
        label = "",
    )

    Row(
        modifier = modifier
            .width(48.dp)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                onClick = onClick,
                indication = null,
            )
            .clip(RoundedCornerShape(16.dp))
            .background(color = trackColor)
            .padding(all = 2.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            modifier = Modifier
                .size(20.dp)
                .offset(x = position)
                .clip(CircleShape)
                .background(color = thumbColor)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun GramSwitchPreview() {
    var checked by remember { mutableStateOf(false) }

    GramSwitch(checked = checked) {
        checked = !checked
    }
}
