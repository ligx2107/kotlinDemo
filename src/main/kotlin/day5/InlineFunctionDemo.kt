package day5

/**
 * 内联函数  -->  inline function
 * 字节码层面：内联函数的方法体直接整合到调用者内部，而不是像普通函数那样进行一次调用
 */
inline fun myCalculate(a: Int, b: Int) = a + b

fun main() {
    println(myCalculate(1, 2))
}
