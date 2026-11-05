package dev.vazovsky.kinthara.core.domain.character

import dev.vazovsky.kinthara.core.domain.time.GameDate

data class Character(
    val id: CharacterId,
    val name: String,
    val bornAt: GameDate,
) {
    init {
        require(name.isNotBlank()) {
            "Character name cannot be blank"
        }
    }

    fun ageAt(date: GameDate): Int {
        require(date >= bornAt) {
            "Date cannot be earlier than birth date"
        }

        return date.year - bornAt.year -
                if (date.week < bornAt.week) 1 else 0
    }
}
