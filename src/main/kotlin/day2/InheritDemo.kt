package day2

/**
 * kotlin与java类似，只能单继承
 * kotlin中，所有类默认情况下都是final无法被继承的
 * 使用open修饰符修饰的类可以被继承
 */
open class Parent constructor(name: String, age: Int) {
    open fun test(info: String) {
        println("info: $info")
    }
}

/**
 * 子类存在primary构造方法，直接在此构造方法上调用父类指定的构造方法完成父类初始化
 */
class Child constructor(name: String, age: Int) : Parent(name, age) {
    override fun test(info: String) {
        println("child")
        super.test(info)
    }
}

/**
 * 子类没有primary构造方法，每个secondary构造方法，都需要以super关键字调用父类指定的构造方法
 * 不同的secondary构造方法可调用不同的父类构造方法
 */
class Child2 : Parent {
    constructor(name: String, age: Int) : super(name, age) {
    }
}

fun main() {
    var c = Child("zhangsan", 1)
    c.test("test")
}
