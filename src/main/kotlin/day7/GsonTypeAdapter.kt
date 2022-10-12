package day7

import com.google.gson.GsonBuilder
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type
import java.time.LocalDateTime

/**
 *@author ligx
 *@title
 *@date 2022/7/17 18:39
 */
class TestObject {
    var name: String = ""
    var age: Int = 0
    var birthDay: LocalDateTime? = null
}

class LocalDateAdapter : JsonDeserializer<TestObject> {
    override fun deserialize(p0: JsonElement?, p1: Type?, p2: JsonDeserializationContext?): TestObject {
        val obj1 = TestObject()
        if(p0 != null && p0.isJsonObject){
            val jsonObject = p0.asJsonObject
            obj1.age = jsonObject["age"].asInt
            obj1.name = jsonObject["name"].asString
            val birthdayStr = jsonObject["birthDay"].asString
            obj1.birthDay = LocalDateTime.parse(birthdayStr)
        }

        return obj1
    }
}

fun main(){
    val data = "{\"name\": \"Tom\", \"age\": 18, \"birthDay\": \"2018-12-12T18:20:21\"}";
    val gson = GsonBuilder().registerTypeAdapter(TestObject::class.java, LocalDateAdapter()).create()
    val obj1 =gson.fromJson<TestObject>(data, TestObject::class.java)
    println(obj1.birthDay)
}