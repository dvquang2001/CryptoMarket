package jetpack.tutorial.cryptoapp.ui.theme

import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import jetpack.tutorial.cryptoapp.R

private val OpenSans = FontFamily(
    Font(R.font.open_sans_light, FontWeight.Light),
    Font(R.font.open_sans_regular, FontWeight.Normal),
    Font(R.font.open_sans_medium, FontWeight.Medium),
    Font(R.font.open_sans_semi_bold, FontWeight.SemiBold),
    Font(R.font.open_sans_bold, FontWeight.Bold),
    Font(R.font.open_sans_extra_bold, FontWeight.ExtraBold),
)

private val SmallTextSize = 12.sp
private val MediumTextSize = 14.sp
private val LargeTextSize = 16.sp

private val SmallTextHeight = 16.sp
private val MediumTextHeight = 20.sp
private val LargeTextHeight = 24.sp

// Text Style
val BaseTextStyle = TextStyle(
    fontFamily = OpenSans,
    platformStyle = PlatformTextStyle(includeFontPadding = false)
)

// Light
val LightStyle = BaseTextStyle.copy(fontWeight = FontWeight.Light)
val SmallTextLight = LightStyle.copy(fontSize = SmallTextSize, lineHeight = SmallTextHeight)
val MediumTextLight = LightStyle.copy(fontSize = MediumTextSize, lineHeight = MediumTextHeight)
val LargeTextLight = LightStyle.copy(fontSize = LargeTextSize, lineHeight = LargeTextHeight)

// Regular
val RegularStyle = BaseTextStyle.copy(fontWeight = FontWeight.Normal)
val SmallTextRegular = RegularStyle.copy(fontSize = SmallTextSize, lineHeight = SmallTextHeight)
val MediumTextRegular = RegularStyle.copy(fontSize = MediumTextSize, lineHeight = MediumTextHeight)
val LargeTextRegular = RegularStyle.copy(fontSize = LargeTextSize, lineHeight = LargeTextHeight)

// Medium
val MediumStyle = BaseTextStyle.copy(fontWeight = FontWeight.Medium)
val SmallTextMedium = MediumStyle.copy(fontSize = SmallTextSize, lineHeight = SmallTextHeight)
val MediumTextMedium = MediumStyle.copy(fontSize = MediumTextSize, lineHeight = MediumTextHeight)
val LargeTextMedium = MediumStyle.copy(fontSize = LargeTextSize, lineHeight = LargeTextHeight)

// SemiBold
val SemiBoldStyle = BaseTextStyle.copy(fontWeight = FontWeight.SemiBold)
val SmallTextSemiBold = SemiBoldStyle.copy(fontSize = SmallTextSize, lineHeight = SmallTextHeight)
val MediumTextSemiBold = SemiBoldStyle.copy(fontSize = MediumTextSize, lineHeight = MediumTextHeight)
val LargeTextSemiBold = SemiBoldStyle.copy(fontSize = LargeTextSize, lineHeight = LargeTextHeight)

// Bold
val BoldStyle = BaseTextStyle.copy(fontWeight = FontWeight.Bold)
val SmallTextBold = BoldStyle.copy(fontSize = SmallTextSize, lineHeight = SmallTextHeight)
val MediumTextBold = BoldStyle.copy(fontSize = MediumTextSize, lineHeight = MediumTextHeight)
val LargeTextBold = BoldStyle.copy(fontSize = LargeTextSize, lineHeight = LargeTextHeight)

// ExtraBold
val ExtraBoldStyle = BaseTextStyle.copy(fontWeight = FontWeight.ExtraBold)
val SmallTextExtraBold = ExtraBoldStyle.copy(fontSize = SmallTextSize, lineHeight = SmallTextHeight)
val MediumTextExtraBold = ExtraBoldStyle.copy(fontSize = MediumTextSize, lineHeight = MediumTextHeight)
val LargeTextExtraBold = ExtraBoldStyle.copy(fontSize = LargeTextSize, lineHeight = LargeTextHeight)