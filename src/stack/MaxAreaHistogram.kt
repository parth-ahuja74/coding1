package stack

import java.util.*

fun main() {
    val a = intArrayOf(2,1,5,6,2,3)
    val b = findNLL(a)
    val c = findNLR(a)
    println(b)
    println(c)
    var result = mutableListOf<Int>()
    var maxResult = -1
    for(i in 0..a.size-1) {
        val difference = c[i] - b[i] -1
        result.add(difference)
        maxResult = maxOf((difference* a[i]), maxResult)
    }
    println(maxResult)
}

fun findNLL(a: IntArray): MutableList<Int> {
    val stack = Stack<Pair<Int,Int>>()
    var result = mutableListOf<Int>()
    for(i in 0..a.size-1) {
        if (stack.isEmpty()) {
            result.add(-1)
        } else if(stack.peek().first < a[i]) {
            result.add(stack.peek().second)
        } else if (stack.peek().first >= a[i]) {
            while (stack.isNotEmpty() && stack.peek().first >= a[i]) {
                stack.pop()
            }
            if (stack.isEmpty()) {
                result.add(-1)
            } else {
                result.add(stack.peek().second)
            }
        }
        stack.push(Pair(a[i], i))
    }
    return result
}

fun findNLR(a: IntArray): MutableList<Int> {
    val stack = Stack<Pair<Int,Int>>()
    var result = mutableListOf<Int>()
    for(i in a.size-1 downTo 0) {
        if (stack.isEmpty()) {
            result.add(a.size)
        } else if(stack.peek().first < a[i]) {
            result.add(stack.peek().second)
        } else if (stack.peek().first >= a[i]) {
            while (stack.isNotEmpty() && stack.peek().first >= a[i]) {
                stack.pop()
            }
            if (stack.isEmpty()) {
                result.add(a.size)
            } else {
                result.add(stack.peek().second)
            }
        }
        stack.push(Pair(a[i], i))
    }
    return result.reversed().toMutableList()
}