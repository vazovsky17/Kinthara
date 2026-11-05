package dev.vazovsky.kinthara.core.simulation

import dev.vazovsky.kinthara.core.domain.time.GameDate
import dev.vazovsky.kinthara.core.domain.world.WorldState
import kotlin.test.Test
import kotlin.test.assertEquals

class SimulationEngineTest {

    private val engine = SimulationEngine()

    @Test
    fun `advance moves world forward by one week`() {
        val initial = WorldState(
            date = GameDate(year = 1, week = 1),
        )

        val result = engine.advance(initial)

        assertEquals(GameDate(1, 2), result.date)
        assertEquals(GameDate(1, 1), initial.date)
    }

    @Test
    fun `advance produces the same result for the same state`() {
        val initial = WorldState(
            date = GameDate(year = 1, week = 10),
        )

        val first = engine.advance(initial)
        val second = engine.advance(initial)

        assertEquals(first, second)
    }

    @Test
    fun `advance handles year transition`() {
        val initial = WorldState(
            date = GameDate(year = 1, week = 52),
        )

        val result = engine.advance(initial)

        assertEquals(GameDate(2, 1), result.date)
    }
}
