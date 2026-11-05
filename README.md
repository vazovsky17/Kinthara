# Kinthara

**A generational life simulation game powered by a deterministic Kotlin simulation engine.**

Kinthara is an Android life simulation project focused on autonomous characters, evolving relationships, personal decisions, and the long-term consequences of life across generations.

The project explores how complex social systems can emerge from relatively simple, interconnected simulation rules.

> **Project Status: Early Development**
>
> Kinthara is currently in its foundational architecture stage. The gameplay systems described below represent planned functionality unless explicitly marked as implemented.

## Vision

Kinthara aims to simulate a living world where characters have their own needs, ambitions, relationships, memories, and personal histories.

Rather than revolving entirely around the player, the world is designed to evolve independently.

The long-term vision includes:

- **Generational gameplay:** Characters age, form families, die, and pass on their legacy.
- **Autonomous NPCs:** Non-player characters make decisions based on needs, goals, and circumstances.
- **Persistent consequences:** Decisions influence relationships, opportunities, reputation, and future generations.
- **Subjective knowledge:** Characters distinguish between objective events and what they personally know or believe.
- **Dynamic relationships:** Relationships evolve through interactions, shared experiences, and conflicting interests.
- **Economic simulation:** Employment, income, expenses, property, and inheritance influence characters' lives.
- **Offline gameplay:** The simulation is designed to run locally without requiring a backend service.

## Technical Stack

| Technology | Purpose |
|---|---|
| Kotlin | Primary programming language |
| Android | Target platform |
| Jetpack Compose | User interface |
| Gradle 9.8.2 | Build system |
| JUnit | Unit testing |

**Planned technologies:** Kotlin Coroutines, StateFlow, and Room for reactive state management and local persistence.

## Architecture

Kinthara separates Android-specific functionality from its core simulation logic.

```text
Kinthara/
├── app/
│   └── Android application and Compose UI
│
├── core/
│   ├── domain/
│   │   └── Domain models and invariants
│   │
│   └── simulation/
│       └── Simulation rules and state transitions
│
└── docs/
    ├── ARCHITECTURE.md
    └── GAME_DESIGN.md
```

### Domain Layer

`:core:domain` is a standalone Kotlin module intended to define the fundamental concepts of the game world.

### Simulation Layer

`:core:simulation` is a standalone Kotlin module intended to implement game-world evolution, character decisions, and deterministic state transitions.

The simulation layer depends on the domain layer, not on Android.

### Application Layer

`:app` contains the Android application and will provide the user interface and integration with the simulation engine.

## Simulation Design

The planned simulation follows a weekly turn-based model.

Each turn will eventually process player decisions, autonomous NPC actions, world events, economic changes, and state updates.

A central design goal is **determinism**: given the same initial world state, decisions, random seed, and simulation version, the engine should produce reproducible results.

This is intended to support automated testing, debugging, and consistent saved-game behavior.

## Development Roadmap

- [x] Initialize the Android project
- [x] Configure the Gradle build
- [x] Create the domain module
- [x] Create the simulation module
- [ ] Implement the game calendar
- [ ] Define the world state
- [ ] Implement deterministic turn processing
- [ ] Introduce character models and needs
- [ ] Implement autonomous NPC decisions
- [ ] Develop relationships and memory systems
- [ ] Implement the economy and inheritance
- [ ] Add local persistence
- [ ] Build the gameplay interface
- [ ] Create an end-to-end playable prototype

This roadmap describes intended milestones and may evolve during development.

## Building

Requirements:

- Android Studio with a compatible Android SDK
- JDK compatible with the configured Android Gradle Plugin
- Gradle 9.8.2 for initial Wrapper generation

The Gradle Wrapper JAR is intentionally excluded from version control.

After cloning the repository, regenerate the Wrapper using an installed Gradle distribution:

```bash
gradle wrapper --gradle-version 9.8.2
./gradlew :app:assembleDebug
```

## Documentation

Additional design and architecture notes are located in the `docs/` directory.

- `docs/ARCHITECTURE.md`
- `docs/GAME_DESIGN.md`

## Copyright and Usage

**Source Available · All Rights Reserved**

Copyright © 2026 Vazovsky.

This repository is publicly accessible for portfolio presentation and source-code review.

No permission is granted to use, reproduce, modify, redistribute, or create derivative works from the source code, except as permitted by applicable law or GitHub's Terms of Service.

This project is **not open-source software**.

See [LICENSE](LICENSE) for further details.

---

**Kinthara** · Developed by Vazovsky