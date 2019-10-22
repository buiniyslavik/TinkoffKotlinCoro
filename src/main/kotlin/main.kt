import kotlinx.coroutines.*
import java.time.Duration

class Pet(
    val nickName: String,
    val mealDuration: Long
) {
    suspend fun eat() {
        delay(mealDuration)
        println("$nickName покушал")
    }
}

suspend fun main() {
    val p1 = Pet("Жучка", 1500)
    val p2 = Pet("Волчок", 600)
    val p3 = Pet("Барсик", 2000)
    val p4 = Pet("Борис", 1000)
    val p5 = Pet("Братишка", 1500)

    runBlocking {
        async { p1.eat() }
        async { p2.eat() }
        async { p3.eat() }
        async { p4.eat() }
        async { p5.eat() }
    }

    println("Все поели")
}