package com.example.kotlin_oop_practice

import java.util.*

fun main() {
    val saver = Saver() // saves to a database
    val welcomer = Welcomer() // prints welcome messages

    // register a new user
    val usernameGetter = UsernameGetter(saver)
    usernameGetter.getUsername() // TODO save to the database using saver

    // ... later in the program ...

    println("Which user would you like to welcome to the program?")
    val friendUsernameGetter = UsernameGetter(welcomer)
    friendUsernameGetter.getUsername() // TODO print a welcome using welcomer

}

interface UsernameProcessor {
    fun onUsernameEntered(username: String)
}

class UsernameGetter(val usernameProcessor: UsernameProcessor) {

    fun getUsername(): String {
        println("What is your name?")
        val username = Scanner(System.`in`).nextLine()
        // TODO tell something a username has been entered so that it can be processes
        usernameProcessor.onUsernameEntered(username)
        return username
    }
}

class Saver: UsernameProcessor {
    override fun onUsernameEntered(username: String) {
        println("TODO pretend this saves to a database")
    }
}

class Welcomer: UsernameProcessor {
    override fun onUsernameEntered(username: String) {
        println("Welcome $username, thanks for signing up!")
    }
}

