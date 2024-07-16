package car

import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceTimeBy
import kotlinx.coroutines.test.runTest
import org.junit.Rule
//import org.junit.jupiter.api.Test
import org.junit.Test

import utils.MainCoroutineScopeRule

class AsyncCarShould {
    private val engine = AsyncEngine()
    private val car = AsyncCar(engine, 6.0)

    @OptIn(ExperimentalCoroutinesApi::class)
    @get:Rule
    var coroutinesTestRule = MainCoroutineScopeRule()

    @Test
    fun carIsLosingFuelWhenTurnOn() = runTest {
        car.turnOnSuspend()
        assertEquals(5.5, car.fuel)
    }

    @Test
    fun carIsTurningOnItsEngineAndIncreasesTheTemperature() = runTest {
        car.turnOnSuspend()
        assertEquals(15, car.engine.temperature)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun carIsTurningOnAndGraduallyIncreaseTemperature() = runTest {
        car.turnOnFlow()
        coroutinesTestRule.scope.advanceTimeBy(1000)
        assertEquals(15, car.engine.temperature)
        coroutinesTestRule.scope.advanceTimeBy(1000)
        assertEquals(25, car.engine.temperature)
        coroutinesTestRule.scope.advanceTimeBy(1000)
        assertEquals(50, car.engine.temperature)
        coroutinesTestRule.scope.advanceTimeBy(1000)
        assertEquals(95, car.engine.temperature)
    }
}