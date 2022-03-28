package com.example.kotlin_oop_practice

import java.lang.Exception
import java.util.*
import kotlin.concurrent.schedule

class DeciduousTree(name: String, state: String): Tree(name, state) {
    override var leaves = 0
    fun growLeaves() {
        Timer().schedule(0,500) {
            leaves += 10000
            if (leaves > 1000000) {
                this.cancel()
            }
            println("$name Tree has $leaves leaves")
        }
    }

    fun dropLeaves() {
        println(this)
        leaves = 0
    }
}

// constructor
open class Tree(val name: String, var state: String) {
//    var name: String? = null
//    var state: String? = null
    init {
        if (name.isBlank() || state.isBlank()) {
            throw Exception("Name and State must be provided")
        }
        println("Creating a tree $name fro state $state")
    }

    open val leaves = 100000



    val stateUppercase: String
        get() {
            return state.uppercase()
        }
    var spotted: Boolean = false
        set(value) { // if the tree is spotted change the value of dateSpotted var
            field = value // field refers to the spotted property
            if (spotted == true) {
                dateSpotted = Date()
            } else {
                dateSpotted = null
            }
        }
    var dateSpotted: Date? = null
        set(value) {
            if (value != null) {
                if (value > Date()) { // date that is greater than another date is in the future
                    throw Exception("You can not see a tree in the future")
                }
            }
            field = value


        }

    override fun toString(): String {
        return "$name - $state"
    }

}

fun main() {
    val oak = DeciduousTree("Oak", "Iowa")
    val fir = Tree("Fir", "Oregon")
    val palm = Tree("Palm", "Florida")
    val trees = mutableListOf(fir)
    trees.add(oak)
//    val blkan = Tree("  ", "") crash
//    val oak = Tree()
//    oak.name = "Oak"
//    oak.state = "Iowa"
//    println(oak.name)
//    println(fir.name)
//    println(palm.name)
//    println(palm.state)
////    oak.dateSpotted = Date(123412341212334) crashes the code because of the setter we set for dates
//    palm.spotted = true
//    println(palm.spotted)
//    println("Palm spotted on: ${palm.dateSpotted}")
//    palm.spotted = false
//    println("Palm spotted on: ${palm.dateSpotted}")
//    println(oak.stateUppercase)
//
//    oak.growLeaves()
//    println(oak.leaves)
//    oak.growLeaves()
//    println(oak.leaves)
//    oak.dropLeaves()
//    println(oak.leaves)
    println(oak)
    oak.dropLeaves()




}