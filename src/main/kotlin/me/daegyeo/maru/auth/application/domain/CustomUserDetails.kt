package me.daegyeo.maru.auth.application.domain

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class CustomUserDetails(private val email: String) : UserDetails {
    override fun getAuthorities(): Collection<GrantedAuthority> {
        return listOf("ROLE_USER").map { SimpleGrantedAuthority(it) }
    }

    override fun getPassword(): String {
        return ""
    }

    override fun getUsername(): String {
        return email
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }
}