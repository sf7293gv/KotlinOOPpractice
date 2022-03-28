package com.example.kotlin_oop_practice

abstract class BannerPrinter {
    private fun stars(number: Int): String {
        return "*".repeat(number)
    }

    fun print(message: String) {
        val outputMessage = emphasiseMessage(message)
        println(stars(outputMessage.length))
        println(outputMessage)
        println(stars(outputMessage.length))
    }

    abstract fun emphasiseMessage(message: String): String



}

class UppercaseBannerPrinter: BannerPrinter() {
    override fun emphasiseMessage(message: String): String {
        return message.uppercase()
    }

}
class ExclamationBannerPrinter: BannerPrinter() {
    override fun emphasiseMessage(message: String): String {
        return "$message!!!!!!!!!!!!!!!"
    }

}

fun main() {
    val bannerPrinter = UppercaseBannerPrinter()
    val exclamationBannerPrinter = ExclamationBannerPrinter()
    bannerPrinter.print("hi")
    exclamationBannerPrinter.print("hi")

    displayWelcomeMessage(exclamationBannerPrinter, "HE")
    displayWelcomeMessage(bannerPrinter, "ho")
}

fun displayWelcomeMessage(bannerPrinter: BannerPrinter, message: String) {
    bannerPrinter.print(message)
}