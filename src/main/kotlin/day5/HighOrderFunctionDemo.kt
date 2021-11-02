package day5

/**
 * 高阶函数：接受一个函数作为参数，或返回一个函数作为返回值
 *
 * Lambda表达式格式要求：
 * 1. 一个lambda表达式总是被一对花括号包围
 * 2. 其参数(如果有的话)位于 -> 之前(参数类型可以省略)
 * 3. 执行体位于 -> 之后
 * 4. 在kotlin中，如果一个函数的最后一个参数是个函数，那么可以将lambda表达式作为实参传递进去，并且可以在调用时方法圆括号外去使用
 * 5. 在默认情况下，lambda表达式的最后一个表达式的值会隐式的作为该lambda表达式的返回值
 *    我们可以通过全限定的return语法来显示从lambda表达式返回值
 */

// 标准格式
var multiply: (Int, Int) -> Int = {a,b -> a * b}
var add: (Int, Int) -> Int = {a, b -> a + b}

// 省略类型说明，由Kotlin自动推断
var subtract  = {a: Int, b: Int -> a -b}

// 无入参及返回值
var myAction = { println("hello")}

// 返回值可能为空, _是Kotlin的一个语法糖
var mayReturnNull: (Int, Int) -> Int? = {_, _ -> null}

// lambda表达式整体为可能为null
var functionMayBeNull: ((Int, Int) -> Int)? = null

// 高级函数 ---->  接受一个函数为参数
fun myCalculate(a: Int, b: Int, calculate: (Int, Int) -> Int): Int {
    return calculate(a, b)
}

// 字符串扩展方法
fun String.filter(predicate: (Char) -> Boolean): String {
    var sb = StringBuilder()
    for(index in 0 until length){
        var item = get(index)
        if(predicate(item)){
            sb.append(item)
        }
    }
    return sb.toString()
}

fun main() {
    // 调用已存在的
    println(myCalculate(1, 3, add))
    println(myCalculate(2, 5, multiply))

    // 重新定义
    println(myCalculate(4,2, {x, y -> x - y}))

    // 方法的最后一个参数为一个函数，可以将lambda表达式放在调用方法圆括号外面
    println(myCalculate(3,2){
        x,y -> x - y
    })

    println("abcd".filter { e -> e !== 'c' })

    var strings = arrayOf("hello", "world")


    strings.filter {
        var myFilter = it.length > 3
        // 全限定return语法
        return@filter myFilter
    }
}