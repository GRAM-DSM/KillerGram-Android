package com.seunghoon.designsystem.ui.theme

import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.sp
import com.seunghoon.core.designsystem.R

// 디자인에 맞는 폰트 추가해서 사용
private val PretendardFontFamily = FontFamily(
    listOf(
        Font(
            resId = R.font.pretendard_semi_bold,
            weight = FontWeight.SemiBold,
        )
    )
)

private val platFormTextStyle = PlatformTextStyle(
    includeFontPadding = false,
)

// 이름 변경해서 사용
object GramTypography {
    val h1 = TextStyle(
        fontFamily = PretendardFontFamily,
        fontSize = 32.sp,
        lineHeight = TextUnit(
            value = 1.2f,
            type = TextUnitType.Sp,
        ),
        platformStyle = platFormTextStyle,
    )

    val h2 = TextStyle(
        fontFamily = PretendardFontFamily,
        fontSize = 38.sp,
        lineHeight = TextUnit(
            value = 1.2f,
            type = TextUnitType.Sp,
        ),
        platformStyle = platFormTextStyle,
    )

    val h3 = TextStyle(
        fontFamily = PretendardFontFamily,
        fontSize = 24.sp,
        lineHeight = TextUnit(
            value = 1.3f,
            type = TextUnitType.Sp,
        ),
        platformStyle = platFormTextStyle,
    )

    val m1 = TextStyle(
        fontFamily = PretendardFontFamily,
        fontSize = 20.sp,
        lineHeight = TextUnit(
            value = 1.5f,
            type = TextUnitType.Sp,
        ),
        platformStyle = platFormTextStyle,
    )

    val m2 = TextStyle(
        fontFamily = PretendardFontFamily,
        fontSize = 18.sp,
        lineHeight = TextUnit(
            value = 1.5f,
            type = TextUnitType.Sp,
        ),
        platformStyle = platFormTextStyle,
    )

    val m3 = TextStyle(
        fontFamily = PretendardFontFamily,
        fontSize = 16.sp,
        lineHeight = TextUnit(
            value = 1.5f,
            type = TextUnitType.Sp,
        ),
        platformStyle = platFormTextStyle,
    )

    val label = TextStyle(
        fontFamily = PretendardFontFamily,
        fontSize = 14.sp,
        lineHeight = TextUnit(
            value = 1.5f,
            type = TextUnitType.Sp,
        ),
        platformStyle = platFormTextStyle,
    )
}
