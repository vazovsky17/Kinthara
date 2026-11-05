# Kinthara Architecture

**Status:** Early Development
**Platform:** Android
**Language:** Kotlin
**Architecture:** Modular, domain-oriented, deterministic simulation

## 1. Overview

Kinthara is designed as an offline-first, generational life simulation game.

Its architecture separates the simulation engine from the Android application, allowing the core game rules to be developed and tested independently of the user interface.

The primary architectural goals are:

- **Determinism:** Reproducible simulation outcomes.
- **Separation of concerns:** Domain models, simulation rules, persistence, and presentation have distinct responsibilities.
- **Testability:** Core game mechanics can be tested without Android.
- **Extensibility:** New simulation systems can be introduced without tightly coupling them to existing systems.
- **Consistency:** World changes follow explicit rules and preserve domain invariants.
- **Offline operation:** Gameplay does not depend on network services.

These are design goals, not claims that all systems have already been implemented.

## 2. Module Structure

Current modules:

```text
Kinthara/
├── app/
│   └── Android application
│
└── core/
    ├── domain/
    │   └── Domain models and invariants
    │
    └── simulation/
        └── Simulation engine
```

### `:core:domain`

**Responsibility:** Define the game world's fundamental concepts and constraints.

Planned models include:

- `GameDate`
- `Character`
- `CharacterId`
- `WorldState`
- `Relationship`
- `Memory`
- `Household`
- `Asset`

The domain module should remain independent of Android, UI frameworks, databases, and networking.

### `:core:simulation`

**Responsibility:** Implement the rules that advance and transform the game world.

Planned responsibilities include:

- Processing weekly turns
- Resolving player actions
- Evaluating NPC decisions
- Applying world events
- Updating character needs
- Processing economic activity
- Managing aging and mortality
- Producing simulation results

The simulation module depends on the domain module.

### `:app`

**Responsibility:** Provide the Android application and user interface.

Planned responsibilities include:

- Jetpack Compose screens
- Player interaction
- Presentation state
- Game navigation
- Integration with simulation and persistence

The application should not become the primary location for game rules.

## 3. Dependency Direction

Dependencies should flow toward the core domain.

```text
Android Application
        |
        v
Simulation Engine
        |
        v
    Domain
```

The domain layer must not depend on the simulation engine or Android application.

The simulation engine must not depend on Android-specific APIs.

Additional application and persistence modules may be introduced as the project grows.

## 4. Time Model

Kinthara uses a planned weekly turn-based simulation model.

For the initial design:

- One turn represents one in-game week.
- One game year contains 52 simulation weeks.
- Time advances through explicit simulation operations.
- Game rules operate on simulation time rather than wall-clock time.

The simplified calendar avoids unnecessary complexity during early development.

More detailed calendar features may be introduced later.

## 5. World State

`WorldState` is planned as the authoritative representation of the current game world.

It will contain or reference information such as:

- Current simulation date
- Characters and their states
- Relationships
- Households and families
- Economic resources
- Active events
- Simulation metadata

The world state should be updated through controlled simulation operations rather than arbitrary UI mutations.

The precise representation and ownership of world-state collections remain design decisions.

## 6. Turn Processing

The simulation engine is intended to process a complete weekly turn through an explicit pipeline.

Proposed sequence:

1. Validate the current world state and player decisions.
2. Resolve player-selected activities.
3. Evaluate autonomous NPC actions.
4. Resolve interactions and world events.
5. Process economic transactions.
6. Apply aging, health, and other time-dependent changes.
7. Update character knowledge and memories.
8. Advance the simulation calendar.
9. Validate resulting state and produce a turn summary.

The order is provisional and will be refined as interactions between systems are implemented.

A turn should either produce a valid resulting state or fail without partially committing an invalid world state.

## 7. Deterministic Simulation

Determinism is a central design goal.

Given identical:

- Initial world state
- Player decisions
- Random seed
- Simulation rules version
- Content definitions

the engine should produce identical results.

### Randomness

Random operations should use an explicitly controlled random source.

Simulation systems should not independently create uncontrolled random generators.

The design will need to define how random draws are ordered or separated between subsystems.

### Simulation Versioning

Saved games should record the simulation version required to interpret their state.

Changes to rules or random-number consumption may alter outcomes even when the initial seed is unchanged.

Compatibility and migration policies will be established when persistence is implemented.

### Testing

Planned tests include:

- Reproducibility with identical inputs
- Calendar transitions
- Domain invariant enforcement
- Valid state transitions
- Economic conservation and accounting rules
- NPC decision consistency
- Multi-generation simulation stability

