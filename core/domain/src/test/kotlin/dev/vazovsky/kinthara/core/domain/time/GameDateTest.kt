package dev.vazovsky.kinthara.core.domain.time

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class GameDateTest {

    @Test
    fun `nextWeek advances within the same year`() {
        val date = GameDate(year = 1, week = 10)

        val result = date.nextWeek()

        assertEquals(GameDate(1, 11), result)
    }

    @Test
    fun `nextWeek starts a new year after week 52`() {
        val date = GameDate(year = 1, week = 52)

        val result = date.nextWeek()

        assertEquals(GameDate(2, 1), result)
    }

    @Test
    fun `week cannot exceed 52`() {
        assertFailsWith<IllegalArgumentException> {
            GameDate(year = 1, week = 53)
        }
    }

    @Test
    fun `year must be positive`() {
        assertFailsWith<IllegalArgumentException> {
            GameDate(year = 0, week = 1)
        }
    }
}
