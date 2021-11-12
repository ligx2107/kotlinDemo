package day5

/**
 * 1. 闭包：lambda表达式或匿名函数可访问并修改外层变量, java可以访问，但是不能修改
 * 2. 带接收者的函数字面值：Kotlin提供了这样一种功能，可以通过指定的接收者对象来调用一个函数字面值
 *    在函数字面值内部，可以调用接收者对象的方法而无需使用任何额外的修饰符
 *    这一点非常类似于扩展函数
 */
fun main() {
    var sum: String = ""
    val strings = arrayOf("hello", "world", "bye")
    strings.filter { it.length > 3 }.forEach {
        //闭包, lambda表达式访问并修改了外层数据
        sum += it
    }
    println("sum's value is $sum")

    println("--------------------")

    //  带接收者的函数字面值
    var substract: Int.(other: Int) -> Int = {other -> this - other}
    println(6.substract(3))

    // 匿名函数语法可以让我们指定函数字面值的接收者类型。这样，就可以先去声明一个带有接收者的函数类型变量，然后再去使用它
    var sum1 = fun Int.(other: Int): Int = this + other
    println(6.sum1(7))

    /**
     * takeIf takeUnless
     * takeIf的闭包返回一个判断结果，如果为false时takeIf函数返回null，takeUnless与takeIf逻辑相反
     */
    var user = User("lisi", 3)
    user.takeIf { it.name.isNotBlank() }?.run { println(this.name) } ?: println("")
}

class User(var name: String, var age: Int)