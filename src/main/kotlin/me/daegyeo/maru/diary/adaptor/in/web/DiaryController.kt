package me.daegyeo.maru.diary.adaptor.`in`.web

import me.daegyeo.maru.auth.application.domain.CustomUserDetails
import me.daegyeo.maru.diary.adaptor.`in`.web.dto.CreateDiaryDto
import me.daegyeo.maru.diary.application.domain.Diary
import me.daegyeo.maru.diary.application.port.`in`.CreateDiaryUseCase
import me.daegyeo.maru.diary.application.port.`in`.command.CreateDiaryCommand
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/diary")
class DiaryController(
    private val createDiaryUseCase: CreateDiaryUseCase,
) {
    @PreAuthorize("hasRole('USER')")
    @PostMapping
    fun createDiary(
        @RequestBody body: CreateDiaryDto,
        @AuthenticationPrincipal auth: CustomUserDetails,
    ): Diary {
        return createDiaryUseCase.createDiary(
            CreateDiaryCommand(
                content = body.content,
                userId = auth.userId,
            ),
        )
    }
}
