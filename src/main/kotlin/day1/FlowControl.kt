package day1

fun main(args: Array<String>) {
    val x = 10
    val y = 20

    // if表达式直接赋值给变量
    val max = if (x > y) x else y
    var min = if (x < y) x else y
    println("max = $max, min = $min")

    var max1 = if (x > y) {
        println("x > y")
        x
    } else {
        println("x < y")
        y
    }
    println(max1)
}
