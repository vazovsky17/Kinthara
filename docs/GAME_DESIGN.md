# Kinthara: Game Design Document

**Version:** 0.1.0
**Status:** Pre-Production / Early Development
**Genre:** Generational Life Simulation
**Platform:** Android
**Developer:** Vazovsky

## 1. Game Concept

Kinthara is a single-player, offline life simulation game about people, relationships, decisions, and the passage of time.

The player experiences the life of a character within a persistent simulated world populated by autonomous individuals.

Every character has their own circumstances, ambitions, relationships, and personal history.

The world continues to evolve through weekly simulation turns, and the consequences of decisions may persist across multiple generations.

**Core fantasy:** Live a life in a world that does not revolve around you, then discover what remains after you are gone.

## 2. Design Pillars

### 2.1 A Living World

Non-player characters should pursue their own lives rather than exist solely to interact with the player.

NPCs may form relationships, change careers, experience financial difficulties, create families, and make decisions independently.

### 2.2 Meaningful Consequences

Player decisions should influence future opportunities, personal circumstances, relationships, and the lives of other characters.

Not every consequence needs to be immediate or predictable.

### 2.3 Generational Continuity

Death is not necessarily the end of a playthrough.

The player may continue through an eligible successor, experiencing a world shaped by previous generations.

### 2.4 Imperfect Information

Characters should not automatically know everything that happens in the world.

Knowledge, beliefs, misunderstandings, and memories influence behavior.

### 2.5 Emergent Stories

The game should prioritize interactions between simulation systems over large collections of predetermined storylines.

Scripted events may complement the simulation, but should not replace its underlying rules.

## 3. Core Gameplay Loop

The game progresses through weekly turns.

During each week, the player selects a limited number of priorities.

The simulation then resolves the consequences of those choices alongside autonomous NPC activity.

### Weekly Loop

1. Review the current character's situation.
2. Examine relationships, finances, needs, and opportunities.
3. Select three or four weekly activity priorities.
4. Advance the simulation by one week.
5. Resolve NPC decisions and world events.
6. Review the results and changes.
7. Plan the next week.

The precise number of available activities and their balancing rules will be determined during prototyping.

## 4. Player Character

The player controls one primary character at a time.

A character is planned to have several interconnected dimensions.

### Identity

- Name
- Age and birth date
- Family connections
- Household
- Personal history

### Physical State

- Health
- Energy
- Biological aging
- Other physical conditions

### Psychological State

- Stress
- Emotional well-being
- Personal needs
- Individual preferences

### Abilities

- Skills
- Education
- Professional experience
- Learned competencies

### Social State

- Relationships
- Reputation
- Social connections
- Family responsibilities

### Economic State

- Employment
- Income
- Expenses
- Savings
- Debt
- Property

The final set of attributes will be determined through gameplay and simulation testing.

## 5. Weekly Activities

Player actions consume limited weekly opportunities.

Potential activity categories include:

| Category | Example activities |
|---|---|
| Career | Work, seek employment, pursue promotion |
| Education | Study, practice skills |
| Social | Meet friends, maintain relationships |
| Family | Spend time with relatives, provide care |
| Health | Rest, exercise, seek treatment |
| Finance | Manage spending, make financial decisions |
| Personal | Pursue hobbies, explore opportunities |

Activities may influence several systems simultaneously.

For example, working additional hours may increase income while reducing energy and available social time.

The player should face trade-offs rather than universally optimal choices.

## 6. Autonomous NPCs

NPCs are independent participants in the simulation.

They should make decisions based on their circumstances rather than follow fixed scripts.

### Planned Decision Model

The initial design uses Utility AI.

Each NPC evaluates available actions according to factors such as:

- Current needs
- Personal goals
- Relationships
- Available resources
- Known information
- Individual preferences
- Expected consequences

Actions that violate eligibility rules should not be considered.

### NPC Diversity

Characters should differ in meaningful ways.

Two NPCs in similar situations may make different decisions because they value different outcomes.

### Information Boundaries

NPCs should not use hidden world information unless they have a legitimate source of knowledge.

This supports misunderstandings, secrets, rumors, and imperfect decision-making.

## 7. Needs and Well-Being

Characters have needs that influence their decisions and long-term outcomes.

Candidate needs include:

- Physical well-being
- Rest
- Social connection
- Financial security
- Personal fulfillment
- Stability

Needs may change through activities, life events, and the passage of time.

The goal is not to force players to maintain every need at maximum value.

Instead, needs should create meaningful tensions between competing priorities.

## 8. Relationships

Relationships are directional and multidimensional.

Character A may trust character B while character B distrusts character A.

Planned relationship dimensions include:

- Affection
- Trust
- Respect
- Attraction
- Resentment

Relationships evolve through interactions, shared experiences, communication, and significant events.

### Relationship Outcomes

Possible long-term developments include:

- Friendship
- Romance
- Partnership
- Family formation
- Rivalry
- Estrangement
- Reconciliation

These outcomes should emerge from character circumstances and simulation rules.

## 9. Knowledge and Memory

