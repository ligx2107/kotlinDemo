package day2

fun main(args: Array<String>) {
    val a = 11
    val b = 10
    // ..运算符重写，in判断在指定区间之内，左右闭区间
    if(a in 2..b){
        println("a is in range")
    }

    // !in 判断不在指定区间内
    if(a !in 2..b){
        println("a is not in range")
    }

    for(i in 2.rangeTo(10)){
        println(i)
    }

    // 1 until 10左闭右开区间
    for( i in 0 until 10){
        println("i = $i")
    }

    // downTo 左右闭区间
    for (j in 10 downTo 1) {
        println("j = $j")
    }

    println("-----------")

    // 指定步长循环
    for (i in 2..10 step 2){
        println(i)
    }

    println("-----------")

    for(index in 0..99){
        println("index --> $index")
    }
}