/**
 * You can edit, run, and share this code. 
 * play.kotlinlang.org 
 */

// Classes
// primary constructor
class Country(val name: String, val population: Long) {
    // secondary constructor
    constructor(): this("", 0) {
    }
    
    fun printInfo() {
        println("Страна: $name население: $population")
    }
    
    // getter method
    val isSmall: Boolean
    get() = population < 100_000_000
}

// class extension
fun Country.isBig() = population >= 100_000_000

// Enums
enum class Month {
    JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULE, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER
}

enum class Season {
    WINTER, SPRING, SUMMER, FALL
}

// inheritance
open class Worker(val name: String, val age: Int) {
    open fun work() {
        println("Работаю...")
    }
}

class Developer(name: String, age: Int, val language: String): Worker(name, age) {
    override fun work() {
        println("Пишу куод на $language")
    }
}

fun main() {
    val russia = Country("Russia", 144_000_000)
    russia.printInfo()
    println("Большая: " + russia.isBig())
    println("Маленькая: " + russia.isSmall)
    
    val month = Month.FEBRUARY
    val season = when(month) {
       Month.DECEMBER, Month.JANUARY, Month.FEBRUARY -> Season.WINTER
        Month.MARCH, Month.APRIL, Month.MAY -> Season.SPRING
        Month.JUNE, Month.JULE, Month.AUGUST -> Season.SUMMER
        Month.SEPTEMBER, Month.OCTOBER, Month.NOVEMBER -> Season.FALL
    }
    println(season)
    
    val workers: List<Worker> = listOf(
        Worker("Иванов", 25),
        Worker("Сидоров", 20),
        Developer("Савинов", 28, "Swift")
    )
    
    for (worker in workers) {
        worker.work()
    }
}
