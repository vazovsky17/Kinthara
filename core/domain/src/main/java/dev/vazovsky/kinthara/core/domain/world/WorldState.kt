package dev.vazovsky.kinthara.core.domain.world

import dev.vazovsky.kinthara.core.domain.character.Character
import dev.vazovsky.kinthara.core.domain.time.GameDate

data class WorldState(
    val date: GameDate,
    val characters: List<Character> = emptyList(),
    val nextCharacterId: Long = 1L,
) {
    init {
        require(nextCharacterId > 0) {
            "Next character ID must be positive"
        }

        require(characters.map { it.id }.distinct().size == characters.size) {
            "Character IDs must be unique"
        }

        require(characters.all { it.bornAt <= date }) {
            "Characters cannot be born in the future"
        }

        require(characters.all { it.id.value < nextCharacterId }) {
            "Next character ID must be greater than existing IDs"
        }
    }
}
