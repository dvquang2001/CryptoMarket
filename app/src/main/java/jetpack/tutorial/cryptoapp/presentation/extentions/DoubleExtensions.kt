package jetpack.tutorial.cryptoapp.presentation.extentions

fun Double.roundBy2Numbers(): Double {
    return Math.round(this * 100.0) / 100.0
}