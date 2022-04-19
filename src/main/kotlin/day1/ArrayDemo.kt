package day1

fun main(args: Array<String>) {
//    // 利用工具类intArrayOf创建数组
//    var arr1: IntArray = intArrayOf(1,2,3,4,5)
//    // for循环遍历数组
//    for(item in arr1){
//        println(item)
//    }
//    println("----------")
//    // for循环数组下标
//    for(i: Int in arr1.indices){
//        // 字符串模版
//        println("arr1[$i] = ${arr1[i]}")
//    }
//    println("----------")
//    // 同时获取下标和值进行遍历
//    for((index, value) in arr1.withIndex()){
//        println("arr1[$index] = $value")
//    }

    var dataMap = mutableMapOf<String, MutableList<String>>()
    dataMap.put("1", mutableListOf("str1_1", "str1_2", "str1_3"))
    dataMap.put("2", mutableListOf("str2_1", "str2_2", "str2_3"))
    println(dataMap.values.flatMap { it.toList() })
}
