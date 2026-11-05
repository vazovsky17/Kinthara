package dev.vazovsky.kinthara.core.simulation

import dev.vazovsky.kinthara.core.domain.character.CharacterId
import dev.vazovsky.kinthara.core.domain.character.Character
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

    @Test
    fun `advance preserves characters`() {
        val character = Character(
            id = CharacterId(1),
            name = "Ari",
            bornAt = GameDate(1, 1),
        )
        val initial = WorldState(
            date = GameDate(1, 10),
            characters = listOf(character),
            nextCharacterId = 2L,
        )

        val result = engine.advance(initial)

        assertEquals(initial.characters, result.characters)
        assertEquals(11, result.date.week)
        assertEquals(0, result.characters.single().ageAt(result.date))
    }
}
