package day6

import kotlinx.coroutines.*

/**
 * 线程局部变量: ThreadLocal的扩展函数asContextElement可以解决协程在不同线程间调度时，线程局部变量的传递问题
 * asContextElement将创建一个附加的上下文元素，该元素保持treadLocal给定的值并在每次协程切换上下文时恢复该值
 */
val threadLocal = ThreadLocal<String>()
fun main() = runBlocking {
    threadLocal.set("main")
    println("Pre-main, current thread: ${Thread.currentThread().name}, local value: ${threadLocal.get()}")
    // 利用"+"运算符，为协程上下文定义多个元素，此处指定了调度器同时设定线程局部变量
    val job = launch(Dispatchers.Default + threadLocal.asContextElement("launch")) {
        println("launch start, current thread: ${Thread.currentThread().name}, local value: ${threadLocal.get()}}")
        yield()
        println("After yield, current thread: ${Thread.currentThread().name}, local value: ${threadLocal.get()}}")
    }

    job.join()
    println("Post-main, current thread: ${Thread.currentThread().name}, local value: ${threadLocal.get()}")
}
