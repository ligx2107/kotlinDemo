package day2

fun main(args: Array<String>) {
    var str1 = "hello \n world"
    println(str1)

    var str2 = "hello \\n world"
    println(str2)

    // kotlin扩展字符串
    var str3 = """hello
        \n world
    """
    println(str3)
}
