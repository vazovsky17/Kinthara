package dev.vazovsky.kinthara.core.domain.time

data class GameDate(
    val year: Int,
    val week: Int,
) : Comparable<GameDate> {
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

    override fun compareTo(other: GameDate): Int {
        val yearComparison = year.compareTo(other.year)

        return if (yearComparison != 0) {
            yearComparison
        } else {
            week.compareTo(other.week)
        }
    }
}
