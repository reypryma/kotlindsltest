package car

class Car(
    val engine: Engine,
    var fuel: Double
) {

    fun turnOn() {
        fuel -= 0.5
        engine.turnOn()
    }
}