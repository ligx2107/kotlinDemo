package day1

fun main(args: Array<String>) {
    println(myConverter("A"))
    println("-----------")
    println(myConverter2("a"))
    println("-----------")
    println(getResult(11))
    println("-----------")
    whenCheck()
}

fun myConverter(str: String): String {
    when (str) {
        "a" -> return "A"
        "b" -> return "B"
        else -> return "other input"
    }
}

// 表达式直接赋值
fun myConverter2(str: String): String = when (str) {
    "a" -> "A"
    "b" -> "B"
    else -> "other input"
}

/**
 * 使用when必须要穷举出所有情况
 * 1和2为确定值情况
 * 3,4,5为可枚举情况
 * in 6..10指定范围
 * else其他情况
 */
fun getResult(a: Int) = when (a) {
    1 -> {
        println("a = 1")
        10
    }
    2 -> {
        println("a = 2")
        20
    }
    3, 4, 5 -> {
        println("a = 3 or 4 or 5")
        30
    }
    in 6..10 -> {
        println("a in 6..10")
        40
    }
    else -> {
        println("a is invalid")
        null
    }
}

/**
 * when关键字做检测
 */
fun whenCheck() {
    var list: List<String> = listOf("hello", "world", "ok")
    when {
        "ok" in list -> println("ok in the list")
    }
    // 函数式编程
    list.filter { it.length > 4 }.map { it.toUpperCase() }.sorted().forEach { println(it) }
}
