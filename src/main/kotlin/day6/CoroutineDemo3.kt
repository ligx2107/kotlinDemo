package day6

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

/**
 * 顺序调用suspend函数
 */
fun main3_1() = runBlocking {
    var time = measureTimeMillis {
        var one = doSomethingOne()
        if (one == 1) {
            doSomethingTwo()
        }
    }
    println("completed in time : $time")
}

/**
 * 通过async实现并发调用
 * async返回Deferred对象，继承Job，同时可通过await方法获取所调用方法的返回值
 * launch返回Job对象，无法获取所调用方法的返回值
 */
fun main3_2() = runBlocking {
    var time = measureTimeMillis {
        var one = async { doSomethingOne() }
        var two = async { doSomethingTwo() }
        println("value is: ${one.await() + two.await()}")
    }
    println("completed in time: $time")
}

/**
 * 通过为async设置start参数，实现惰性启动
 * 惰性启动协程，在调用start()或await()时，真正执行
 */
fun main3_3() = runBlocking {
    var time = measureTimeMillis {
        var one = async(start = CoroutineStart.LAZY) { doSomethingOne() }
        var two = async(start = CoroutineStart.LAZY) { doSomethingTwo() }
        // 调用start方法执行协程
        one.start()
        two.start()

        println("value is: ${one.await() + two.await()}")
    }

    println("completed in time: $time")
}

/**
 * 使用async的结构化并发
 */
fun main3_4() = runBlocking {
    var time = measureTimeMillis {
        println("value is: ${concurrentSum()}")
    }

    println("completed in time: $time")
}

/**
 * async结构化并发，异常情况测试
 */
fun main3_5() = runBlocking<Unit> {
    try {
        concurrentSumFaild()
    } catch (e: Exception) {
        println("computation failed with an Exception")
    }
}

/**
 * 上下文中的job, 可使用coroutineContext[Job]来获取
 */
fun main3_6() = runBlocking {
    println("my job is ${coroutineContext[Job]}")
}

/**
 * 子协程：当一个协程在另外一个协程的协程作用域中启动时，它将通过CoroutineScope.coroutineContext继承其上下文
 *       新启动的job将成为父协程job的子job，当父协程取消时，它的所有子协程也会递归地被取消
 * 父协程：父协程总是会等待其所有子协程完成，不必显示跟踪其启动的所有子协程
 */
fun main3_7() = runBlocking {
    // 创建父协程
    val request = launch {
        // 此协程拥有独立的作用域，不属于子协程范畴
        GlobalScope.launch {
            println("job1: run in GlobalScope and execute independently")
            delay(1000)
            println("job1: not affected by cancellation of the request")
        }

        // 创建子协程
        launch {
            delay(100)
            println("job2: I am a child of the request coroutine")
            delay(1000)
            println("jbo2: will not execute this line if parent request is cancelled")
        }
    }

    delay(500)
    // 取消父协程
    request.cancel()
    delay(1000)
    println("main: request cancelled")
}

/**
 * concurrentSum函数发生错误并引发异常，则在其作用域中启动的所有协程都将取消
 */
suspend fun concurrentSum(): Int = coroutineScope {
    var one = async { doSomethingOne() }
    var two = async { doSomethingTwo() }
    one.await() + two.await()
}

suspend fun concurrentSumFaild(): Int = coroutineScope {
    var one = async {
        try {
            delay(Long.MAX_VALUE)
            10
        } finally {
            println("first coroutine was cancelled")
        }
    }

    var two = async<Int> {
        println("second coroutine throws an exception")
        throw Exception()
    }

    one.await() + two.await()
}

suspend fun doSomethingOne(): Int {
    delay(1000)
    println("doSomethingOne called...")
    return 1
}

suspend fun doSomethingTwo(): Int {
    delay(1000)
    println("doSomethingTwo called...")
    return 2
}
