package org.netology_exceptions

fun main() {
    agoToText(370)
    agoToText(361)
    agoToText(578)
    agoToText(30440)
    agoToText(82800)
    agoToText(172800)



}

fun agoToText(secondsAgo: Int) {
    when (secondsAgo) {
        in 0..60 -> println("был(а) только что")
        in 60..3600 -> println("был(а) ${secondsAgo / 60} ${endWordsHelper(secondsAgo)} назад")
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
        var seconds = secondsAgo / 60
        if (seconds.toString()[seconds.toString().length - 1].digitToInt() == 1 && seconds <= 51)
            return "минуту"
        else if (minutsAgo.any() { it == seconds && seconds <= 54 })
            return "минуты"
        else if (minutAgo.any() { it == seconds && seconds <= 59 || seconds % 10 == 0 })
            return "минут"
    } else if (secondsAgo > 3600) {
        var hours = secondsAgo / 3600
        if (hourAgo.any() { it == (hours) })
            return "час"
        else if (hoursAgo.any() { it == (hours) })
            return "часа"
        else if (hoursesAgo.any() { it.contains((hours)) })
            return "часов"
    }
    return if (secondsAgo > 3600) "часов" else "минут"

}