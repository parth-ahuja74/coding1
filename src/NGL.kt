import java.util.Stack

fun main() {
    println(findNGL())
    //findNGR()
}

fun findNGL(): List<Int> {
    val a = listOf<Int>(1,3,2,4)
    val stack = Stack<Int>()
    var result = mutableListOf<Int>()
    for(i in 0..a.size-1) {
        if(stack.empty()) {
            result.add(-1)
        } else if (stack.peek() > a[i]) {
            result.add(stack.peek())
        } else if (stack.peek() <= a[i]) {
            while (stack.isNotEmpty() && stack.peek() <= a[i]) {
                stack.pop()
            }
            if (stack.isEmpty()) {
                result.add(-1)
            } else {
                result.add(stack.peek())
            }
        }
        stack.push(a[i])
    }
    return result
}