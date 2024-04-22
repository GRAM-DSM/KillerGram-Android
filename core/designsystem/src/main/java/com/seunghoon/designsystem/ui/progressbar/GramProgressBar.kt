package com.seunghoon.designsystem.ui.progressbar

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.seunghoon.designsystem.ui.theme.GramColors
import kotlinx.coroutines.delay

@Composable
fun GramProgressBar(
    maxCount: Int,
    currentStep: Int,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(GramColors.Gray1000)
                .padding(horizontal = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            for (i in 1..maxCount) {
                Indicator(activated = false)
            }
        }
        Row(
            modifier = Modifier
                .background(GramColors.Secondary)
                .padding(horizontal = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            for (i in 1..minOf(maxCount, currentStep)) {
                Indicator(activated = true)
            }
        }
    }
}

@Composable
private fun Indicator(activated: Boolean) {
    val color by animateColorAsState(
        targetValue = if (activated) GramColors.Main
        else GramColors.Gray900,
    )

    Box(
        modifier = Modifier
            .size(12.dp)
            .clip(CircleShape)
            .background(color = color),
    )
}

@Preview(showBackground = false)
@Composable
private fun GramProgressBarPreview() {
    var currentStep by remember { mutableIntStateOf(1) }

    LaunchedEffect(Unit) {
        while (true) {
            delay(3000)
            currentStep++
        }
    }

    GramProgressBar(
        maxCount = 4,
        currentStep = currentStep,
    )
}