The simulation distinguishes between three concepts.

### Facts

What objectively happened in the world.

### Knowledge and Beliefs

What a character knows or believes about the world.

Beliefs may be incomplete, inaccurate, or outdated.

### Memories

What a character retains from experiences or received information.

Memories may affect future decisions and relationships.

For example, two characters may remember the same argument differently and respond to it in different ways.

The initial implementation should prioritize a manageable, testable memory model over unrestricted narrative generation.

## 10. Careers and Education

Characters may develop skills, seek employment, change professions, and pursue education.

Career outcomes should depend on multiple factors rather than a single experience counter.

Potential influences include:

- Skills
- Qualifications
- Experience
- Personal connections
- Available opportunities
- Economic circumstances

Career progression should involve trade-offs between income, time, stress, and personal goals.

## 11. Economy

The economy connects individual decisions with material consequences.

### Planned Systems

- Income
- Living expenses
- Savings
- Debt
- Employment compensation
- Asset ownership
- Financial transfers
- Inheritance

Economic changes should be recorded consistently.

Money should not appear or disappear without a defined source, sink, or accounting rule.

The initial economy may use simplified prices and employment models before introducing broader market behavior.

## 12. Families and Generations

Characters may form families and establish relationships that continue across generations.

### Family Systems

Planned mechanics include:

- Parent-child relationships
- Partnerships
- Household composition
- Family responsibilities
- Family history
- Inheritance

### Generational Influence

A new generation may inherit or be influenced by:

**Biological factors:** Inherited characteristics, where supported by the simulation model.

**Social factors:** Family relationships, upbringing, reputation, and opportunities.

**Material factors:** Property, savings, debts or obligations where applicable.

These categories should remain distinct in the underlying simulation.

## 13. Aging and Death

Characters age as simulation time advances.

Life events and health circumstances may influence mortality.

Death should have persistent consequences for the world.

Potential effects include:

- Changes in household composition
- Inheritance
- Relationship changes
- Family responsibilities
- Loss of social connections
- Succession opportunities

Mortality should be governed by explicit, testable simulation rules.

## 14. Player Succession

When the controlled character dies, the player may be able to continue as an eligible successor.

The precise eligibility rules remain to be designed.

The new playable character should retain their own:

- Identity
- Relationships
- Knowledge
- Memories
- Needs
- Goals
- Economic circumstances

The player does not simply transfer their previous character's personality into another body.

Instead, the player assumes control of an existing individual with an independent history.

If no eligible successor exists, the playthrough may end.

## 15. Events and Consequences

Events represent meaningful changes in the simulated world.

Potential categories include:

- Personal events
- Family events
- Social events
- Career events
- Economic events
- Health events

Events may be generated by simulation rules, character interactions, or authored content.

An event should distinguish between what occurred and which characters learned about it.

Not every event must be visible to the player immediately.

## 16. Progression and Goals

Kinthara is not designed around a single mandatory victory condition.

Players may pursue different life goals:

- Build a family
- Develop a career
- Accumulate wealth
- Establish lasting relationships
- Pursue education
- Improve personal well-being
- Create a multigenerational legacy

Success should depend on the player's chosen priorities rather than one universal score.

## 17. Interface Direction

The Android interface should make complex simulation systems understandable without overwhelming the player.

Design goals include:

- Clear weekly planning
- Readable character information
- Understandable consequences
- Accessible relationship and family views
- Transparent financial information
- A chronological history of important events

The initial prototype should prioritize clarity and usability over visual complexity.

The final visual identity is not yet defined.

## 18. Simulation Balance

The game should avoid dominant strategies that trivialize decision-making.

Important balancing concerns include:

- Time scarcity
- Economic pressure
- Relationship maintenance
- Career progression
- Health and aging
- Unequal starting circumstances
- Long-term consequences

Balancing will require automated simulation tests as well as manual playtesting.

## 19. Minimum Playable Prototype

The first playable prototype should focus on a narrow but complete gameplay loop.

### Target Scope

- One playable character
- A simplified game calendar
- Weekly activity selection
- Basic character needs
- A small population of autonomous NPCs
- Simple relationships
- Basic income and expenses
- Turn summaries
- Local save and load

This is a proposed milestone, not implemented functionality.

More advanced mechanics, including multigenerational succession and sophisticated memory systems, may be introduced after the core loop is stable.

## 20. Long-Term Vision

Kinthara aims to become a simulation where stories emerge naturally from interacting systems.

A character's life may influence people they never meet.

A financial decision may change the opportunities available to a future generation.

An old conflict may affect relationships years later.

A family may grow, decline, separate, reunite, or disappear.

The central goal is to create a world that develops its own history while remaining understandable, consistent, and playable.

## 21. Development Status

Kinthara is currently in early development.

The project structure and foundational Kotlin modules have been created.

The gameplay systems described in this document are planned and subject to change during implementation.

This document is a living design specification and will evolve alongside the codebase.

---

**Kinthara**
Developed by Vazovsky
Copyright © 2026 Vazovsky. All rights reserved.