package dev.vazovsky.kinthara.core.simulation.character

import dev.vazovsky.kinthara.core.domain.character.Character
import dev.vazovsky.kinthara.core.domain.character.CharacterId
import dev.vazovsky.kinthara.core.domain.world.WorldState

class CharacterFactory {

    fun create(
        state: WorldState,
        name: String,
    ): WorldState {
        require(state.nextCharacterId < Long.MAX_VALUE) {
            "Character ID space exhausted"
        }

        val character = Character(
            id = CharacterId(state.nextCharacterId),
            name = name,
            bornAt = state.date,
        )

        return state.copy(
            characters = state.characters + character,
            nextCharacterId = state.nextCharacterId + 1,
        )
    }
}
