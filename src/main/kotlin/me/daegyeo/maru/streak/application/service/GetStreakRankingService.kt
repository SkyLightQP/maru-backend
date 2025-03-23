package me.daegyeo.maru.streak.application.service

import me.daegyeo.maru.streak.application.domain.StreakRank
import me.daegyeo.maru.streak.application.port.`in`.GetStreakRankingUseCase
import me.daegyeo.maru.streak.application.port.out.ReadAllStreakPort
import org.springframework.stereotype.Service

@Service
class GetStreakRankingService(
    private val readAllStreakPort: ReadAllStreakPort,
) : GetStreakRankingUseCase {
    override fun getRanking(year: Int): List<StreakRank> {
        return readAllStreakPort.readAllStreakRankOrderByStreakDesc(year)
    }
}
