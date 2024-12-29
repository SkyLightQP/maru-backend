package me.daegyeo.maru.auth.adaptor.`in`.web

import me.daegyeo.maru.auth.adaptor.`in`.web.dto.RegisterUserDto
import me.daegyeo.maru.auth.application.port.`in`.RegisterUserUseCase
import me.daegyeo.maru.auth.application.port.`in`.command.RegisterUserCommand
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RestController
@RequestMapping("/auth")
class AuthController(private val registerUserUseCase: RegisterUserUseCase) {
    @GetMapping("/me")
    fun getMyInfo(): String {
        return "Hello, World!"
    }

    @PostMapping("/register")
    fun registerUser(
        @RequestBody body: RegisterUserDto,
        @RequestHeader("X-Maru-RegisterToken") registerToken: String,
    ): Boolean {
        return registerUserUseCase.registerUser(
            RegisterUserCommand(
                nickname = body.nickname,
                registerToken = registerToken,
            ),
        )
    }

    @DeleteMapping("/logout")
    fun logout(): String {
        return "Hello, World!"
    }
}
