package com.example.commonlib.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)


private val Black = Color(0xFF000000)
private val Grey800 = Color(0xFF33464A)
private val Grey700 = Color(0xFF505D6D)
private val Grey600 = Color(0xFF667483)
private val Grey500 = Color(0xFF808B98)
private val Grey400 = Color(0xFFB3BAC1)
private val Grey300 = Color(0xFFCCD1D6)
private val Grey200 = Color(0xFFE6E8EA)
private val Grey100 = Color(0xFFF3F4F6)
private val Grey50 = Color(0xFFF6F7F8)
private val White = Color(0xFFFFFFFF)

private val Navy900 = Color(0xFF172C42)
private val Navy800 = Color(0xFF213F5F)
private val Navy700 = Color(0xFF2E5884)
private val Navy600 = Color(0xFF3B71AA)
private val Navy200 = Color(0xFFCEE0F3)

private val Red800 = Color(0xFFCF230C)
private val Red500 = Color(0xFFEF5844)
private val Red400 = Color(0xFFF38172)
private val Red200 = Color(0xFFFBD4D0)
private val Red100 = Color(0xFFFCE9E7)

private val Blue900 = Color(0xFF083093)
private val Blue700 = Color(0xFF015AC8)
private val Blue500 = Color(0xFF3A94ED)
private val Blue300 = Color(0xFF9CC9F6)
private val Blue100 = Color(0xFFE7F0FB)

private val Yellow800 = Color(0xFFFFA30F)
private val Yellow600 = Color(0xFFFFC300)
private val Yellow500 = Color(0xFFFFCF0D)
private val Yellow200 = Color(0xFFFFE786)
private val Yellow100 = Color(0xFFFFF3C2)

private val Green800 = Color(0xFF027854)
private val Green700 = Color(0xFF00A878)
private val Green500 = Color(0xFFA3EA3F)
private val Green100 = Color(0xFFE6F3EE)

private val Pink500 = Color(0xFFFF9EC5)
private val Pink100 = Color(0xFFFAEDF5)

private val Lavender100 = Color(0xFFE8EAFC)

private val Purple100 = Color(0xFFF5E8FD)

private val Latte100 = Color(0xFFFFF1EB)

@Immutable
sealed class BrandPrimary {
    @Immutable
    sealed class Navy : BrandPrimary() {
        object C900 : Navy() { val color: Color = Navy900 }
        object C800 : Navy() { val color: Color = Navy800 }
        object C700 : Navy() { val color: Color = Navy700 }
        object C600 : Navy() { val color: Color = Navy600 }
        object C200 : Navy() { val color: Color = Navy200 }
    }

    @Immutable
    sealed class Red : BrandPrimary() {
        object C800 : Navy() { val color: Color = Red800 }
        object C500 : Navy() { val color: Color = Red500 }
        object C400 : Navy() { val color: Color = Red400 }
        object C200 : Navy() { val color: Color = Red200 }
        object C100 : Navy() { val color: Color = Red100 }
    }
}

@Immutable
sealed class BrandSecondary {
    @Immutable
    sealed class Blue : BrandSecondary() {
        object C900 : Blue() { val color: Color = Blue900 }
        object C700 : Blue() { val color: Color = Blue700 }
        object C500 : Blue() { val color: Color = Blue500 }
        object C300 : Blue() { val color: Color = Blue300 }
        object C100 : Blue() { val color: Color = Blue100 }
    }

    @Immutable
    sealed class Green : BrandSecondary() {
        object C800 : Green() { val color: Color = Green800 }
        object C700 : Green() { val color: Color = Green700 }
        object C500 : Green() { val color: Color = Green500 }
        object C100 : Green() { val color: Color = Green100 }
    }

    @Immutable
    sealed class Yellow : BrandSecondary() {
        object C800 : Yellow() { val color: Color = Yellow800 }
        object C600 : Yellow() { val color: Color = Yellow600 }
        object C500 : Yellow() { val color: Color = Yellow500 }
        object C200 : Yellow() { val color: Color = Yellow200 }
        object C100 : Yellow() { val color: Color = Yellow100 }
    }

    @Immutable
    sealed class Pink : BrandSecondary() {
        object C500 : Pink() { val color: Color = Pink500 }
        object C100 : Pink() { val color: Color = Pink100 }
    }

    @Immutable
    sealed class Latte : BrandSecondary() {
        object C100 : Latte() { val color: Color = Latte100 }
    }

    @Immutable
    sealed class Lavender : BrandSecondary() {
        object C100 : Lavender() { val color: Color = Lavender100 }
    }

    @Immutable
    sealed class Purple : BrandSecondary() {
        object C100 : Purple() { val color: Color = Purple100 }
    }
}

@Immutable
sealed class Neutral {
    @Immutable
    sealed class Grey : Neutral() {
        object CBlack : Grey() { val color: Color = Black }
        object C800 : Grey() { val color: Color = Grey800 }
        object C700 : Grey() { val color: Color = Grey700 }
        object C600 : Grey() { val color: Color = Grey600 }
        object C500 : Grey() { val color: Color = Grey500 }
        object C400 : Grey() { val color: Color = Grey400 }
        object C300 : Grey() { val color: Color = Grey300 }
        object C200 : Grey() { val color: Color = Grey200 }
        object C100 : Grey() { val color: Color = Grey100 }
        object C50 : Grey() { val color: Color = Grey50 }
        object CWhite : Grey() { val color: Color = White }
    }

    @Immutable
    sealed class Background : Neutral() {
        object Red : Background() { val color: Color = Red100 }
        object Yellow : Background() { val color: Color = Yellow100 }
        object Green : Background() { val color: Color = Green100 }
        object Blue : Background() { val color: Color = Blue100 }
        object Lavender : Background() { val color: Color = Lavender100 }
        object Purple : Background() { val color: Color = Purple100 }
        object Pink : Background() { val color: Color = Pink100 }
        object Latte : Background() { val color: Color = Latte100 }
        object Grey : Background() { val color: Color = Grey50 }
    }
}
