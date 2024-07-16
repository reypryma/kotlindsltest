package car

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
class EngineShould {

    private val engine = Engine()

    @Test
    fun turnOn() {
        engine.turnOn()

        assertTrue(engine.isTurnedOn)
    }

    @Test
    fun riseTheTemperatureWhenItTurnsOn() {
        engine.turnOn()

        assertEquals(95, engine.temperature)
    }
}