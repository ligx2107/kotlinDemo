package day2

/**
 * kotlin中，类的一些说明：
 * 1.kotlin中，类的默认访问权限修饰符为public
 * 2.kotlin中，可以声明一个没有body的空类
 * 3.kotlin中，一个类可以有一个primary构造方法和一个或多个secondary构造方法
 *   primary构造方法是类头的一部分，它位于类名的后面，可以有若干个参数，如果primary构造方法没有任何注解或可见性关键字修饰, 那么constructor关键字可省略
 *   class MyClass constructor(userName: String) {}   ----->  class MyClass(userName: String){} 省略constructor关键字
 *   primary构造方法不能包含任务代码，方法中的参数可以被类内部的初始化代码块(init)访问，或直接为类的属性赋值
 *   类的secondary构造方法必须要直接或间接的调用类的primary构造方法
 * 4.kotlin中，一个类的属性必须初始化，可以定义时直接初始化，也可以在初始化代码块(init)中进行
 */
class Demo constructor(userName: String) {
    // 初始代码块
    init {
        println("userName is $userName")
    }

    // primary构造函数参数直接赋值类的属性
    private var username: String = userName
}

class Person constructor(userName: String) {
    // 定义属性
    private var username: String
    private var age: Int = 20 // 定义属性时直接初始化
    private var address: String

    // 通过初始化代码块对类属性进行初始化
    init {
        println(userName)
        this.username = userName
        this.address = "dalian"
    }

    // 定义secondary构造方法, 直接调用类的primary构造方法
    constructor(userName: String, age: Int) : this(userName) {
        println("userName: $userName, age: $age")
        this.username = userName
        this.age = age
        this.address = "liaoning"
    }

    // 定义secondary构造方法, 间接调用类的primary构造方法
    constructor(userName: String, age: Int, address: String) : this(userName, age) {
        println("userName: $userName, age: $age, address: $address")
        this.address = address
    }
}

/**
 * 在类的primary构造方法中，直接定义类的属性并在构建对象时直接赋值
 * primary构造方法的参数和类属性定义的区别：
 * 类属性定义具有变量或常量定义关键字var或val，可见性限定符可选
 */
class Student constructor(private var userName: String, private val age: Int) {
    // 定义信息打印方法
    fun printInfo() {
        println("username: ${this.userName}, age: ${this.age}")
    }
}

/**
 * 在jvm上，如果类的primary构造函数的所有参数都有默认值，那么kotlin编译器会默认为这个类生成一个无参的构造方法
 * 此构造方法会使用所有参数的默认值，这样做的目的是可以跟Spring等框架更好的集成
 */
class Student2 constructor(val userName: String = "zhangsan")

class EmptyTest(var name: String? = null)

fun main(args: Array<String>) {
    // 创建对象
//    var demo1: Demo = Demo("Mark")
    var p1: Person = Person("Mark")
    var p2: Person = Person("Mark", 20)
    var p3: Person = Person("Mark1", 20, "liaoning")

    println("---------------")

    var s1: Student = Student("zhangsan", 10)
    s1.printInfo()

    println("---------------")
    var s2: Student2 = Student2()
    println(s2.userName) // 直接使用primary构造函数中参数的默认值

    println("---------------")
    var et = EmptyTest()
    if (et.name?.isEmpty() == true) {
        println("111111")
    }
    println(et.name ?: "wwwww")
    println(et.name?.length)
}
