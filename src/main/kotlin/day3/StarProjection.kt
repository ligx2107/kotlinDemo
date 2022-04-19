package day3

/**
 * star projection --> 星投影
 * Star<out T>: 如果T的上界是TUpper，那么Star<*>就相当于Star<out T>,表示当T的类型未知时，你可以从Star<*>当中安全地读取TUpper类型的值
 * Star<Int T>: Star<*>就相当于Star<in Noting>，表示你无法向其中写入任何值
 * Star<T>：如果T的上界是TUpper，那么Star<*>就相当于读取时的Star<out TUpper>以及写入时的Star<in Noting>
 */

class StarOut<out T>

class StarIn<in T> {
    fun setValue(t: T) {}
}

fun main() {
    var star1: StarOut<Number> = StarOut<Int>()
    var star2: StarOut<*> = star1

    var star3: StarIn<Int> = StarIn<Number>()
    var star4: StarIn<*> = star3
//    star4.setValue(1)
}
