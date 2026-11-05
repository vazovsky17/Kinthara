package dev.vazovsky.kinthara.core.domain.character

import dev.vazovsky.kinthara.core.domain.time.GameDate
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class CharacterTest {

    private val character = Character(
        id = CharacterId(1),
        name = "Ari",
        bornAt = GameDate(year = 1, week = 20),
    )

    @Test
    fun `character is zero years old at birth`() {
        assertEquals(0, character.ageAt(GameDate(1, 20)))
    }

    @Test
    fun `character ages on their birth week`() {
        assertEquals(1, character.ageAt(GameDate(2, 20)))
    }

    @Test
    fun `character does not age before their birth week`() {
        assertEquals(0, character.ageAt(GameDate(2, 19)))
    }

    @Test
    fun `character age is calculated across multiple years`() {
        assertEquals(5, character.ageAt(GameDate(6, 30)))
    }

    @Test
    fun `character cannot have negative age`() {
        assertFailsWith<IllegalArgumentException> {
            character.ageAt(GameDate(1, 19))
        }
    }

    @Test
    fun `character name cannot be blank`() {
        assertFailsWith<IllegalArgumentException> {
            character.copy(name = " ")
        }
    }
}
