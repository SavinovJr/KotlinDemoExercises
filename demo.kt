/**
 * You can edit, run, and share this code. 
 * play.kotlinlang.org 
 */

fun main() {

    // filter and map examples 
    val listOfNumbers = mutableListOf<Int>()
    for (i in 0..99) {
        listOfNumbers.add(i)
    }
    val listOfEvenNumbers = listOfNumbers.filter { it % 2 == 0 }
    val doubleNumbers = listOfNumbers.map { it * it }
    println(listOfEvenNumbers)
    println(doubleNumbers)
    
    val randomNumbers = mutableListOf<Int>()
    for (i in 0..999) {
        randomNumbers.add((Math.random()*1000).toInt())
    }
    println(randomNumbers)
    val strings = randomNumbers.filter { it % 3 == 0 || it % 5 == 0}.map { it * it }.sortedDescending().map { "value is $it"}
    println(strings)
    
    
    // take and drop examples
    val array = mutableListOf<Int>()
    for (i in 0..1000) {
        array.add(i)
    }
    val first30 = array.map{ "Employee №$it"}.take(30)
    println(first30)
    
    
    // zip example
    val names = mutableListOf<String>()
    val phones = mutableListOf<Long>()
    
    for (i in 0..1000) {
        names.add("Имя $i")
        phones.add(79_000_000_000 + (Math.random() * 1_000_000_000).toLong())
    }
    val users = names.zip(phones)
    println(users)
    for (user in users) {
        println("Имя: ${user.first} Телефон: ${user.second}")
    }
    
    
    // flatmap and flatten examples
    val revenueByWeek = listOf(
        listOf(2,4,5,8,7),
        listOf(14,1,2,3,7),
        listOf(6,5,5,2,1),
        listOf(3,3,3,3,3),
        listOf(8,8,8,8,8)
    )
    val total = revenueByWeek.flatten()
    val average = total.average()
    println(average)
    
    
    // control work implementation
    val data = mapOf(
        "Январь" to listOf(100,100,100,100),
        "Февраль" to listOf(200,200,-190,200),
        "Март" to listOf(300,180,300,100),
        "Апрель" to listOf(250,-250,100,300),
        "Май" to listOf(200,100,400,300),
        "Июнь" to listOf(200,100,300,300)
    )
    printInfo(data)
    
    
    // extension example
    val list = listOf(5, 10, 15, 20)
    myWith(list) {
        println(sum())
        println(average())
    }
}

// examples of methods
fun crop(str: String) = str.substring(0,5)
fun sum(vararg numbers: Int): Int {
    var result = 0
    for (num in numbers) {
        result += num
    }
    return result
}

// bubble sort
fun sort(numbers: MutableList<Int>): List<Int> {
    for (i in 1 until numbers.size) {
        for (j in numbers.size - 1 downTo i) {
            if (numbers[j] < numbers[j - 1]) {
                var temp = numbers[j]
                numbers[j] = numbers[j - 1]
                numbers[j - 1] = temp
            }
        }
    }
    return numbers
}

// overriding 
fun sort(numbers: Array<Int>) = sort(numbers.toMutableList())
fun sort(vararg numbers: Int) = sort(numbers.toMutableList())

// control work
fun printInfo(data: Map<String, List<Int>>) {
    val validData = data.filter{ it.value.all{ it >= 0 } }
    val revenueByWeek = validData.flatMap{ it.value }.average()
    println("Средняя выручка в неделю: $revenueByWeek")
    val revenueByMonth = validData.size * revenueByWeek
    println("Средняя выручка в месяц: $revenueByMonth")
    val maxMonthsRevenue = validData.map { Pair<String, Int>(it.key, it.value.sum())}
    val sorted = maxMonthsRevenue.sortedBy { it.second }
    
    val maxMonthValue = sorted.last().second
    val maxMonthName =  sorted.last().first
    println("Максимальная выручка в месяц: $maxMonthValue")
    println("Была в следующих месяцах: $maxMonthName")
    
    val minMonthValue = sorted.first().second
    val minMonthName =  sorted.first().first
    println("Минимальная выручка в месяц: $minMonthValue")
    println("Была в следующих месяцах: $minMonthName")
    
    val notValidMonthNames = data.filterNot{ it.value.all{ it >= 0 } }.map { it.key }.joinToString(" ")
    println("Ошибки произошли в следующих месяцах: $notValidMonthNames")
    
    
    val result = modifyString("Hello World") { it.toUpperCase() }
    println(result)
}

// high level method
fun modifyString(string: String, modify: (String) -> String) : String {
    return modify(string)
}

// extensions
inline fun<T> myWith(obj: T, operation: T.() -> Unit) {
    obj.operation()
}
