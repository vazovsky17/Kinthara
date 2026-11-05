package dev.vazovsky.kinthara.core.domain.character

@JvmInline
value class CharacterId(
    val value: Long,
) {
    init {
        require(value > 0) {
            "Character ID must be positive"
        }
    }
}
