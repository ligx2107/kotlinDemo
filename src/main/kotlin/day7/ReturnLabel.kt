package day7

/**
 *@author ligx
 *@title
 *@date 2022/10/12 22:10
 */
fun testReturnLabel(list: List<Int>): List<String>{
    return list.map {
        run label@{
            if (it == 0) return@label "zero"
            if (it == -1) return emptyList()
            "number $it"
        }
    }
}


fun main(){
    println(testReturnLabel(listOf(0,1,2)))
}