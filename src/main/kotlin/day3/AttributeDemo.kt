package day3

/**
 *  val/var propertyName: propertyType = initValue
 *      getter()
 *      setter()
 *  val定义类的常量，只有get方法而没有set方法
 *  var定义类的变量，同时具有get及set方法，当不显示提供时，kotlin编译器会默认生成
 *  getter方法的访问属性与类属性的访问属性保持一直
 */
class Person(name: String, address: String) {
    val age: Int
        get() = 18

    var name: String = name
        get() {
            println("get method invoked")
            // field只能用在类属性的get及set方法中，指真正存储属性值的目标
            // TODO kotlin的field属性，需要再理解
            return field
        }
        set(value) {
            println("set method invoked")
            field = value
        }
}

fun main() {
    var person = Person("zhangsan", "dalian")
    // 获取或设置对象属性值的操作，实际是通过属性的get和set方法来操作的
    println(person.name)
    println("----------")
    person.name = "wangwu"
    println(person.name)
}
