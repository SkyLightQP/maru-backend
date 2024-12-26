package me.daegyeo.maru.user.application.port.out.dto

import me.daegyeo.maru.user.application.constant.Vendor

data class CreateUserDto(
    val email: String,
    val vendor: Vendor,
    val nickname: String,
)