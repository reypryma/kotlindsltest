package car

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class AsyncCar(
    val engine: AsyncEngine,
    var fuel: Double
) {
    fun turnOnSuspend() {
        fuel -= 0.5
        CoroutineScope(Dispatchers.Main).launch {
            engine.suspendTypeTurnOn()
        }
    }

    fun turnOnFlow() {
        fuel -= 0.5
        CoroutineScope(Dispatchers.Main).launch {
            engine.flowTypeTurnOn().collect {
                println("Run flow")
            }
        }
    }
}