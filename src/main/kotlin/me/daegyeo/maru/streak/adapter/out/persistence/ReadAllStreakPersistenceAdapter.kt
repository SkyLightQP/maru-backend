package me.daegyeo.maru.streak.adapter.out.persistence

import me.daegyeo.maru.streak.adapter.out.mapper.StreakMapper
import me.daegyeo.maru.streak.application.domain.Streak
import me.daegyeo.maru.streak.application.domain.StreakGroupByDate
import me.daegyeo.maru.streak.application.port.out.ReadAllStreakPort
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class ReadAllStreakPersistenceAdapter(
    private val streakRepository: StreakRepository,
    private val streakMapper: StreakMapper,
) : ReadAllStreakPort {
    override fun readAllStreakByUserId(userId: UUID): List<Streak> {
        return streakRepository.findAllByUserId(userId).map {
            streakMapper.toDomain(it)
        }
    }

    override fun readAllStreakByUserIdAndYearGroupByDate(
        userId: UUID,
        year: Int,
    ): List<StreakGroupByDate> {
        return streakRepository.countAllByUserIdAndCreatedAtGroupByDate(userId, year.toString())
    }
}
