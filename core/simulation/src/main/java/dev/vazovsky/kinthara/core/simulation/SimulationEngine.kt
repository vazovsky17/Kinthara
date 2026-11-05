package dev.vazovsky.kinthara.core.simulation

import dev.vazovsky.kinthara.core.domain.world.WorldState

class SimulationEngine {

    fun advance(state: WorldState): WorldState {
        return state.copy(
            date = state.date.nextWeek(),
        )
    }
}
