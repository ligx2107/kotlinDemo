package day4

// 简单枚举类
enum class Season {
    SPRING, SUMMER, AUTUMN, WINTER
}

// 带有属性的枚举类
enum class Season2(val temperature: Int) {
    SPRING(10), SUMMER(30), AUTUMN(20), WINTER(10)
}

// 带有方法的枚举类
enum class Season3 {
    SPRING {
        override fun getSeason(): Season3 = SPRING
    },
    SUMMER {
        override fun getSeason(): Season3 = SUMMER
    },
    AUTUMN {
        override fun getSeason(): Season3 = AUTUMN
    },
    WINTER {
        override fun getSeason(): Season3 = WINTER
    };
    abstract fun getSeason(): Season3
}

fun main() {
    var values = Season.values()
    values.forEach { println(it) }
    println("-------------")
    var values1 = Season2.values()
    values1.forEach { println("season name: ${it.name}, temperature: ${it.temperature}") }
    println("-------------")
    Season3.values().forEach { println(it.getSeason().name) }
}
