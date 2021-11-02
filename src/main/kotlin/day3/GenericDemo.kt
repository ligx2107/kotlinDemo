package day3

/**
 * 范型(generic), 表示变量类型的参数化
 * 协变和逆变主要描述的是两个类型集合之间的继承关系
 * 1. 如果我们只从对象中读取数据而不写入数据，这样的对象叫做生产者  ---> 协变 java使用<? extends E>  Kotlin使用关键字 out
 *    如果只向对象中写入数据而不读取数据，这样的对象叫做消费者  ---> 逆变 java使用<? super E>  Kotlin使用关键字 in
 * 2. 如果范型类只是将范型类型作为其方法的输出类型，则可以使用out
 *    如果范型类只是将范型类型作为其方法的输入类型，则可以使用in
 */
class GenericDemo<T> constructor(t: T) {
    var variable: T = t
}

class MyClass<out T, in E>(t:T, e:E){
    private var t: T = t
    private var e: E = e
    fun get(): T = this.t
    fun set(value: E) {
        this.e = value
    }
}

fun myTest(myClass: MyClass<String, Number>){
    /**
     * 协变 --> 需要Any，而提供了String，满足extends E的关系
     * 逆变 --> 需要Int，而提供了Number，满足super E的关系
     */
    var myObject: MyClass<Any, Int> = myClass
    println(myObject.get())
    myObject.set(3)
}

class MyStorage<out T>(private var t: T) {
    fun getValue(): T {
        return this.t
    }

    // 使用 @UnsafeVariance注解，屏蔽范型冲突
    fun setValue(value: @UnsafeVariance T){
        this.t = value
    }
}

/**
 * 范型T设置单个上界
 */
class UpperBoundsClass<T: List<T>>{}

/**
 * 通过where关键字指定范型T的多个上界，需同时满足
 */
class UpperBoundsClass2<T> where T: Comparable<T>, T:Any {}

fun main() {
    var g = GenericDemo<String>("hello world")
    //var g = GenericDemo("hello world") --> 借助kotlin的类型推断，具体范型类型可以省略
    println(g.variable)
    println("-------------")
    var g2 = GenericDemo<Int>(20)
    println(g2.variable)
    println("-------------")
    myTest(MyClass("hello world", 2))
    println("-------------")
    var storage: MyStorage<Int> = MyStorage(5)
    var storage2: MyStorage<Any> = storage;
    println(storage2.getValue())
    storage2.setValue("hello") //范型擦除
    println(storage2.getValue())
}