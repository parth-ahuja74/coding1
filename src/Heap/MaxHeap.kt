package Heap

import java.util.PriorityQueue


// Max heap will be used to find k smallest element
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
    while(a.size>0) {
        println(a.peek())
        a.remove()
    }

}