Determinism does not imply that the game world lacks uncertainty. It means uncertainty is reproducible under controlled inputs.

## 8. Autonomous NPCs

Non-player characters are intended to act independently of the player.

The initial AI approach is **Utility AI**, not a large language model.

NPC decisions will be influenced by:

- Personal needs
- Individual goals
- Available resources
- Relationships
- Known information
- Current circumstances

A simplified decision model:

```text
Available Actions
       |
       v
Eligibility Checks
       |
       v
Utility Evaluation
       |
       v
Action Selection
       |
       v
World State Changes
```

The design should provide deterministic tie-breaking and controlled randomness where appropriate.

NPC decision-making must use information available to the character, rather than unrestricted access to all hidden world facts.

## 9. Facts, Knowledge, and Memory

Kinthara distinguishes between objective world events and a character's subjective understanding of those events.

### Objective Facts

Facts describe what actually occurred in the simulated world.

Examples:

- A character changed employment.
- A financial transaction occurred.
- Two characters had an argument.

### Character Knowledge

Knowledge describes what an individual character knows or believes.

Characters may possess incomplete, outdated, or incorrect information.

### Memories

Memories represent retained experiences or information that may influence future decisions.

Planned properties include:

- Associated characters
- Event or information reference
- Emotional significance
- Time of acquisition
- Persistence or decay rules

The system should prevent NPCs from acting on information they have no legitimate way of knowing.

## 10. Relationships

Relationships are planned as directional and multidimensional.

For example, character A's feelings toward character B may differ from B's feelings toward A.

Potential relationship dimensions include:

- Trust
- Affection
- Respect
- Attraction
- Resentment

Relationship changes should result from interactions and events rather than arbitrary UI operations.

## 11. Economy and Inheritance

The planned economy includes:

- Employment and income
- Recurring expenses
- Savings and debt
- Ownership of assets
- Transfers between characters
- Inheritance

Economic operations should use explicit transactions and maintain consistent accounting rules.

Inheritance is part of the broader generational simulation.

A character's death may affect:

- Asset ownership
- Family relationships
- Household composition
- Social obligations
- Player succession

Biological, social, and material inheritance should be modeled separately.

## 12. Persistence

Local persistence is planned using Room.

Persistence will eventually be responsible for:

- Saving and loading world state
- Maintaining schema versions
- Applying database migrations
- Preserving simulation metadata
- Supporting recovery from interrupted operations

The simulation engine should not directly depend on Room.

Persistence adapters should translate between storage representations and domain-level state.

## 13. Presentation

The Android interface is planned with Jetpack Compose.

Presentation state will be separated from simulation state.

A proposed interaction flow:

```text
Player Input
     |
     v
Application Logic
     |
     v
Simulation Engine
     |
     v
Updated World State
     |
     v
Presentation State
     |
     v
Compose UI
```

The UI should display simulation outcomes rather than independently calculate them.

## 14. Testing Strategy

Kinthara will prioritize automated tests for its simulation core.

### Unit Tests

Focused tests for domain rules, calculations, and individual systems.

### Determinism Tests

Tests that run identical inputs through the engine and compare results.

### Integration Tests

Tests covering interactions between simulation systems and, later, persistence.

### Long-Running Simulation Tests

Tests that advance worlds across many in-game years to detect inconsistencies, invalid states, or unexpected behavior.

### Android Tests

Tests for application integration and user-facing behavior.

## 15. Current Implementation Status

At the time of this document's initial preparation:

**Implemented:**

- Android application project structure
- Gradle build configuration
- Standalone Kotlin domain module
- Standalone Kotlin simulation module
- Module dependency from simulation to domain
- Successful initial build

**Not yet implemented:**

- Game calendar
- World state model
- Turn-processing engine
- Character simulation
- NPC AI
- Relationships and memory
- Economy and inheritance
- Game persistence
- Playable gameplay interface

This section should be updated as implementation progresses.

## 16. Architectural Principles

The project follows several guiding principles:

1. **Game rules belong in the simulation core.**
2. **Domain models should not depend on Android.**
3. **Randomness must be controlled and reproducible.**
4. **NPCs should act on their own knowledge.**
5. **World changes must preserve explicit invariants.**
6. **Persistence should not dictate simulation rules.**
7. **Features should be implemented incrementally and verified with tests.**
8. **Documentation should distinguish implemented behavior from planned design.**

---

Copyright © 2026 Vazovsky. All rights reserved.

See the repository's `LICENSE` file for usage restrictions.