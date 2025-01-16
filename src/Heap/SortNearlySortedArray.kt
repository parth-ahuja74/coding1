package Heap

import java.util.PriorityQueue

fun main() {
    val a = mutableListOf<Int>(6,5,3,2,8,10,9)
    val minHeap = PriorityQueue<Int>()
    val k = 4
    val result = mutableListOf<Int>()
    for(i in 0..a.size-1) {
        if (minHeap.size > k) {
            result.add(minHeap.remove())
        }
        minHeap.add(a[i])
    }
    while(minHeap.size>0) {
        result.add(minHeap.remove())
    }
    println(result)
    println(minHeap)
}