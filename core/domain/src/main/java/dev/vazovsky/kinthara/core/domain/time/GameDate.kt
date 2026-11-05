package dev.vazovsky.kinthara.core.domain.time

data class GameDate(
    val year: Int,
    val week: Int,
) {
    init {
        require(year >= 1) {
            "Year must be at least 1"
        }
        require(week in 1..52) {
            "Week must be between 1 and 52"
        }
    }

    fun nextWeek(): GameDate {
        return if (week == 52) {
            GameDate(year = year + 1, week = 1)
        } else {
            copy(week = week + 1)
        }
    }
}
