package dev.vazovsky.kinthara.core.domain.character

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class CharacterIdTest {

    @Test
    fun `character ID stores its value`() {
        val id = CharacterId(42)

        assertEquals(42L, id.value)
    }

    @Test
    fun `character IDs with the same value are equal`() {
        val first = CharacterId(42)
        val second = CharacterId(42)

        assertEquals(first, second)
    }

    @Test
    fun `character ID cannot be zero`() {
        assertFailsWith<IllegalArgumentException> {
            CharacterId(0)
        }
    }

    @Test
    fun `character ID cannot be negative`() {
        assertFailsWith<IllegalArgumentException> {
            CharacterId(-1)
        }
    }
}
