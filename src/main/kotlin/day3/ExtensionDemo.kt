package day3

/**
 * 扩展函数：在不修改既有类和使用其他设计的情况下，扩展既有类的功能
 * 1. 扩展本身并不会真正修改目标类，并不会在目标类中插入新的属性或方法  ---> 可通过反编译字节码文件进行验证
 * 2. 扩展函数的解析是静态分发的，而不是动态的，即不支持多态，调用只取决于对象的声明类型
 * 3. 调用是由对象声明类型所 决定的，而不是由对象的实际类型决定的
 * 4. 扩展函数与目标类既有函数签名相同，则既有函数优先级更高
 * 5. 可对可空对象进行扩展
 */
class ExtensionDemo {
    fun add(a: Int, b: Int) = a + b
}

// 扩展类的方法
fun ExtensionDemo.substract(a: Int, b: Int) = a - b

/**
 * 扩展静态解析举例
 */
// 声明父类
open class Parent
// 声明子类
class Child : Parent()
// 扩展父类方法
fun Parent.method() = "parent.method"
// 扩展子类方法，且与父类方法同名
fun Child.method() = "child.method"
// 新建打印方法
fun myPrint(parent: Parent) {
    // 扩展方法的调用只取决于对象声明类型，此时parent对象的声明类型为Parent，
    // 所以不论调用myPrint方法时传递的是Parent对象还是Child对象，
    // 此时都静态解析为声明类型Parent的对象
    println(parent.method())
}

/**
 * 对可空对象进行扩展
 */
fun Any?.toString(): String {
    if (this == null) {
        return "null"
    }

    return toString()
}

/**
 * 扩展属性，底层原理与扩展方法类似
 */
class MyExtensionProperty
val MyExtensionProperty.name
    get() = "hello"

/**
 * 伴生对象的扩展
 */
class CompanionObjectExtension {
    companion object MyObject {
    }
}
fun CompanionObjectExtension.MyObject.method() {
    println("hello world")
}

/**
 * 扩展作用域问题
 * 1. 扩展函数定义所在的类叫做分发接受者(dispatch receiver)
 * 2. 扩展函数所作用的目标对象叫做扩展接受者(extension receiver)
 * 3. 当以上两个名字出现冲突时，扩展接受者的优先级最高
 */
class Test {
    fun method() {
        println("Test.method")
    }
}

class ExtensionTest {
    fun method2() {
        println("ExtensionTest.method2")
    }

    // 在分发接受者内定义扩展函数
    fun Test.foo() {
        // 扩展函数内可以调用分发接受者内部定义的其他函数
        method2()
        // 扩展函数内可以调用扩展接受者内部定义的其他函数
        method()
    }

    // 扩展函数内调用的方法在分发接受者和扩展接受者同时存在，此时扩展接受者优先级最高
    fun Test.output() {
        println(toString()) // 此处打印扩展接受者Test的toString方法
        println(this@ExtensionTest.toString()) // 利用this@分发接受者的方式指定调用分发接受者的toString方法
    }

    // 分发接受者内定义的扩展函数，只在分发接受者内部有效，外部无法调用
    fun test() {
        var test = Test()
        test.foo()
        test.output()
    }
}

class TestObject

fun main() {
    var ex = ExtensionDemo()
    println(ex.add(1, 2))
    println(ex.substract(1, 2))
    println("-------扩展静态解析---------")
    myPrint(Child())
    println("-------属性扩展---------")
    val myExtensionProperty = MyExtensionProperty()
    println(myExtensionProperty.name)
    println("-------伴生对象扩展---------")
    CompanionObjectExtension.method()
    println("-------扩展函数作用域问题---------")
    ExtensionTest().test()
    println("------------------------------")
    var map: Map<String, String> = mutableMapOf(
        "a" to "valueA",
        "b" to "valueB",
        "c" to "valueC",
        "d" to "valueD",
        "e" to "valueE"
    )

    map.forEach { (key, value) ->
        println("key: $key, value: $value")
    }
}
