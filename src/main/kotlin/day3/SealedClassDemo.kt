package day3

import day3.sealedClasses.Add
import day3.sealedClasses.Calculator
import day3.sealedClasses.Subtract

/**
 * 密封类 ---> sealed class
 * 1. 密封类用来表示受限的类继承结构：当一个值为有限几种的类型, 而不能有任何其他类型, 某种意义上是枚举类的扩展
 *    枚举类中的每个枚举常量只存在一个实例，而密封类的一个子类可以有多个实例
 * 2. 密封类本身是abstract的，不能被实例化
 * 3. 密封类的所有直接子类必须与密封类在同一个文件中(1.1版本之后), 例如本例中的Add和Subtract子类和父类在同一个文件中
 * 4. 密封类常与when表达式一起使用
 */

fun calculate(a: Int, b: Int, cal: Calculator) = when (cal) {
    is Add -> a + b
    is Subtract -> a - b
    // 此处不再需要else来表示其他不满足条件的情况
}

fun main() {
    println(calculate(1, 2, Add()))
    println(calculate(1, 2, Subtract()))
}
