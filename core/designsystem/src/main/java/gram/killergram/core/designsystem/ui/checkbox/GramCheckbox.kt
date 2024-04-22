package gram.killergram.core.designsystem.ui.checkbox

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.seunghoon.core.designsystem.R
import com.seunghoon.designsystem.ui.theme.GramColors
import com.seunghoon.designsystem.utils.gramClickable

@Composable
fun GramCheckBox(
    modifier: Modifier = Modifier,
    checked: Boolean = false,
    onClick: () -> Unit,
) {
    val backgroundColor by animateColorAsState(
        targetValue = if (checked) GramColors.Main
        else GramColors.Gray800,
        label = "",
    )
    val tintColor by animateColorAsState(
        targetValue = if (checked) GramColors.Secondary
        else GramColors.Gray300,
        label = "",
    )

    Box(
        modifier = modifier
            .gramClickable(onClick = onClick)
            .padding(all = 4.dp)
            .clip(RoundedCornerShape(2.dp))
            .background(color = backgroundColor)
            .padding(
                vertical = 6.dp,
                horizontal = 4.dp,
            ),
        contentAlignment = Alignment.Center,
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_check),
            contentDescription = null,
            tint = tintColor,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun GramCheckboxPreview() {
    var checked by remember { mutableStateOf(false) }

    GramCheckBox(checked = checked) {
        checked = !checked
    }
}
