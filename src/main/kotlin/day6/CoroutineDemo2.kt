package day6

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main2_1() {
    GlobalScope.launch {
        delay(1000)
        println("thread name -> ${Thread.currentThread().name}: world!")
    }
    println("thread name -> ${Thread.currentThread().name}: hello,")

    // 调用runBlocking的线程会被阻塞，直到块内程序执行完毕
    runBlocking {
        delay(2000)
    }
}

// 结构化并发, main函数为runBlocking包装的协程
fun main2_2() = runBlocking {
    // 在runBlocking作用域中启动一个新协程
    launch {
        delay(1000)
        println("thread name -> ${Thread.currentThread().name}: world!")
    }
    println("thread name -> ${Thread.currentThread().name}: hello, ")
}


// 抽取函数重构
fun main2_3() = runBlocking {
    launch {
        // 在协程内部调用挂起函数
        printWorld()
    }
    println("thread name -> ${Thread.currentThread().name}: hello, ")
}

// 挂起函数
suspend fun printWorld(){
    delay(1000)
    println("thread name -> ${Thread.currentThread().name}: world!")
}

