package day8

/**
 * 作用域方法(scope function) ---> let, run, apply, with, also
 * 作用域方法：可以在一个对象的上下文中执行某些代码。
 *            当使用lambda表达式调用这些方法时，这些方法会创建一个临时作用域，在此临时作用域中，可以在不使用对象名字的情况下调用该对象。
 *
 * 对象的调用及返回值：
 *  作用域方法调用对象的方式分为两种：
 *      1. 作为lambda表达式的接收者(this)，包括：run, apply, with
 *      2. 作为lambda表达式的参数(it)，包括：let, also
 *  返回值：
 *      1. 返回对象本身，包括：apply, also
 *      2. 返回lambda结果，包括：let, run, with
 *
 * takeIf和takeUnless
 *  takeIf和takeUnless用于检查对象状态，当在对象上调用带有条件判断的takeIf方法时，如果条件成立则返回该对象，否则返回null；takeUnless与takeIf作用相反
 */

fun main(){
    val person = Person("jordan", 51)
    println(testRun(person)) // run返回lambda的结果
    println(testApplay(person)) // apply返回对象本身
    println(testWith(person)) // with返回lambda的结果
    println(testLet(person)) // let返回lambda的结果
    println(testAlso(person)) // also返回对象本身
    println(testTakeIf(person))
    println(testTakeUnless(person))
}

fun testRun(person: Person): String{
    return person.run {
        // 通过接收者this调用对象，this可省略
        println("run info: name -> $name, age -> $age")
        "run"
    }
}

fun testApplay(person: Person): Person{
    return person.apply {
        // 通过接收者this调用对象，this可省略
        println("apply info: name -> $name, age -> $age")
        age = 52
    }
}

fun testWith(person: Person): String{
    return with(person){
        // 通过接收者this调用对象，this可省略
        println("with info: name -> $name, age -> $age")
        age = 53
        "with"
    }
}

fun testLet(person: Person): String{
    return person.let {
        // 通过lambda参数it调用对象，不可省略
        println("let info: name -> ${it.name}, age -> ${it.age}")
        it.age = 54
        "let"
    }
}

fun testAlso(person: Person): Person{
    return person.also {
        // 通过lambda参数it调用对象，不可省略
        println("also info: name -> ${it.name}, age -> ${it.age}")
        it.age = 55
    }
}

fun testTakeIf(person: Person): Person?{
    return person.takeIf { it.age > 50}
}

fun testTakeUnless(person: Person): Person?{
    return person.takeUnless { it.age > 50}
}

data class Person(val name: String, var age: Int)

