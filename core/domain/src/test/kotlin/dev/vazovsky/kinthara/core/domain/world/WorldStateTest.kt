package dev.vazovsky.kinthara.core.domain.world

import dev.vazovsky.kinthara.core.domain.character.Character
import dev.vazovsky.kinthara.core.domain.character.CharacterId
import dev.vazovsky.kinthara.core.domain.time.GameDate
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class WorldStateTest {

    @Test
    fun `world starts without characters`() {
        val world = WorldState(date = GameDate(1, 1))

        assertEquals(emptyList(), world.characters)
    }

    @Test
    fun `world accepts characters with unique IDs`() {
        val world = WorldState(
            date = GameDate(2, 1),
            characters = listOf(
                Character(CharacterId(1), "Ari", GameDate(1, 1)),
                Character(CharacterId(2), "Mira", GameDate(1, 20)),
            ),
            nextCharacterId = 3L,
        )

        assertEquals(2, world.characters.size)
    }

    @Test
    fun `world rejects duplicate character IDs`() {
        assertFailsWith<IllegalArgumentException> {
            WorldState(
                date = GameDate(2, 1),
                characters = listOf(
                    Character(CharacterId(1), "Ari", GameDate(1, 1)),
                    Character(CharacterId(1), "Mira", GameDate(1, 20)),
                ),
                nextCharacterId = 2L,
            )
        }
    }

    @Test
    fun `world rejects characters born in the future`() {
        assertFailsWith<IllegalArgumentException> {
            WorldState(
                date = GameDate(1, 10),
                characters = listOf(
                    Character(CharacterId(1), "Ari", GameDate(1, 11)),
                ),
            )
        }
    }
}
