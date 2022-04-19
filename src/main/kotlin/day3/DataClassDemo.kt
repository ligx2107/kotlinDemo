package day3

/**
 * 数据类 --> data class
 * 数据类需满足如下要求：
 * 1. primary构造方法至少有一个参数
 * 2. 所有primary构造方法参数必须被var/val修饰
 * 3. 数据类不能是abstract、open、sealed以及inner的
 *
 * 对于数据类，kotlin编译器会自动生成如下内容：
 * 1. equals/hashCode方法对
 * 2. toString方法，copy方法
 * 3. 针对属性的componentN方法，并且是按照属性的声明顺序来生成的
 *
 * 关于数据类成员的继承要点：
 * 1. 如果数据类中显示定义了equals/hashCode/toString，或者是在父类中将这些方法声明为final的，那么这些方法将不会再生成，直接使用已有的方法
 * 2. 如果父类中拥有componentN方法，并且是open的以及返回值类型兼容，那么编译器会在数据类中生成这些方法并重写父类的方法；如果父类中的这些方法被声明为final或返回值不兼容，则报错
 * 3. 在数据类中显示提供componentN或者copy方法是不允许的
 *
 * componentN作用：用于解构声明
 * 在数据类的primary构造方法中有多少个参数，就是按照顺序依次生成component1，component2，...，componentN
 * 这些方法的返回值就是对应属性的值
 *
 * 在jvm平台上，如果数据类需要无参构造方法，则需要为所有的参数指定默认值
 */
data class DataClassDemo(val name: String, var age: Int, var address: String)

data class DataClassDemo2(var name: String = "zhaoliu") {
}

fun main() {
    var dataClassDemo = DataClassDemo("zhangsan", 18, "dalian")
    println(dataClassDemo)
    var dataClassDemo2 = dataClassDemo.copy(name = "wangwu") // copy方法指定要修改的具体参数信息
    println(dataClassDemo2)

    // 解构声明
    var(name, age, address) = dataClassDemo
    println("$name, $age, $address")

    var dcd = DataClassDemo2()
    println(dcd.name)
}
