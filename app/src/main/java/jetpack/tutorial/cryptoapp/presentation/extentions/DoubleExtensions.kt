package jetpack.tutorial.cryptoapp.presentation.extentions

import java.text.SimpleDateFormat
import java.util.Date

fun Double.roundBy2Numbers(): Double {
    return Math.round(this * 100.0) / 100.0
}

fun Double.convertToDateTime(): String {
    val date = Date(this.toLong())
    val format = SimpleDateFormat("HH:mm")
    return format.format(date)
}