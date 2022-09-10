package com.example.commonlib.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import com.example.animationt1.ui.theme.Typography

private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200
)

private val LightColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200,

     //Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
)

@Composable
fun AnimationT1Theme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}

/*
@ExperimentalUnitApi
@Immutable
sealed class Theme {

    abstract val colors: Colors

    //open val extendedColors = createExtendedColors()

    //open val typography: ReplacementTypography = createReplacementTypography()

    object Theme1 : Theme() {
        override val colors = Colors(
            primary = BrandPrimary.Red.C500.color,
            primaryVariant = BrandPrimary.Navy.C800.color,
            secondary = BrandPrimary.Navy.C600.color,
            secondaryVariant = BrandPrimary.Navy.C200.color,
            background = Neutral.Grey.CWhite.color,
            surface = Neutral.Grey.CWhite.color,
            error = BrandPrimary.Red.C800.color,
            onPrimary = Neutral.Grey.CWhite.color,
            onSecondary = Neutral.Grey.CWhite.color,
            onBackground = BrandPrimary.Navy.C900.color,
            onSurface = BrandPrimary.Navy.C900.color,
            onError = Neutral.Grey.CWhite.color,
            isLight = true
        )

        */
/*override val extendedColors = ExtendedColors(
            surfaceEmphasis = BrandSecondary.Green.C800.color,
            surfaceSecondary = Neutral.Grey.C700.color,
            surfaceSeparator = Neutral.Grey.C300.color,
            surfaceBackground = Neutral.Grey.C100.color,
        )*//*

    }

    object Theme2Fresh : Theme() {
        override val colors = Colors(
            primary = BrandPrimary.Red.C500.color,
            primaryVariant = BrandPrimary.Navy.C800.color,
            secondary = BrandPrimary.Navy.C600.color,
            secondaryVariant = BrandPrimary.Navy.C200.color,
            background = Neutral.Background.Latte.color,
            surface = Neutral.Grey.CWhite.color,
            error = BrandPrimary.Red.C800.color,
            onPrimary = Neutral.Grey.CWhite.color,
            onSecondary = BrandPrimary.Navy.C900.color,
            onBackground = BrandPrimary.Navy.C900.color,
            onSurface = BrandPrimary.Navy.C900.color,
            onError = Neutral.Grey.CWhite.color,
            isLight = true
        )

        */
/*override val extendedColors = ExtendedColors(
            surfaceEmphasis = BrandSecondary.Blue.C700.color,
            surfaceSecondary = Neutral.Grey.C700.color,
            surfaceSeparator = Neutral.Grey.C300.color,
            surfaceBackground = Neutral.Grey.C100.color,
        )*//*

    }

    object Theme2Trust : Theme() {
        override val colors = Colors(
            primary = BrandPrimary.Red.C500.color,
            primaryVariant = BrandPrimary.Navy.C800.color,
            secondary = BrandPrimary.Navy.C600.color,
            secondaryVariant = BrandPrimary.Navy.C200.color,
            background = BrandPrimary.Navy.C800.color,
            surface = Neutral.Grey.CWhite.color,
            error = BrandPrimary.Red.C800.color,
            onPrimary = Neutral.Grey.CWhite.color,
            onSecondary = BrandPrimary.Navy.C900.color,
            onBackground = Neutral.Grey.CWhite.color,
            onSurface = BrandPrimary.Navy.C900.color,
            onError = Neutral.Grey.CWhite.color,
            isLight = true
        )

       */
/* override val extendedColors = ExtendedColors(
            surfaceEmphasis = BrandSecondary.Blue.C700.color,
            surfaceSecondary = Neutral.Grey.C700.color,
            surfaceSeparator = Neutral.Grey.C300.color,
            surfaceBackground = Neutral.Grey.C100.color,
        )*//*

    }

    object Theme2Energy : Theme() {
        override val colors = Colors(
            primary = BrandPrimary.Red.C500.color,
            primaryVariant = BrandPrimary.Navy.C800.color,
            secondary = BrandPrimary.Navy.C600.color,
            secondaryVariant = BrandPrimary.Navy.C200.color,
            background = BrandSecondary.Blue.C100.color,
            surface = Neutral.Grey.CWhite.color,
            error = BrandPrimary.Red.C800.color,
            onPrimary = Neutral.Grey.CWhite.color,
            onSecondary = BrandPrimary.Navy.C900.color,
            onBackground = BrandPrimary.Navy.C900.color,
            onSurface = BrandPrimary.Navy.C900.color,
            onError = Neutral.Grey.CWhite.color,
            isLight = true
        )

        */
/*override val extendedColors = ExtendedColors(
            surfaceEmphasis = BrandSecondary.Blue.C700.color,
            surfaceSecondary = Neutral.Grey.C700.color,
            surfaceSeparator = Neutral.Grey.C300.color,
            surfaceBackground = Neutral.Grey.C100.color,
        )*//*

    }

    object Theme3Tender : Theme() {
        override val colors = Colors(
            primary = BrandPrimary.Red.C500.color,
            primaryVariant = BrandPrimary.Navy.C800.color,
            secondary = BrandPrimary.Navy.C600.color,
            secondaryVariant = BrandPrimary.Navy.C200.color,
            background = Neutral.Grey.CWhite.color,
            surface = BrandSecondary.Latte.C100.color,
            error = BrandPrimary.Red.C800.color,
            onPrimary = Neutral.Grey.CWhite.color,
            onSecondary = Neutral.Grey.CWhite.color,
            onBackground = BrandPrimary.Navy.C900.color,
            onSurface = BrandPrimary.Navy.C900.color,
            onError = Neutral.Grey.CWhite.color,
            isLight = true
        )
    }

    object Theme3Happy : Theme() {
        override val colors = Colors(
            primary = BrandPrimary.Red.C500.color,
            primaryVariant = BrandPrimary.Navy.C800.color,
            secondary = BrandPrimary.Navy.C600.color,
            secondaryVariant = BrandPrimary.Navy.C200.color,
            background = Neutral.Grey.CWhite.color,
            surface = BrandSecondary.Blue.C100.color,
            error = BrandPrimary.Red.C800.color,
            onPrimary = Neutral.Grey.CWhite.color,
            onSecondary = Neutral.Grey.CWhite.color,
            onBackground = BrandPrimary.Navy.C900.color,
            onSurface = BrandSecondary.Blue.C700.color,
            onError = Neutral.Grey.CWhite.color,
            isLight = true
        )
    }

    object Theme3Lush : Theme() {
        override val colors = Colors(
            primary = BrandPrimary.Red.C500.color,
            primaryVariant = BrandPrimary.Navy.C800.color,
            secondary = BrandPrimary.Navy.C600.color,
            secondaryVariant = BrandPrimary.Navy.C200.color,
            background = Neutral.Grey.CWhite.color,
            surface = BrandPrimary.Navy.C800.color,
            error = BrandPrimary.Red.C800.color,
            onPrimary = Neutral.Grey.CWhite.color,
            onSecondary = Neutral.Grey.CWhite.color,
            onBackground = BrandPrimary.Navy.C900.color,
            onSurface = Neutral.Grey.CWhite.color,
            onError = Neutral.Grey.CWhite.color,
            isLight = true
        )
    }
}
*/
