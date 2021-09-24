/**
 * You can edit, run, and share this code. 
 * play.kotlinlang.org 
 */

// companions
class Calc {
    companion object {
        const val PI = 3.14
        fun square(num: Int) = num * num
        fun circleLength(radius: Double) = 2 * PI * radius
    } 
}

// singleton using companion
class DataBase private constructor() {
    companion object {
        var db: DataBase? = null
        fun getInstance(): DataBase {
            // if db exists, then it will be returned
            db?.let {
                return it
            }
            // otherwise, new instance will be created
            val instance = DataBase()
            db = instance
            return instance
        } 
    }
}

// singleton using object
object DataBaseV2 {
    // that is all
}

fun main() {
    println(Calc.square(4))
    println(Calc.circleLength(5.0))
}
