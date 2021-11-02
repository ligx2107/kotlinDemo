package day5

/**
 * 中缀符号
 * 函数可以通过中缀符号形式来调用，需要满足如下3个条件：
 * 1. 是成员函数或者扩展函数
 * 2. 拥有单个参数
 * 3. 声明时使用infix关键字
 */
class InfixNotationDemo(private var a: Int) {
    infix fun add(b: Int) = this.a + b
}

fun main() {
    var infixDemo = InfixNotationDemo(2)
    // 普通方式调用
    println(infixDemo.add(5))

    // 中缀方式调用
    println(infixDemo add 5)
}