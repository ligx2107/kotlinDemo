package day7

/**
 * 使用vararg修饰符标记可变数量参数，
 * 一个函数只允许定义一个可变数量参数
 */
fun t1(vararg params: String){
    params.forEach { println(it) }
}

/**
 * 可变数量参数不在参数列表的最后位置
 */
fun t2(vararg params: String, p2: String){
    params.forEach { println(it) }
    println(p2)
}

fun main() {
    // 单个传参
    t1("h","e","l")

    // 使用伸展运算符(spread operator) *
    t1(*arrayOf("w","o"))

    // 函数可变数量参数不在参数列表最后位置，调用时，后续参数需使用具名方式传参
    t2(*arrayOf("1","2"), p2 = "3")
}