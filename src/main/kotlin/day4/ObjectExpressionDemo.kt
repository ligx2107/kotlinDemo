package day4

/**
 * 对象表达式 --> Object Expression   <----->  java匿名内部类
 * 格式：object [:父类1, 父类2, ...] {}
 * 与java不同，java的匿名内部类要实现一个接口或继承一个类，二者选其一，Kotlin的匿名内部类可以同时存在
 */

interface MyInterface {
    fun interfaceMethod(i: Int)
}

abstract class MyAbstractClass {
    abstract var name: String
    abstract fun myMethod()
}

/**
 * 匿名对象只能在局部变量范围内或者被private修饰的成员变量范围内才能被识别出其真正的数据类型
 * 如果将匿名对象当作一个public方法的返回类型或者public的属性，那么该方法或属性的真正类型就是
 * 该匿名对象所声明的父类型，如果没有声明任何父类型，则为Any，此时匿名对象中声明的任务成员都是无法访问的
 */
class MyClass {

    private var myObject = object {
        fun output() {
            println("output() invoked")
        }
    }

    fun test() {
        println(myObject.javaClass)
        println(myObject::class.java)
        myObject.output()
    }
}

fun main() {
    // 只实现接口的对象表达式
    var oe1 = object : MyInterface {
        override fun interfaceMethod(i: Int) {
            println("i的值$i")
        }
    }
    oe1.interfaceMethod(30)
    println("---------------")

    // 只继承父类的对象表达式
    var oe2 = object : MyAbstractClass() {
        override var name: String = ""
            get() = "mark"
            set(value) {
                field = value
            }

        override fun myMethod() {
            println("myMethod invoked")
        }
    }
    oe2.myMethod()
    println(oe2.name)
    println("---------------")

    // 同时实现接口和继承父类
    var oe3 = object : MyInterface, MyAbstractClass() {
        override fun interfaceMethod(i: Int) {
            println("i的值$i")
        }

        override var name: String = ""
            get() = "mark1"
            set(value) {
                field = value
            }

        override fun myMethod() {
            println("myMethod invoked")
        }
    }
    oe3.interfaceMethod(50)
    println(oe3.name)
    oe3.myMethod()
}
