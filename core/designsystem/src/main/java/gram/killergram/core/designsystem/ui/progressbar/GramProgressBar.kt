package gram.killergram.core.designsystem.ui.progressbar

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.seunghoon.designsystem.ui.theme.GramColors
import kotlinx.coroutines.delay

@Composable
fun GramProgressBar(
    maxCount: Int,
    currentStep: Int,
) {
    val progressWidth by animateFloatAsState(
        targetValue = (currentStep - 1) / (maxCount - 1).toFloat(),
        label = "",
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(12.dp)
                .background(GramColors.Gray1000),
        )
        Box(
            modifier = Modifier
                .size(
                    width = 24.dp,
                    height = 12.dp,
                )
                .background(GramColors.Secondary)
        )
        Box(
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .background(GramColors.Secondary)
                .fillMaxWidth(progressWidth)
                .height(12.dp)
                .background(GramColors.Secondary),
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Transparent)
                .padding(horizontal = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            for (i in 1..maxCount) {
                Indicator(activated = i <= currentStep)
            }
        }
    }
}

@Composable
private fun Indicator(activated: Boolean) {
    val color by animateColorAsState(
        targetValue = if (activated) GramColors.Main
        else GramColors.Gray900,
        label = "",
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
