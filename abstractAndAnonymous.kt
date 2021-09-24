/**
 * You can edit, run, and share this code. 
 * play.kotlinlang.org 
 */

// Abstract classes
abstract class Transport(open val name: String) {
    abstract fun drive()
}

// overriding property and methods
class Car(override var name: String = "Машина"): Transport(name) {
    override fun drive() {
        println("Машина едет...")
    }
    
    fun startEngine(): Boolean {
        println("Запускает двигатель")
        return true
    }
}

class Bicycle: Transport("Велосипед") {
    override fun drive() {
        println("Велосипед едет...")
    }
}

// anonymous
fun travel(transport: Transport) {
    transport.drive()
}

interface Waterboy {
    fun bringWater()
}

class SportsMan {
    fun callWaterboy(waterboy: Waterboy) {
        waterboy.bringWater()
    }
    
    inline fun callWaterboy(bringWater: () -> Unit) {
        bringWater()
    }
}

fun main() {
    val car: Transport = Car()
    val bicycle: Transport = Bicycle()
    if (car is Car) {
        car.name = "Машина 2"
    }
    println(car.name)
    
    // anonymous example
    travel(object : Transport("Автобус") {
        override fun drive() {
            println("Автобус едет")
        }
    })
    
    val sportsman = SportsMan()
    sportsman.callWaterboy(object : Waterboy {
        override fun bringWater() {
            println("Несу воду")
        }
    })
    
    // lambda example
    sportsman.callWaterboy { println("Несу воду") }
}
