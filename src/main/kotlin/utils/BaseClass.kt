package utils

open class BaseClass(day: Int) {

    init {
        println()
        println("------")
        println("Day $day")
    }
    open fun firstChallenge() {
        println("First Challenge")
    }

    open fun secondChallenge() {
        println("Second Challenge")
    }

}