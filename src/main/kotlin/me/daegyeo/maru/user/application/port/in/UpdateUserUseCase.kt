package me.daegyeo.maru.user.application.port.`in`

import me.daegyeo.maru.user.application.domain.User
import me.daegyeo.maru.user.application.port.`in`.command.UpdateUserUseCaseCommand
import java.util.UUID

fun interface UpdateUserUseCase {
    fun updateUser(
        userId: UUID,
        input: UpdateUserUseCaseCommand,
    ): User
}
