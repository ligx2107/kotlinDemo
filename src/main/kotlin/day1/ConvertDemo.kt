package day1

import java.lang.NumberFormatException

fun main(args: Array<String>) {
    println(convert2Int("2"))
    printMultiply("2", "3b")
    println(convert2Uppercase("ab"))
}

/**
 * 函数返回值类型后的?表示可以为空
 */
fun convert2Int(str: String): Int? {
    try {
        return str.toInt()
    } catch (ex: NumberFormatException) {
        return null
    }
}

fun printMultiply(a: String, b: String) {
    // 此时，a2Int及b2Int为Int?类型而非Int类型
    val a2Int: Int? = convert2Int(a)
    val b2Int: Int? = convert2Int(b)
    // convert2Int方法返回值可为空，则运算前要先做非空判断
    if (null != a2Int && null != b2Int) {
        // 通过非空判断，此时两个变量一定不为空，kotlin可自动将两个变量由Int?转换为Int类型
        println(a2Int * b2Int)
    } else {
        println("param invalid")
    }
}

/**
 * Kotlin中，Any是所有类的父类，相当于java中的Object
 */
fun convert2Uppercase(param: Any): String? {
    // kotlin中，is关键字判断一个实例是否为某一具体类的实例，相当于java中的instanceof关键字
    if (param is String) {
        return param.toUpperCase()
    }
    return null
}
