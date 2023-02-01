package day6

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.concurrent.thread
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

fun main(){
    println("before in main function")
    GlobalScope.launch {
        testSuspendCoroutine()
    }

    println("after in main function")

    Thread.sleep(5 * 1000)

    testNewThreadInSuspendFunction()
    println("done....")
}

suspend fun testSuspendCoroutine(){
    println("before in suspend function")
    // suspend coroutine
    suspendCoroutine<Unit> {continuation ->
        thread {
            Thread.sleep(2 * 1000)
            continuation.resume(Unit) // 带值恢复，调用suspendCoroutine时可以指定continuation中的返回类型，resume需要调用与之相同的类型
        }
    }
    println("after in suspend function")
}

fun testNewThreadInSuspendFunction(){
    thread {
        println("in new thread -> ${Thread.currentThread().name}")
    }
}