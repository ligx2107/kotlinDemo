package day6

import kotlinx.coroutines.*

class CoroutineDemo1 {
    lateinit var innerAsync: Deferred<Any>
    fun test() {
        println("Outer code started on thread: " + Thread.currentThread().name)
        GlobalScope.launch(context = Dispatchers.IO) {
            innerAsync = async {
                println("Inner code started on thread: " + Thread.currentThread().name)
                method1()
            }
            println("coroutine wait on thread: " + Thread.currentThread().name)
            innerAsync.await()
            println("coroutine resumed on thread: " + Thread.currentThread().name)

            innerAsync = async {
                println("Inner code started on thread: " + Thread.currentThread().name)
                method2()
            }
        }

        println("Outer code resumed on thread: " + Thread.currentThread().name)
    }

    private suspend fun method1() {
        withContext(Dispatchers.IO) {
            for (i in 1..5) {
                println("Inner code i: $i on thread: " + Thread.currentThread().name)
            }
        }
    }

    private suspend fun method2() {
        withContext(Dispatchers.IO) {
            for (i in 6..10) {
                println("Inner code i: $i on thread: " + Thread.currentThread().name)
            }
        }
    }
}

fun main1_1() {
    CoroutineDemo1().test()

    Thread.sleep(3000)
}
