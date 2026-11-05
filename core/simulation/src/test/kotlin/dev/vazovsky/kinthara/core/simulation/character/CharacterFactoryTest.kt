package dev.vazovsky.kinthara.core.simulation.character

import dev.vazovsky.kinthara.core.domain.time.GameDate
import dev.vazovsky.kinthara.core.domain.world.WorldState
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class CharacterFactoryTest {

    private val factory = CharacterFactory()

    @Test
    fun `first character receives ID one`() {
        val initial = WorldState(date = GameDate(1, 1))

        val result = factory.create(initial, "Ari")

        assertEquals(1L, result.characters.single().id.value)
        assertEquals(2L, result.nextCharacterId)
    }

    @Test
    fun `characters receive sequential IDs`() {
        val initial = WorldState(date = GameDate(1, 1))

        val first = factory.create(initial, "Ari")
        val second = factory.create(first, "Mira")

        assertEquals(
            listOf(1L, 2L),
            second.characters.map { it.id.value },
        )
        assertEquals(3L, second.nextCharacterId)
    }

    @Test
    fun `character is born on current world date`() {
        val initial = WorldState(date = GameDate(3, 12))

        val result = factory.create(initial, "Ari")

        assertEquals(GameDate(3, 12), result.characters.single().bornAt)
    }

    @Test
    fun `creation does not modify original world`() {
        val initial = WorldState(date = GameDate(1, 1))

        factory.create(initial, "Ari")

        assertEquals(emptyList(), initial.characters)
        assertEquals(1L, initial.nextCharacterId)
    }

    @Test
    fun `same state and name produce same result`() {
        val initial = WorldState(date = GameDate(1, 1))

        val first = factory.create(initial, "Ari")
        val second = factory.create(initial, "Ari")

        assertEquals(first, second)
    }

    @Test
    fun `blank name is rejected`() {
        val initial = WorldState(date = GameDate(1, 1))

        assertFailsWith<IllegalArgumentException> {
            factory.create(initial, " ")
        }
    }
}
