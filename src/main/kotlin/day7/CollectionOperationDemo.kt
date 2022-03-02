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

    //20. filterIndexed -> 返回所有满足条件的元素，索引可以作为条件的一部分
    var list5 = listOf(1,2,3,4,5,6)
    println("原始列表: $list5, 从第三位开始的所有偶数: ${list5.filterIndexed { index, i ->  index > 1 && i % 2 == 0}}")

    //21. filterNot -> 返回所有不满足条件的元素
    println("所有基数: ${list.filterNot { it%2 == 0 }}")

    //22. filterNotNull -> 返回所有不为null的元素
    var list6 = listOf(1,2,3,null,4)
    println("原始列表: $list6, 所有不为null的元素: ${list6.filterNotNull()}")

    //23. first -> 返回第一个满足条件的元素，如果没有则抛出NoSuchElementException
    println("第一个满足条件的元素: ${list.first { it > 3 }}")

    //24. firstOrNull -> 返回第一个满足条件的元素，没有则返回null
    println("第一个满足条件的元素，没有返回null: ${list.firstOrNull { it > 5} }")

    //25. find -> 功能同firstOrNull
    println("第一个满足条件的元素，没有返回null: ${list.find { it > 5} }")

    //26. findLast -> 返回最后一个满足条件的元素，没有则返回null
    println("最后一个满足条件的元素，没有返回null: ${list.findLast { it > 4 }}")

    //27. flatMap -> 将嵌套集合元素扁平化
    var list7 = listOf(listOf(1,2), listOf(3,4))
    println("原始集合: $list7, 扁平化处理后: ${list7.flatMap { it }}")

    //28. flatten -> 作用同flatMap
    println("原始集合: $list7, 扁平化处理后: ${list7.flatten()}")

    //29. fold -> 将集合从第一个元素到最后一个元素进行指定操作
    println("以2为初始值，从第一个元素向最后一个元素逐个相乘: ${list.fold(3, {total, next -> total * next})}")

    //30. foldRight -> 功能同fold，但从最后一个元素向第一个元素依次进行指定操作
    println("以2为初始值，从最后一个元素向第一个元素逐个相乘: ${list.foldRight(2, {total, next -> total * next})}")

    //31. get -> 获取指定索引元素，没有则抛出ArrayIndexOutOfBoundsException
    println("第2个元素: ${list.get(1)}")

    //32. getOrElse -> 获取指定索引元素，没有则返回指定默认值
    println("第5个元素: ${list.getOrElse(4) { 10 }}")

    //33. getOrNull -> 获取指定索引元素，没有返回null
    println("第5个元素，没有返回null: ${list.getOrNull(4)}")

    //34. groupBy -> 返回一个根据给定函数分组后的Map
    println("按照奇偶数分组: ${list.groupBy { if(it % 2 == 0) "OU" else "JI" }}")

    //35. indexOf -> 返回指定元素的第一个索引位置，没有返回-1
    println("第一个2的索引位置: ${list.indexOf(3)}")

    //36. indexOfFirst -> 返回第一个满足条件的元素索引位置，没有返回-1
    println("第一个偶数的所以位置: ${list.indexOfFirst { it % 2 == 0 }}")

    //37. indexOfLast -> 返回最后一个满足条件的元素索引位置，没有返回-1
    println("最后一个偶数的所以位置: ${list.indexOfLast { it % 2 == 0 }}")

    //38. last -> 返回最后一个满足调价的元素，没有则抛出NoSuchElementException
    println("最后一个偶数: ${list.last { it % 2 == 0 }}")

    //39. lastIndexOf -> 返回指定元素的最后一个索引位置，没有返回-1
    println("最后一个2的索引位置: ${list.lastIndexOf(2)}")

    //40. lastOrNull -> 返回最后一个给定条件的元素，没有则返回null
    println("最后一个偶数: ${list.lastOrNull { it % 2 == 0 }}")

    //41. map -> 每个元素都根据指定的函数进行转换并将结果以数组形式返回
    println("每个元素都加2: ${list.map { it + 2 }}")

    //42. mapIndexed -> 功能同map，元素索引可以作为条件的一部分
    println("基数索引保持不变，偶数索引加1: ${list.mapIndexed { index, i -> if(index % 2 == 1) i else i + 1 }}")

    //43. mapNotNull -> 功能同map，但不包含为null的元素
    var list8 = listOf(1, 2, null, 3)
    println("每个元素加1，但不包含null: ${list8.mapNotNull { it?.plus(1) }}")

    //44. maxByOrNull -> 返回经过指定函数计算后所产生的最大值的原始值，没有则返回null
    println("取反操作后最大值的原始值: ${list.maxByOrNull { -it }}")

    //45. minByOrNull -> 返回经过指定函数计算后所产生的最小值的原始值，没有则返回null
    var list9 = listOf(-1,-2,-3)
    println("原始数据: $list9, 取反操作后最小值的原始值: ${list9.minByOrNull { -it }}")

    //46. none -> 判断集合是否没有满足条件的元素
    println("没有大于5的元素: ${list.none { it > 5 }}")

    //47. partition -> 将集合分割成两个，第一个集合是所有满足条件的元素，第二个则是所有不满足条件的元素
    println("所有偶数: ${list.partition { it % 2 == 0 }.first}, 所有基数: ${list.partition { it % 2 == 0 }.second}")

    //48. plus -> 将两个集合合并
    println("合并两个集合结果: ${list.plus(listOf(5,6,7))}")

    //49. reduce -> 功能同fold，但没有初始值
    println("从头至尾逐一相乘: ${list.reduce {total, next -> total * next}}")

    //50. reduceRight -> 功能同reduce，但从最后一个元素开始
    println("从尾到头逐一相乘: ${list.reduceRight {total, next -> total * next}}")

    //51. reversed -> 倒序排列集合
    println("倒序集合: ${list.reversed()}")

    //52. single -> 返回满足指定条件的单个元素，如果没有或者多于一个，则抛异常
    println("集中中等于4的唯一元素: ${list.single { it == 2 }}")

    //53. singleOrNull -> 返回满足指定条件的单个元素，没有或者多于一个，则返回null
    println("集合中2多于一个，返回null: ${list3.singleOrNull { it == 2} }")

    //54. sorted -> 列表升序排序
    var list10 = listOf(1,4,2,5)
    println("原始列表: $list10, 排序后列表: ${list10.sorted()}")

    //55. sortedBy -> 按照指定规则进行排序
    println("原始列表: $list10, 排序后列表: ${list10.sortedBy { -it }}")

    //56. sortDescending -> 列表降序排序
    println("原始列表: $list10, 降序排序: ${list10.sortedDescending()}")

    //57. sortByDescending -> 列表按照指定规则降序排序
    println("原始列表: $list10, 取反降序: ${list10.sortedByDescending { -it }}")

    //58. sum -> 元素求和
    println("列表元素总和: ${list.sum()}")

    //59. sumBy -> 元素按照指定规则计算后再求和
    println("元素取反后求和: ${list.sumBy { -it }}")

    //60. slice -> 返回集合中指定索引的元素
    println("第2到第4个元素: ${list.slice(IntRange(1,3))}")
    println("第2到第4个元素: ${list.slice(1..3)}")

    //61. take -> 返回从第一个元素开始的n个元素
    println("前3个元素: ${list.take(3)}")

    //62. takeLast -> 返回从最后一个元素开始的n个元素
    println("后三个元素: ${list.takeLast(3)}")

    //63. takeLastWhile -> 返回从最后一个元素开始满足条件的元素，直到第一个不满足条件元素为止
    var list11 = listOf(1,2,4,2,5,4)
    println("原始集合: $list11, 后几个大于2的元素: ${list11.takeLastWhile { it > 2 }}")

    //64, takeWhile -> 返回从第一个元素开始满足条件的元素，直到第一个不满足条件的元素为止
    println("原始集合: $list11, 前几个小于4的元素: ${list11.takeWhile { it < 4 }}")

    //65. zip -> 返回一个列表，该列表由两个集合中相同索引元素建立的元素对构成，列表长度为最短集合的长度
    var list12 = listOf(10,20)
    println("zip后列表: ${list12.zip(list11)}")
}