package day3

/**
 * 默认情况下，kotlin类的非空类型属性必须被初始化或声明为abstract
 * 可通过lateinit关键字，声明指定属性为延迟初始化属性，在后续使用过程中再做初始化操作
 * 使用lateinit关键字修饰的属性，需要满足如下三个条件：
 * 1. lateinit关键字只能修饰类体中定义的var属性上，不能修饰primary构造方法中声明的属性
 * 2. 属性不能拥有自定义的getter和setter
 * 3. 属性类型不允许为空且不能是原生数据类型（Byte, Int等）
 */
class LateInitDemo {
    lateinit var name: String
}

fun main() {
    var demo = LateInitDemo()
    demo.name = "hello"
    println(demo.name)
}
