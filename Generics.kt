/**
 * You can edit, run, and share this code. 
 * play.kotlinlang.org 
 */

// Generics
interface MyList<T> {
    fun get(index: Int): T
    fun add(string: T)
    fun remove(element: T)
    fun removeAt(index: Int)
    fun size(): Int
}

class MyArrayList<T>: MyList<T> {
    
    var array = arrayOfNulls<Any>(10)
    var size = 0
    
    companion object {
        fun<E> myListOf(vararg elements: E) : MyArrayList<E> {
            val list = MyArrayList<E>()
            for (element in elements) {
                list.add(element)
            }
            return list
        }
    }
    
    override fun get(index: Int): T {
        if (index in 0 until size) {
            array[index]?.let {
                return it as T
            }
        }
        throw IndexOutOfBoundsException()
    }
    
    override fun add(string: T) {
        if (size >= array.size) {
            array = array.copyOf(array.size * 2)
        }
        array[size] = string
        size++
    }
    
    override fun remove(element: T) {
        for ((index, string) in array.withIndex()) {
            if (string == element) {
                removeAt(index)
                return
            }
        }
    }
    
    override fun removeAt(index: Int) {
        if (index in 0 until size) {
        	for (i in index until size - 1) {
            	array[i] = array[i + 1]
        	}
        	size--
        } else {
            throw IndexOutOfBoundsException()
        }
    }
    
    override fun size(): Int {
        return size
    }
}

fun main() {
   val list: MyList<String> = MyArrayList()
   for (i in 0..100) {
       list.add("$i")
   }
   
   for (i in 0..90) {
       list.removeAt(0)
   }
   
   for (i in 0 until list.size()) {
       println(list.get(i))
   }
}
