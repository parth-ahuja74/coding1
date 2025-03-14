package Heap

import java.util.PriorityQueue


// Min heap will be used to find k largest element
fun main() {
    val input = mutableListOf<Int>(7, 10, 4, 3, 20, 15)
    val k = 3
    val a = PriorityQueue<Int>()
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