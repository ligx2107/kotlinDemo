package day4

/**
 * 嵌套类和内部类的区别和联系：
 * 1. 嵌套类，对应于java的静态内部类，只能调用外部类的其他嵌套类
 * 2. 内部类，对应于java的成员内部类，需用inner关键字修饰
 */
class OuterClass {
    private var str: String = "hello world"
    // 定义嵌套类
    class NestedClass() {
        fun nestedClassMethod() = "welcome"
    }

    // 定义内部类
    inner class InnerClass() {
        // 内部类方法，调用外部类属性方式
        fun innerClassMethod() = this@OuterClass.str
    }

    // 定义局部嵌套类
    fun getName(): String {
        class LocalNestedClass(var name: String)
        var localName = LocalNestedClass("Mark").name
        return localName
    }
}

fun main() {
    // 嵌套类方法调用
    println(OuterClass.NestedClass().nestedClassMethod())

    // 内部类方法调用
    println(OuterClass().InnerClass().innerClassMethod())

    println(OuterClass().getName())
}
