package org.netology_exceptions

fun main() {
    agoToText(370)
    agoToText(361)
    agoToText(578)
    agoToText(30440)


}

fun agoToText(secondsAgo: Int) {
    when (secondsAgo) {
        in 0..60 -> println("был(а) только что")
        in 60..3600 -> println("был(а) ${secondsAgo / 60} ${endWordsHelper(secondsAgo / 60)} назад")
        in 60 * 60 + 1..24 * 60 * 60 -> println("был(а) ${secondsAgo / (60 * 60)} ${endWordsHelper(secondsAgo)} назад")
        in 24 * 60 * 60 + 1..48 * 60 * 60 -> println("был(а) вчера")
        in 48 * 60 * 60 + 1..72 * 60 * 60 -> println("был(а) позавчера")
        else -> println("был(а) давно")

    }
}

fun endWordsHelper(secondsAgo: Int): String {
    val minutsAgo = arrayOf(2, 3, 4)
    val minutAgo =
        arrayOf(5, 6, 7, 8, 9, 11, 12, 13, 14)
    val hourAgo = arrayOf(1, 21)
    val hoursAgo = arrayOf(2, 3, 4, 22, 23, 24)
    val hoursesAgo = arrayOf(5..20)

    if (secondsAgo <= 3600) {
        if (secondsAgo.toString()[secondsAgo.toString().length - 1].digitToInt() == 1 && secondsAgo <= 51)
            return "минуту"
        else if (minutsAgo.any() { it == secondsAgo && secondsAgo <= 54 })
            return "минуты"
        else if (minutAgo.any() { it == secondsAgo && secondsAgo <= 59 || secondsAgo % 10 == 0 })
            return "минут"
    } else if (secondsAgo > 3600)
        if (hourAgo.any() { it == (secondsAgo / 60) })
            return "час"
        else if (hoursAgo.any() { it == (secondsAgo / 60) })
            return "часа"
        else if (hoursesAgo.any() { it.contains((secondsAgo / 60)) })
            return "часов"
    return if (secondsAgo > 3600) "часов" else "минут"
}