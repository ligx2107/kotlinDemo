// package与java不同，不需要和磁盘真实路径保持一致，是逻辑概念
package day1

import day1_1.multiply as myMultiply

// kotlin程序执行的入口函数
fun main(args: Array<String>) {
    println(sum(1, 2))
    println(sum2(2, 3))
    myPrint(3, 4)

    // val定义常量
    val a: Int = 1
    val b = 2 // 类型推断，变量类型声明可以省略

    // var定义变量
    var c = 3

    // import导入需要的其他包下的方法, 可通过as关键字制定别名
    println(myMultiply(2, 3))
}

// 求和函数
fun sum(a: Int, b: Int): Int {
    return a + b
}

// 简写语法糖 --> sum2函数返回值类型省略，通过类型推断自动判定返回类型
fun sum2(a: Int, b: Int) = a + b

// 无返回值函数，返回值类型为Unit(可省略)
fun myPrint(a: Int, b: Int) {
    // 字符串模版$变量，${表达式}
    println("$a + $b = ${a + b}")
}
