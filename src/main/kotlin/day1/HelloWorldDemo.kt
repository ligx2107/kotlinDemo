package day1

import java.util.function.Consumer

/**
 *@author ligx
 *@title
 *@date 2021/7/6 16:01
 */

fun main(args: Array<String>) {
    val list: List<String> = listOf("hello", "world", "hello world")
    // for循环遍历
    for (str in list) {
        println(str)
    }
    println("----------")
    // 函数式编程遍历 --> it kotlin语法糖，表示当前元素
    list.forEach(Consumer { println(it) })
    println("----------")
    // 方法引用方式
    list.forEach(System.out::println)
}
