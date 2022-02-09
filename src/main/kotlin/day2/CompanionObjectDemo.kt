package day2

/**
 * object declaration  --> 对象声明，直接声明一个对象而不需要通过类来创建
 */
object MyObject {
    var name:String = "test"
    fun method() {
        println("method")
    }
}

/**
 * companion object  --> 伴生对象
 * 在kotlin中，类是没有static方法的，kotlin推荐使用包级别的方法作为静态方法，kotlin会将包级别的函数当作静态方法看待
 * 一个类中最多只允许一个伴生对象，伴生对象的名字可以省略，如果省略，则kotlin编译器会提供一个默认的名字Companion
 * 伴生对象，经过编译后，转换为类的一个静态内部类
 * 虽然伴生对象的成员看起来像是java中的静态成员，但是在运行期，他们依旧是真实对象的实例成员
 * 在jvm上，通过@JvmStatic注解可以将伴生类的成员真正转化为类的静态属性和方法
 */
class CompanionObject {
    companion object CObject {
        val name:String = "companion object"

        @JvmStatic
        fun method(){
            println("companion object method")
        }
    }
}

fun main() {
    // 声明的对象，直接调用对象方法
    MyObject.method()
    println("MyObject.name value: ${MyObject.name}")
    println("------------")

    /**
     * 伴生对象方法及属性调用
     * 方式1：类名.伴生对象名.属性/方法
     * 方式2：类名.伴生对象属性/方法   ---> 类似java静态属性及方法调用方式
     */
    println(CompanionObject.CObject.name)
    CompanionObject.CObject.method()
    println("------------")
    CompanionObject.method()
    println("------------")
    // 打印伴生对象的java类信息
    println(CompanionObject.CObject.javaClass)
}