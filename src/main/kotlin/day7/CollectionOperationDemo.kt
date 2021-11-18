package day7

val list = listOf(1,2,3,4)

fun main() {
    println("list: $list")
    //1. any -> 至少一个元素满足判断条件
    println("list是否满足一个元素大于2: ${list.any { it > 2}}")

    //2. all -> 全部元素都满足判断条件
    println("list所有元素都小于4: ${list.all { it <= 4 }}")

    //3. associate -> 按照指定的规则，将list转map
    println("list按规则转map: ${list.associate { Pair("a$it", it*2) }}")

    //4. associateBy -> 按照指定的规则，将list转map
    //4.1 associateBy -> 只转换key
    println("list按规则只转key: ${list.associateBy { "key$it" }}")
    //4.2 associateBy -> 转换key和value
    println("list按规则转换key及value: ${list.associateBy({"key$it"}, {"value$it"})}")

    //5. average -> 求集合的平均值，仅限(Byte,Short,Int,Long,Float,Double)
    println("list平均数: ${list.average()}")

    //6. component1..componentN -> 返回集合的第n个元素
    println("第一个元素: ${list.component1()}, 第三个元素: ${list.component3()}")
    //6.1 超出元素个数，抛异常 ArrayIndexOutOfBoundsException
    //list.component5()

    //7. contain -> 判断是否包含一个元素
    println("list包含1: ${list.contains(1)}")

    //8. containAll -> 判断包含所有元素
    val sublist = listOf(1,2,6)
    println("list包含sublist所有元素: ${list.containsAll(sublist)}")

    //9. count -> 满足条件元素个数
    println("list中元素个数：${list.count()}, 偶数个数: ${list.count { it%2 == 0 }}")

    //10. distinct -> 去重
    var list2 = listOf(1,2,2,3,4)
    println("原始数据: $list2, 去重后: ${list2.distinct()}")

    /**
     * 11. distinctBy -> 按条件去重
     * public inline fun <T, K> Iterable<T>.distinctBy(selector: (T) -> K): List<T> {
         val set = HashSet<K>()
         val list = ArrayList<T>()
         for (e in this) {
            val key = selector(e)
            if (set.add(key))
            list.add(e)
         }
        return list
      }
     */
    var list3 = listOf(4,2,2,6,9)
    println("原始数据: $list3, 基数偶数各一个: ${list3.distinctBy { it%2 == 0 }}")

    //12. drop -> 获取不包含前n个元素的列表
    println("舍去前两个元素后列表: ${list.drop(2)}")

    //13. dropLast -> 获取不包含后n个元素的列表
    println("舍去后两个元素后列表: ${list.dropLast(2)}")

    //14. dropWhile -> 从列表头开始，舍去满足条件的元素直到第一个不满足条件的元素截止
    var list4 = listOf(1,3,5,2,7,4)
    println("原始列表: $list4, 舍去不满足条件的元素后列表: ${list4.dropWhile { it%2 == 1 }}")

    //15. dropLastWhile -> 从列表尾开始，舍去满足条件的元素直到第一个不满足条件的元素截止
    println("原始列表: $list4, 舍去不满足条件的元素后列表: ${list4.dropLastWhile { it%2 == 0 }}")

    //16. elementAt -> 返回指定索引位置的元素, 如果索引越界则抛异常
    println("第二个元素: ${list.elementAt(1)}")

    //17. elementAtOrElse -> 返回指定索引的元素，如果越界则返回指定的默认值
    println("第5个元素: ${list.elementAtOrElse(4) { 7 }}")

    //18. elementAtOrNull -> 返回指定索引的元素，如果越界则返回null
    println("第五个元素: ${list.elementAtOrNull(4)}")

    //19. filter -> 返回满足条件的元素
    println("所有偶数: ${list.filter { it%2 == 0 }}")

    //20. filterIndexed -> 返回所有满足条件的元素，从特定的索引开始
    var list5 = listOf(1,2,3,4,5,6)
    println("原始列表: $list5, 从第三位开始的所有偶数: ${list5.filterIndexed { index, i ->  index > 1 && i%2 == 0}}")

    //21. filterNot -> 返回所有不满足条件的元素
    println("所有基数: ${list.filterNot { it%2 == 0 }}")

    //22. filterNotNull -> 返回所有不为null的元素
    var list6 = listOf(1,2,3,null,4)
    println("原始列表: $list6, 所有不为null的元素: ${list6.filterNotNull()}")
}