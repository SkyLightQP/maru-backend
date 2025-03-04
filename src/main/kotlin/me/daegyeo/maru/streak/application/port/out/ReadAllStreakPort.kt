package me.daegyeo.maru.streak.application.port.out

import me.daegyeo.maru.streak.application.domain.Streak
import me.daegyeo.maru.streak.application.domain.StreakGroupByDate
import java.util.UUID

interface ReadAllStreakPort {
    fun readAllStreakByUserId(userId: UUID): List<Streak>

    fun readAllStreakByUserIdAndYearGroupByDate(
        userId: UUID,
        year: Int,
    ): List<StreakGroupByDate>
}
