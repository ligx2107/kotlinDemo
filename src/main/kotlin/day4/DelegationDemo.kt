package day4

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

// 类委托
interface MyInterface1 {
    fun myMethod()
}

class MyInterfaceImpl(val name: String) : MyInterface1 {
    override fun myMethod() {
        println("welcome $name")
    }
}

/**
 * 通过by关键字进行委托声明
 * 委托原理：
 * by关键字后面的对象实际上会被存储在类的内部，编译器则会将父接口中的所有方法都实现出来，并且将实现转移给委托对象来完成
 */
class MyClass1(interface1: MyInterface1) : MyInterface1 by interface1

/**
 * 属性委托
 * 有4种情况在实际开发中比较有用
 * 1. 延迟属性: 指的是属性第一次被访问时才会计算，之后则会将之前的计算结果缓存起来供后续调用
 * 2. 可观测属性
 * 3. 非空属性: 针对读写的非空属性返回一个委托属性，在类创建过程中不需要初始化，如果属性在赋值之前被访问，则会抛异常
 * 4. map属性
 */
class MyDelegate {
    // 两个方法的签名格式有严格的限制
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String = "$thisRef, your delegated property name is ${property.name}"
    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) = println("$thisRef, new value is $value")
}

class MyPropertyClass {
    // 属性的setter和getter委托给by关键字后面的对象处理
    var str: String by MyDelegate()
}

/**
 * 延迟属性
 * 1.SYNCHRONIZED: 默认情况下，延迟属性的计算是同步的，值只会在一个线程中得到计算，所有线程都会使用相同的一个结果
 * 2.PUBLICATION: 如果不需要初始化委托的同步，这样多个线程可以同时执行
 * 3.NONE: 如果确定初始化操作只会在一个线程中执行，这样会减少线程安全方面的开销
 */
val myLazyValue: Int by lazy(LazyThreadSafetyMode.NONE) {
    // 多次调用，只打印一次
    println("hello")
    30
}

/**
 * 非空属性
 */
class MyPerson {
    var address: String by Delegates.notNull<String>()
}
fun main() {
    var interfaceImpl = MyInterfaceImpl("test")
    MyClass1(interfaceImpl).myMethod()
    println("------------------")
    val myPropertyClass = MyPropertyClass()
    myPropertyClass.str = "hello"
    println(myPropertyClass.str)
    println("--------延迟属性---------")
    println(myLazyValue)
    println(myLazyValue)
    println("--------委托属性---------")
    var myPerson = MyPerson()
    myPerson.address = "dalian"
    println(myPerson.address)
}
