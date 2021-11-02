package day2

/**
 * 1.一个类的方法，默认情况下不能被重写，需用open修饰表示可被子类重写
 */
open class Fruit {
    // open修饰方法，可被子类重写
    open fun name(){
        println("Fruit")
    }

    // 默认的方法为final，不能被子类重写
    fun expireDate(){
        println("1 month")
    }

    /**
     * 1.默认的属性为final，不能被子类重写
     * 2.父类val属性可以被子类var或val属性重写，但父类var属性只能被子类var属性重写而不能被val属性重写
     */
    open val color: String = "red"
}

class Apple:Fruit(){
    // 子类用override关键字重写父类方法及属性
    override fun name(){
        println("apple")
    }

    override val color: String = "green"
}

/**
 * 在类的primary构造方法中直接重写父类属性
 */
class Orange(override val color: String): Fruit() {

}

fun main() {
    var fruit: Fruit = Apple()
    fruit.name()
    fruit.expireDate()
    println(fruit.color)
    println(Orange("yellow").color)
}