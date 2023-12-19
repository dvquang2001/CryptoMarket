package jetpack.tutorial.cryptoapp.presentation.extentions

import androidx.compose.ui.text.capitalize

fun String.upperFirstCharacterAndLowerRemainingCharacter(): String {
    return this.lowercase().replaceFirstChar {
        it.uppercase()
    }
}