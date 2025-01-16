package Heap

import java.util.PriorityQueue

fun main() {
    val input = mutableListOf<Int>(7, 10, 4, 3, 20, 15)
    val k = 3
    val a = PriorityQueue<Int> { a, b -> b - a }
    input.map {
        a.add(it)
        println("peek is : " + a.peek())
        println("size is : " + a.size)
        if (a.size > k) {
            a.remove()
        }
    }
    println(a.peek())
}