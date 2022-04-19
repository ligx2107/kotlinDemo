package day2

/**
 * 定义接口
 */
interface MyInterface {
    fun method() {
        println("interface method")
    }
}

/**
 * 定义可继承的类
 */
open class ParentA {
    open fun method() {
        println("ParentA method")
    }
}

/**
 * 子类实现接口，同时继承父类
 */
class MyChild : MyInterface, ParentA() {
    // 子类实现接口并继承父类，接口和父类中存在签名相同的方法，此时子类必须重写该方法
    override fun method() {
        println("Child method")
        // supper<T>指定具体调用哪个父类中的方法
        super<MyInterface>.method()
        super<ParentA>.method()
    }
}

fun main() {
    val child = MyChild()
    child.method()
}
