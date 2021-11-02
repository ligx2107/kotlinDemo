package day3


/**
 * 类型投影 --> 使用处协变
 * 将方法copy的参数from的类型范型使用out协变，保证在方法体内，无法调用该参数写相关操作
 */
fun copy(from: Array<out Any>, to: Array<Any>){
//    assertTrue { from.size == to.size }
    for(i in from.indices){
        to[i] = from[i]
    }
}

/**
 * 使用in实现类型投影
 */
fun reset(to: Array<in String>, index: Int, newValue: String){
    println(to[index])
    to[index] = newValue
}

fun main() {
    val from: Array<Int> = arrayOf(1,2,3,4)
    val to: Array<Any> = Array(4) { "hello$it" }
    for(item in to){
        println(item)
    }
    copy(from, to)

    println("---------------")

    var restArray: Array<Any> = Array(4){"hello $it"}
    for (item in restArray){
        println(item)
    }

    reset(restArray, 1, "world")
    println("---------------")
    for (item in restArray){
        println(item)
    }
}