import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

suspend fun foo(): List<Int>{
    delay(1000)
    return listOf(1,2,3)
}

fun main() = runBlocking{
    foo().forEach {
        value -> println(value)
    }
}