import java.util.Stack

fun main() {
    println(findStockSpan())
}

fun findStockSpan(): List<Int> {
    val a = listOf<Int>(100,80,60,70,60,75,85)
    val stack = Stack<Pair<Int,Int>>()
    var result = mutableListOf<Int>()
    for(i in 0..a.size-1) {
        if(stack.empty()) {
            result.add(-1)
        } else if (stack.peek().first > a[i]) {
            result.add(stack.peek().second)
        } else if (stack.peek().first <= a[i]) {
            while (stack.isNotEmpty() && stack.peek().first <= a[i]) {
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
    for (i in 0..a.size-1) {
        result[i] = i - result[i]
    }
    return result
}